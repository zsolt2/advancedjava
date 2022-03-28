package org.example.Liskov.BadPattern;

import java.security.InvalidParameterException;
import java.util.List;

public class Analize {
    public Double process(List<Integer> data){

        assertNotNullOrNotEmptyData(data);

        Double sum = 0.0;
        for(Integer item: data){
            sum += item;
        }
        return sum/data.size();
    }

    protected void assertNotNullOrNotEmptyData(List<Integer> data) {
        if (data == null || data.isEmpty()) {
            throw new InvalidParameterException("data can not be null");
        }
    }

    protected void assertNotZeroData(List<Integer> data){
        for(Integer item: data){
            if(item< 0){
                throw new InvalidParameterException("data can not be Less than zero");
            }
        }
    }
}
