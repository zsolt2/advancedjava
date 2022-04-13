package hu.meiit.haladojava.flow;

import hu.meiit.haladojava.flow.exceptions.NotInicializedException;

import java.io.*;
import java.util.Map;

public class Map_to_aggregate extends BaseFlowImplementation {
    private Map<String, Integer> data;
    private ObjectInputStream in;
    private ObjectOutputStream out;


    protected void readInput(ObjectInputStream input) throws IOException, ClassNotFoundException {
        data = (Map<String, Integer>) input.readObject();

    }

    @Override
    public void setInput(InputStream stream) throws IllegalArgumentException {
        try {
            in = new ObjectInputStream(stream);
            pos = new PipedOutputStream();
            pis = new PipedInputStream(pos);
            readInput(in);
            isValid = true;
        } catch (IOException | ClassNotFoundException e) {
            isValid = false;
            throw new IllegalArgumentException("Not a valid input" + e.getMessage());
        }
    }

    @Override
    public InputStream getOutput() {
        return pis;
    }

    @Override
    public Object getData() {
        return data;
    }

    @Override
    public void step() throws NotInicializedException {
        if (!isValid) {
            throw new NotInicializedException("Input is not inicialized properly");
        }

        Integer result = data.values().stream().mapToInt(Integer::intValue).sum();

        try {
            out = new ObjectOutputStream(pos);
            out.writeObject(result);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
