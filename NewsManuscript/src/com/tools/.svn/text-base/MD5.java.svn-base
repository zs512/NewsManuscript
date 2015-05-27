package com.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5{
	
	public final static String get32(String s){
		String resultString = "";
		try{
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(s.getBytes());
			byte b[] = messageDigest.digest();
			int i;
			StringBuffer buffer = new StringBuffer("");
			for(int offset = 0; offset < b.length; offset++){
				i = b[offset];
				if(i < 0) i += 256;
				if(i < 16) buffer.append("0");
				buffer.append(Integer.toHexString(i));
			}
			resultString = buffer.toString();
		}catch(NoSuchAlgorithmException e){
			System.out.println(e);
		}
		return resultString;
	}
	
	public final static String get16(String s){
		return get32(s).substring(8, 24);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(MD5.get16("abc"));
		System.out.println(MD5.get32("abc"));
	}

}
