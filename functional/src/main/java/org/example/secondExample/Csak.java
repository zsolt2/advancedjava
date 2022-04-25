package org.example.secondExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;

public class Csak {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        Csak csak = new Csak();
        Function<String, Integer> fv = (aa) ->{return aa.length(); };

        Integer value = map.computeIfAbsent("David", Csak::length);
        Integer value2 = map.computeIfAbsent("John",  azonosito -> 3); // 3 viisszateresi ertek
        Integer value3 = map.computeIfAbsent("Jhon", aa -> aa.length()); // aa - parameter, aa.length() - return value
        Integer value4 = map.computeIfAbsent("Dominik", fv);

        Function<String, Integer> fv2 = Csak::length;
        Integer value5 = map.computeIfAbsent("Jhon", fv2);

        Function<Integer, Integer> fv3 = a -> 2*a;//Csak akkor mukodik ha a fuggveny alairsa megegyezik
        csak.printResult(fv3);
        csak.printResult2(a->4*a);
        csak.printResult(Math::random);
        //csak.printResult( () -> Math::random() ); // Ha nem kap semmit akkor atadja aMath::randomot
        csak.printResult( () -> {return 4.0;});
        csak.dataIn(Csak::dd);
        csak.dataIn( (data)-> System.out.println(data));
        csak.dataIn( data -> System.out.println(data));

        Predicate<String> predicate = s->!s.isEmpty();
        csak.kiirHaOk( predicate, "" );
        csak.kiirHaOk(predicate, "valami");


        Predicate<String> notEmpty = s -> ! s.strip().isEmpty();
        Predicate<String> notContainsY = s -> s.indexOf('Y')!= -1;
        csak.kiirHaOk(notEmpty.and(notContainsY), "valami");
        csak.kiirHaOk(notEmpty.and(notContainsY), "laskjdfYsdfsdfd");


        List<String> lista = new ArrayList<>();
        // The 3 implementations are equivalent
        // Make a list of the length of the Strings in the List
        //===========================================================//
        List<Integer> lengthList = lista.stream()
                        .map( item -> item.length()) // A bemenete String a kimenete Integer
                        .filter( length -> length > 0)
                        .collect(Collectors.toList());
        // Make the Function and the Predicate separate variables;
        //===========================================================//
        Predicate<Integer> pred = number -> number > 0;
        Function<String, Integer> strToIntMap = s -> s.length();
        List<Integer> lengthList2 = lista.stream()
                .map( strToIntMap)
                .filter( pred)
                .collect(Collectors.toList());
        //===========================================================//
        List<Integer> forLoopLengthList = new ArrayList<>();
        for( String item: lista ){
            int lenth = item.length();
            if (item.length() > 0){
                forLoopLengthList.add(lenth);
            }
        }
        //===========================================================//
    }

    public static Integer length(String s){
        return s.length();
    }

    private int v(String s){
        return s.indexOf('d');
    }

    private void printResult(Function<Integer, Integer> fv){
        int result = fv.apply(5);
        System.out.println(result);
    }

    private void printResult2(IntToLongFunction fv){
        long result = fv.applyAsLong(5);
        System.out.println(result);
    }

    private void printResult(Supplier<Double> fv){
        Double result = fv.get();
        System.out.println(result);
    }

    private void dataIn(Consumer<Double> fv){
        fv.accept(5.0);
    }

    private void kiirHaOk(Predicate<String> predicate, String s){
        if(predicate.test(s)) {
            System.out.println(s+" is ok");
        } else {
            System.out.println("Not ok");
        }
    }


    public static void dd(Double d){
        System.out.println(d);
    }


}
