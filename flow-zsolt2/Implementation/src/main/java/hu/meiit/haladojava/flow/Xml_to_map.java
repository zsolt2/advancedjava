package hu.meiit.haladojava.flow;


import hu.meiit.haladojava.flow.exceptions.NotInicializedException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Xml_to_map extends BaseFlowImplementation {

    private Map<String, Integer> data;
    private Document document;
    private ObjectOutputStream out;

    public class SimpleErrorHandler implements ErrorHandler {
        public void warning(SAXParseException e) throws SAXException {
            isValid = false;
        }

        public void error(SAXParseException e) throws SAXException {
            isValid = false;
        }

        public void fatalError(SAXParseException e) throws SAXException {
            isValid = false;
        }
    }

    protected boolean validateInput(InputStream input) {
        SAXReader reader = new SAXReader();
        reader.setValidation(true);
        reader.setErrorHandler(new SimpleErrorHandler());
        try {
            document = reader.read(input);
        } catch (DocumentException e) {
            return false;
        }
        return true;
    }

    @Override
    public void setInput(InputStream stream) throws IllegalArgumentException {
        try {
            pos = new PipedOutputStream();
            pis = new PipedInputStream(pos);
            isValid = validateInput(stream);
        } catch (IOException e) {
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

        List<Node> nodes = document.selectNodes("/root/row");
        data = new HashMap<>();
        for (Node node : nodes) {
            data.put(node.selectSingleNode("name").getText(), Integer.parseInt(node.selectSingleNode("points").getText()));
        }

        try {
            out = new ObjectOutputStream(pos);
            out.writeObject(data);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
