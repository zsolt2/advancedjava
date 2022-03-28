package org.example.Liskov.BadPattern;

import java.util.ArrayList;
import java.util.List;

public class Measurment {
    public List<Integer> getData(){
        List rv = new ArrayList<>();

        rv.add(-2);
        rv.add(6);
        rv.add(12);
        return rv;
    }
}
