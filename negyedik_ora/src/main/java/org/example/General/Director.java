package org.example.General;


public class Director {
    private final IWorker worker;
    public Director(IWorker worker){
        this.worker = worker;
    }
    public void doIt(int value){
        if(value > 0)
            this.worker.hello();
    }
}
