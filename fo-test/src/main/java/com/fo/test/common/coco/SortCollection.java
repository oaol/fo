package com.fo.test.common.coco;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.util.comparator.Comparators;

public class SortCollection {
	public static void main(String[] args) {
		//String [] arr =new String[6];
		String [] arr ={"21","23","11","2"};
		String string = Arrays.toString(arr);
		System.out.println("string:"+string);
      
		List<String> strings = Arrays.asList(arr);
        System.out.println("strings:"+strings);
       
       /* Collections.sort(strings,new Comparators<String>(
        		
        		) {
		});*/
        System.out.println("strings:"+strings);

        
    }

	
}
