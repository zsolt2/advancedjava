package org.example.General;

import org.example.General.Director;
import org.example.General.HardWorker;
import org.example.General.Impl.NewWorker;
import org.example.General.Impl.Worker;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        new Director(new Worker()).doIt(1);

        new Director(new HardWorker()).doIt(1);
        run(new NewWorker());
    }

    public static void run(Worker worker){
        worker.hello();
    }
}
