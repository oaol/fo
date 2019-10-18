package com.fo.test.fastjson;

import com.alibaba.fastjson.JSONObject;

/**
 * \\x 结尾时的 OOM bug
 * 
 * @author bryce
 * @Date Sep 6, 2019
 */
public class XBugTest {
    public static void main(String[] args) {
        String a = "{'a':'sdfadsasdfadsfasdfadsfadsfdsffdsfasdfadsfadsfdsffdsfasdfadsfadsfdsffdsfasdfadsfadsfdsffdsfasdfadsfadsfdsffdsfasdfadsfadsfdsffdsfasdfadsfadsfdsffdsfasdfadsfadsfdsffdsfasdfadsfadsfdsffdsfasdfadsfadsfdsffdsfasdfadsfadsfdsffdsfasdfadsfadsfdsffdsfasdfadsfadsfdsffdsfasdfadsfadsfdsffdsfasdfadsfadsfdsffdsfasdfadsfadsfdsffdsfasdfadsfadsfdsff\\x'}";
        JSONObject parseObject = JSONObject.parseObject(a);
        System.out.println(parseObject);
    }

}
