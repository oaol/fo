package com.fo.test.common;

import java.util.List;

import com.fo.common.core.util.CollectionUtils;

public class ListPush {
    public static void main(String[] args) {
        List<Integer> list = CollectionUtils.newArrayList();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(1);
        list.add(0, 0);
        System.out.println(list.toString());
    }

}
