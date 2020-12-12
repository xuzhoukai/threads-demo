package org.example.current;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CurrentHashMapDemo {

    public static void main(String[] args) {
        Map<String,String> map = new ConcurrentHashMap<>();
        Map<String,String> map2 = new ConcurrentHashMap<>(map);
        Map map3 = Collections.synchronizedMap(new HashMap<>());
    }
}
