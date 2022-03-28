package org.example.OpenClosed.GoodPattern.Fraework.user;

import org.example.OpenClosed.GoodPattern.Fraework.BaseFlow;

public class Flow1 extends BaseFlow {

    @Override
    public void step1(){
        System.out.println("Flow step 1");
    }

    @Override
    public void step2(){
        System.out.println("Flow step 2");
    }

    // Nem tudja felulirni mert nem latja,
//    @Override
//    public void run(){
//
//    }
}