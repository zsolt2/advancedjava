package hu.meiit.haladojava.flow;

import hu.meiit.haladojava.flow.exceptions.NotInicializedException;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.*;

public class Aggregate_to_xml extends BaseFlowImplementation {
    private Integer data;
    private ObjectInputStream in;
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
            in = new ObjectInputStream(stream);
            pos = new PipedOutputStream();
            pis = new PipedInputStream(pos);
            readInput(in);
            isValid = true;
        } catch (IOException | ClassNotFoundException e) {
            isValid = false;
            e.printStackTrace();
            throw new IllegalArgumentException("Not a valid input");
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
        try {
            Document document = DocumentHelper.createDocument();
            Element root = document.addElement("root");
            root.addElement("result").addText(data.toString());
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer;
            out = new PrintStream(pos);
            writer = new XMLWriter(out, format);
            writer.write(document);
            out.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
