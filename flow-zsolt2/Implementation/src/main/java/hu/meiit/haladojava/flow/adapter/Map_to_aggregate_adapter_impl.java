package hu.meiit.haladojava.flow.adapter;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Map_to_aggregate_adapter_impl implements Map_to_aggregate_adapter{
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public Map_to_aggregate_adapter_impl(ObjectInputStream in, ObjectOutputStream out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {

    }
}
