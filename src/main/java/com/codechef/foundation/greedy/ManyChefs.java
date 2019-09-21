package com.codechef.foundation.greedy;

import java.util.Arrays;

public class ManyChefs {

	final static char[] chef = {'C', 'H', 'E', 'F' };
	public static void main(String[] args) {
		System.out.println(maxChefs("????CIELIS???E?"));
		System.out.println(maxChefs("????CIELISOUR???F"));
		System.out.println(maxChefs("T?KEITE?SY"));
		System.out.println(maxChefs("????????"));
		System.out.println(maxChefs("???C???"));
	}

	public static String maxChefs(String s){
	    StringBuilder sb = new StringBuilder(s);
	    
	    //replace if possible
	    for(int i = s.length() - 1 - 3; i >= 0; i--){
	        if(canReplace(sb, i)){
	            sb.replace(i, i+4, "CHEF");
	        }
	    }
	    
	    //replace remaining ??
	    for(int i = s.length() - 1; i >= 0; i--){
	        if(sb.charAt(i) == '?'){
	            sb.setCharAt(i, 'A');
	        } 
	    }
	    
	    return sb.toString();
	}
	
	public static boolean canReplace(StringBuilder sb, int start){
	    for(int i = 0; i < 4; i++){
	        if(sb.charAt(start+i) != '?' && sb.charAt(start+i) != chef[i]){
 	            return false;
	        }
	    }
	    
	    return true;
	}
}
