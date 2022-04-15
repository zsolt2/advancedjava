package hu.meiit.haladojava.flow;

import hu.meiit.haladojava.flow.exceptions.NotInicializedException;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public abstract class BaseFlowImplementation implements BaseFlow {
    protected boolean isValid = false;
    protected PipedOutputStream pos = null;
    protected PipedInputStream pis = null;

    @Override
    public InputStream execute(InputStream in){
        try{
            this.setInput(in);
            this.step();
            return this.getOutput();
        } catch (NotInicializedException e){
            e.printStackTrace();
            return null;
        }
    }
}
