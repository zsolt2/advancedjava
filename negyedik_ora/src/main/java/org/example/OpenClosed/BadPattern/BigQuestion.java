package org.example.OpenClosed.BadPattern;

public class BigQuestion {
    public static final int lowerNegativeZone = -50;
    public static final int lowerNegativeZoneUpValue = -2;
    public static final int lowerNegativeZoneLowValue = -1;
    public int get(int value){
        int rv;
        boolean odd= value%2==0;
        if(value<0){
            if (value < lowerNegativeZone){
                return lowerNegativeZoneUpValue;
            } else {
                return lowerNegativeZoneLowValue;
            }
        }
        if(value>35) {
            if(value == 100){
                rv = (int)Math.floor(Math.sqrt(value));
            } else {
                rv = value;
            }
        }else {
            rv = 0;
        }
        if(odd){
            rv *=2;
        }
        return rv;
    }
}
