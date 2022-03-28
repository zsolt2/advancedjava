package org.example.interfaceusage.cache;

import java.util.HashMap;
import java.util.Map;

public class Cache implements CacheRead, CacheWrite{
    Map<String, Integer> valuesMap = new HashMap<>();
    @Override
    public int get(String name) {
        return valuesMap.get(name);
    }

    @Override
    public boolean empty() {
        return valuesMap.isEmpty();
    }

    @Override
    public void set(String name, int value) {
        valuesMap.put(name, value);
    }

    @Override
    public void clear() {
        valuesMap.clear();
    }

    @Override
    public void delete(String name) {
        valuesMap.remove(name);
    }
}
