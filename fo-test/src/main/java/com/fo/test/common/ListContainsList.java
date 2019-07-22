package com.fo.test.common;

import java.util.List;

import com.fo.common.core.util.CollectionUtils;

/**
 * use containsAll method
 * 
 * @author bryce
 * @Date Mar 28, 2019
 */
public class ListContainsList {
    
    public static void main(String[] args) {
        List<Integer> newArrayList = CollectionUtils.newArrayList(1, 2, 3);
        List<Integer> newArrayList2 = CollectionUtils.newArrayList(3,2,5,1);
        System.out.println(newArrayList2.containsAll(newArrayList));
    }

}
