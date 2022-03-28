package org.example.interfaceusage.usage;

import org.example.interfaceusage.Hasznos;
import org.example.interfaceusage.Hasznos2;
import org.example.interfaceusage.HasznosCucc;
import org.example.interfaceusage.cache.Cache;
import org.example.interfaceusage.cache.CacheRead;

public class Main {

    public static void main(String[] args) {
        HasznosCucc h = new Hasznos2();
        Cache cache = new Cache();
        Hasznalat hasznalat = new Hasznalat(cache);
        hasznalat.run(h);
    }
}
