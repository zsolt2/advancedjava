package org.example.interfaceusage.usage;

import org.example.interfaceusage.Hasznos;
import org.example.interfaceusage.HasznosCucc;
import org.example.interfaceusage.cache.CacheRead;

public class Hasznalat {
    private final CacheRead cacheRead;
    public Hasznalat(CacheRead cacheRead){
        this.cacheRead = cacheRead;
    }
    public void run(HasznosCucc hasznos){
        hasznos.valamiCool();
        System.out.println(cacheRead.get("titok"));
    }
}
