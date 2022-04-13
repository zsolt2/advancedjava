package hu.meiit.haladojava.flow;

import hu.meiit.haladojava.flow.exceptions.NotInicializedException;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    private List<BaseFlow> steps;
    public void run(){
        init();
        execute();
    }
    private void init(){
        steps = new ArrayList<>();
        steps.add(FlowFactory.getFlow("csv->xml"));
        steps.add(FlowFactory.getFlow("xml->map"));
        steps.add(FlowFactory.getFlow("map->aggregate"));
        steps.add(FlowFactory.getFlow("aggregate->csv"));

    }

    private void execute(){
        try {
            InputStream in = new FileInputStream("src/input.csv");

            for(BaseFlow flow: steps){
                flow.setInput(in);
                flow.step();
                in = flow.getOutput();
            }

            File outputFile = new File("src/output.csv");
            FileUtils.copyInputStreamToFile(in, outputFile);

        } catch (IOException | NotInicializedException e) {
            e.printStackTrace();
        }
    }
}
