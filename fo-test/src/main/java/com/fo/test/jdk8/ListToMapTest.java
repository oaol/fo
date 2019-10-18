package com.fo.test.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMapTest {
  
    public static void main(String[] args) {
//        HashMap<Object, Object> hashMap = new HashMap<>();
//        HashMap<Object, Object> hashMap2 = new HashMap<>();
//        HashMap<Object, Object> hashMap3 = new HashMap<>();
//        HashMap<Object, Object> hashMap4 = new HashMap<>();
//        HashMap<Object, Object> hashMap5 = new HashMap<>();
//        hashMap.put("1", 1);
//        hashMap2.put("2", 2);
//        hashMap3.put("1", 1);
//        hashMap4.put("1", 1);
//        hashMap5.put("1", 1);
//        List<HashMap<Object, Object>> sss = Arrays.asList(hashMap, hashMap2, hashMap3, hashMap4, hashMap5);
//        
//        Map<Object, Object> convertListToMap = sss.stream()
//                .collect(Collectors.toMap(a -> a.get("1"), Function.identity(),(entity1,entity2) -> entity1));
//        System.out.println(convertListToMap);
        
        Person person = new Person();
        person.setName("a");
        person.setGender(1);
        Person person2 = new Person();
        person2.setName("b");
        person2.setGender(0);
        Person person3 = new Person();
        person3.setName("c");
        person3.setGender(0);
        List<Person> asList = Arrays.asList(person, person2, person3);
        Map<Integer, List<Person>> map = listToMap(asList);
        for (Entry<Integer, List<Person>> person4 : map.entrySet()) {
            System.out.println("key:" + person4.getKey() + "value:" + person4.getValue());
        }
    }

    public static Map<Integer, List<Person>> listToMap(List<Person> list) {
        Map<Integer, List<Person>> resultMap = new HashMap<>();
        for (Person person : list) {
            int gender = person.getGender();
            List<Person> list2 = resultMap.get(gender);
            if (list2 == null) {
                List<Person> cc = new ArrayList<>();
                cc.add(person);
                resultMap.put(gender, cc);
            } else {
                list2.add(person);
            }
        }
        return resultMap;
    }
}

class Person {
    private String name;
    private int gender;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getGender() {
        return gender;
    }
    public void setGender(int gender) {
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", gender=" + gender + "]";
    }
    
}