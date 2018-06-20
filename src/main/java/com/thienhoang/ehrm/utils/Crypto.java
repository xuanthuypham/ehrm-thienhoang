package com.thienhoang.ehrm.utils;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Crypto {
	
	private final static  String SECRET_KEY = "thhosolu";
	private final static  SecretKeySpec skeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "DES");
	
	
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
	    
	    String original = "stackjava.com";
	    System.out.println(original);
	    String en = encrypt(original);
	    System.out.println(en);
	    
	  }
	public static String encrypt(String original) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException 
	{
		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");
	    cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
	    byte[] byteEncrypted = cipher.doFinal(original.getBytes());
	    String encrypted =  Base64.getEncoder().encodeToString(byteEncrypted);
	    
		return encrypted;
	}
	
}
