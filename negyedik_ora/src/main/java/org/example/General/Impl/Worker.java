package org.example.General.Impl;

import org.example.General.IWorker;

public class Worker implements IWorker {

    @Override
    public void hello() {
        System.out.println("Worker");
    }
}
