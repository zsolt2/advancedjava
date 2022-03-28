package org.example.Liskov.BadPattern;

import java.util.List;

public class LaterAnalize extends Analize {
    public Double process(List<Integer> data){

        assertNotNullOrNotEmptyData(data);
        assertNotZeroData(data);

        Double sum = 0.0;
        for(Integer item: data){
            sum += item;
        }
        return sum/data.size();
    }


}
