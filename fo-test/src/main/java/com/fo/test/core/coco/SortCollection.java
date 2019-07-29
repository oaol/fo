package com.fo.test.core.coco;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class SortCollection {
	public static void main(String[] args) {
		/*//String [] arr =new String[6];
		String [] arr ={"21","23","11","2"};


		System.out.println(arr);
		String string = Arrays.toString(arr);
		System.out.println("string:"+string);*/
      
		List<String> strings = Arrays.asList("21","23adsdss","1111","2");
        System.out.println("strings:"+strings);
       
       Collections.sort(strings,new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
			return o1.length() - o2.length();
		}
	});
		List<String> strings1 = Arrays.asList("1sss", "1y", "11", "33", "22");
        System.out.println("strings:"+strings);
       
        Collections.sort(strings);
        System.out.println("strings:"+strings);
    }

	
}
