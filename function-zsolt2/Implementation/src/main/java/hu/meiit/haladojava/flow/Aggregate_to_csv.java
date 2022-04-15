package hu.meiit.haladojava.flow;

import hu.meiit.haladojava.flow.exceptions.NotInicializedException;

import java.io.*;

public class Aggregate_to_csv extends BaseFlowImplementation {
    private Integer data;
    private PrintStream out;

    protected void readInput(ObjectInputStream input) throws IOException, ClassNotFoundException {
        if (input != null) {
            data = (Integer) input.readObject();
            input.close();
        }
    }

    @Override
    public void setInput(InputStream stream) throws IllegalArgumentException {

        try {
            ObjectInputStream in = new ObjectInputStream(stream);
            pos = new PipedOutputStream();
            pis = new PipedInputStream(pos);
            isValid = true;
            readInput(in);
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
        out = new PrintStream(pos);
        out.println("result");
        out.println(data.toString());
        out.close();
    }

}
