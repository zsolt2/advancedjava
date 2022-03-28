package org.example.OpenClosed.GoodPattern;

public class TwiceProvider implements ValueProvider{
    public int get(int value){
        return value*=2;
    }
}
