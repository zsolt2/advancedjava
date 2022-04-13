package hu.meiit.haladojava.flow;

import hu.meiit.haladojava.flow.exceptions.NotInicializedException;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Csv_to_xml extends BaseFlowImplementation {

    private BufferedReader reader;
    private List<String> data;
    private InputStream in;

    private boolean isValidCsv(InputStream input) {
        data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            String firstLine = reader.readLine();

            if (!firstLine.matches("^(name,points)|(\"name\",\"points\")$"))
                return false;
            data.add(firstLine);

            while (reader.ready()) {
                String line = reader.readLine();
                if (!line.matches("^(\"?)[a-zA-Z]+\\1,\\1[0-9]+\\1$")) {
                    return false;
                }
                data.add(line);
            }
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
        return true;
    }


    protected boolean validateInput(InputStream input) {
        if (!isValidCsv(input)) {
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
        }
        if (!isValid) {
            throw new IllegalArgumentException("Not a valid input");
        }
    }

    @Override
    public InputStream getOutput() {
        return pis;
    }

    @Override
    public Object getData() {
        return String.join("\n", data);
    }

    @Override
    public void step() throws NotInicializedException {

        if (!isValid) {
            throw new NotInicializedException("Input is not inicialized properly");
        }

        try {

            Document document = DocumentHelper.createDocument();
            Element root = document.addElement("root");

            for (String line : data.subList(1, data.size())) {

                String[] values = line.split(",");

                Element row = root.addElement("row");
                row.addElement("name").addText(values[0]);
                row.addElement("points").addText(values[1]);

            }

            OutputFormat format = OutputFormat.createCompactFormat();
            XMLWriter writer;
            writer = new XMLWriter(format);
            PrintStream out = new PrintStream(pos);
            writer.setOutputStream(out);
            writer.write(document);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
