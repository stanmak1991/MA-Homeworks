package Homework09;

import java.util.Collections;
import java.util.HashMap;

public class MapCustom<K, V> extends HashMap {

    @Override
    public V get(Object key) {
        if (super.get(key) == null) {
            return (V) Collections.EMPTY_LIST;
        }
        return (V) super.get(key);
    }
}
