package org.example.OpenClosed.GoodPattern;

// A nyilt zaart azt mondja ki legyen zart a valtozasokra, de legten nyilt az uj osztajok bevezetesere.
public class ResponseFactoryImpl implements ResponseFactory{

    @Override
    public ValueProvider get(int value) {
        ValueProvider vp;
        if(value < 0){
            if(value< -50){
                vp = new Minus2Response();
            } else{
                vp = new MinusOneResponse();
            }
        } else {
            vp = new TwiceProvider();
        }
        return vp;
    }
}
