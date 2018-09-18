package org.gonnys.web;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extchercker {
	
	  static String allowPattern =
			  ".+\\.(gif|jpg|bmp|png)$";

	  public static boolean check(String fileName) {
		  boolean result = false;
		  
		    Pattern p = Pattern.compile(allowPattern);
	        Matcher m = p.matcher(fileName);
	        result = m.matches();
		  
		  return result;
	  }
	  
	  public static void main(String[] args) {
		  
		  String name = "gonnys.zip";
		  
		  System.out.println(check(name));
	  }
	  
	  
}
