package org.example.interfaceusage;

public class Hasznos implements HasznosCucc{
    MasikHasznos hasznos2;

    @Override
    public void valamiCool() {
        System.out.println("Valami hasznos");
    }

    public void masik(){
        System.out.println();
    }
}
