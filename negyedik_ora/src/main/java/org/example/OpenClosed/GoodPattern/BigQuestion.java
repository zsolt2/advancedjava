package org.example.OpenClosed.GoodPattern;

public class BigQuestion implements ValueProvider{
    public static final int lowerNegativeZone = -50;
    public static final int lowerNegativeZoneUpValue = -2;
    public static final int lowerNegativeZoneLowValue = -1;

    ResponseFactory responseFactory;
    public BigQuestion(ResponseFactory responseFactory){
        this.responseFactory = responseFactory;
    }
    public int get(int value){
        return responseFactory.get(value).get(value);
    }
}
