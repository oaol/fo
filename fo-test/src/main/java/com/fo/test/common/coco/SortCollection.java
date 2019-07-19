package com.fo.test.common.coco;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortCollection {
	public static void main(String[] args) {
		//String [] arr =new String[6];
		String[] arr ={"21","23","11","2"};
		System.out.println(arr);
		String string = Arrays.toString(arr);
		System.out.println("string:"+string);
      
		List<String> strings = Arrays.asList("1sss", "1y", "11", "33", "22");
        System.out.println("strings:"+strings);
       
        Collections.sort(strings);
        System.out.println("strings:"+strings);

        
    }

	
}
