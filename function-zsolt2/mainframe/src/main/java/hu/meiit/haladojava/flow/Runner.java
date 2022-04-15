package hu.meiit.haladojava.flow;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Runner {
    private List<BaseFlow> filters;
    public void run(){
        init();
        execute();
    }
    private void init(){
        filters = new ArrayList<>();
        filters.add(FlowFactory.getFlow("csv->xml"));
        filters.add(FlowFactory.getFlow("xml->map"));
        filters.add(FlowFactory.getFlow("map->aggregate"));
        filters.add(FlowFactory.getFlow("aggregate->csv"));

    };

    InputStream lambda(Function<InputStream, InputStream> func, InputStream in){
        InputStream result = func.apply(in);
        return result;
    }

    private void execute(){
        try {


            InputStream in = new FileInputStream("input.csv");

            for(BaseFlow flow: filters){
                in = lambda(flow::execute, in);
            }

            File outputFile = new File("output.csv");
            FileUtils.copyInputStreamToFile(in, outputFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
