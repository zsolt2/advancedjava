package hu.meiit.haladojava.flow;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public abstract class BaseFlowImplementation implements BaseFlow {
    protected boolean isValid = false;
    protected PipedOutputStream pos = null;
    protected PipedInputStream pis = null;
}
