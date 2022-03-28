package org.example.OpenClosed.GoodPattern.Fraework;

import org.example.OpenClosed.GoodPattern.Fraework.user.Flow2;
import org.example.OpenClosed.GoodPattern.Fraework.user.PartilallyImplementedFlow;

public class Runner {
    public static void main(String[] args) {
        run(new Flow2());
        run(new PartilallyImplementedFlow());
    }

    private static void run(BaseFlow base){
        base.run();
    }
}
