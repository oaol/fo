package com.fo.test.fastjson;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Sample {

    private String name;
    private Integer age;
    private List<Map<String, Integer>> arr;

    public static void main(String[] args) {
        String jsonStr = "{'name': 'ihgou', 'age': 16, 'arr': [{'a': '1', 'b':2}, {'a':3, 'b':4}]}";
        JSONObject parseObject = JSONObject.parseObject(jsonStr);
        boolean containsKey = parseObject.containsKey("name2");
        System.out.println("contain key name: " + containsKey);
        Object object = parseObject.get("name2");
        System.out.println("name2: " + object);
        String string = parseObject.getString("name1");
        System.out.println("name: " + string);
        System.out.println(parseObject.getIntValue("age"));
        JSONArray jsonArray = parseObject.getJSONArray("arr");

        JSONObject jsonObject = jsonArray.getJSONObject(0);
        System.out.println(jsonObject.getInteger("a"));

        System.out.println("-----------");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject2 = jsonArray.getJSONObject(i);
            jsonObject2.getString("a");
            System.out.println(jsonObject2.toJSONString());
        }

        Sample parseObject2 = JSONObject.parseObject(jsonStr, Sample.class);
        Map<String, Integer> map = parseObject2.getArr().get(0);
        System.out.println(map.getOrDefault("a", 11));
    }
}
