package org.example.OpenClosed.GoodPattern.Fraework;

public  class BaseFlow {
    public void step1(){
        System.out.println("base step1");
    };
    public void step2(){// Hook metodus, ha abstract lenne akkor muszaly feluldefinialni
        System.out.println("base step2");
    };

    void run(){
        step1();
        step2();
    }
}
