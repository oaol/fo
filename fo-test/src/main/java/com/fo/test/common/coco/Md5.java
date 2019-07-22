package com.fo.test.common.coco;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Md5 {

	public static void main(String[] args) {
		
		//computeMD5();
		String s="abcdefg";
		byte[] bytes = s.getBytes();
		byte[] computeMD5 = computeMD5(bytes);
		System.out.println(computeMD5);
	}
	public static final byte[] computeMD5(byte[] content) {
	    try {
	        MessageDigest md5 = MessageDigest.getInstance("MD5");
	        return md5.digest(content);
	    } catch (NoSuchAlgorithmException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	
	
	
	
	
	
	
}
