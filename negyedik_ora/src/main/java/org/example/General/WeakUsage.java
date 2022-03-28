package org.example.General;

// Dependency IV
// Szarmaztatas, eros fuggoseg
public class WeakUsage extends Worker{
    // Tartalmazas
    // Dependency I
    // Adattag
    Worker worker;

    WeakUsage(){
        worker = new Worker();
    }

    // Dependency II
    // Konstruktor parameter
    public void hello(Worker worker){

    }

    // Dependency III
    // Lokalis Valtozo
    public void hello2(){
        Worker worker = new Worker();
    }
}
