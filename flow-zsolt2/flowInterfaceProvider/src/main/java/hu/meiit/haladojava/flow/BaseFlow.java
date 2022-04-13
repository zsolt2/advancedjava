package hu.meiit.haladojava.flow;

import hu.meiit.haladojava.flow.exceptions.NotInicializedException;

import java.io.InputStream;

public interface BaseFlow {
    void setInput(InputStream stream) throws IllegalArgumentException;
    InputStream getOutput();
    Object getData();
    void step() throws NotInicializedException;
}
