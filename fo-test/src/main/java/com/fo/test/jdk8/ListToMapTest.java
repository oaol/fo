package com.fo.test.jdk8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMapTest {
    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        HashMap<Object, Object> hashMap2 = new HashMap<>();
        HashMap<Object, Object> hashMap3 = new HashMap<>();
        HashMap<Object, Object> hashMap4 = new HashMap<>();
        HashMap<Object, Object> hashMap5 = new HashMap<>();
        hashMap.put("1", 1);
//        hashMap2.put("2", 2);
//        hashMap3.put("1", 1);
//        hashMap4.put("1", 1);
//        hashMap5.put("1", 1);
        List<HashMap<Object, Object>> sss = Arrays.asList(hashMap, hashMap2, hashMap3, hashMap4, hashMap5);
        
        Map<Object, Object> convertListToMap = sss.stream()
                .collect(Collectors.toMap(a -> a.get("1"), Function.identity(),(entity1,entity2) -> entity1));
        System.out.println(convertListToMap);
    }
}
