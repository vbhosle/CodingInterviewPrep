package com.leetcode;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		System.out.println((int)('Z' - 'A'));
		ExcelSheetColumnNumber solver = new ExcelSheetColumnNumber();
		System.out.println(solver.titleToNumber("BCZ"));
	}
//	 	A -> 1
//	    B -> 2
//	    C -> 3
//	    ...
//	    Z -> 26
//	    AA -> 27
//	    AB -> 28 
	public int titleToNumber(String s) {
		//s.chars().reduce(0, (r ,ch) -> r * 26 + (ch - 'A' + 1));
        int result = 0;
        int len = s.length() - 1;
        for(int i = len; i >= 0; i--){
            result += (int)(Math.pow(26, len - i) * (s.charAt(i) - 'A' + 1));
        }
        return result;
    }
	
	//not working
	public String numberToTitle(int n) {
		System.out.println(n);
        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
        	System.out.println(n%26);
        	sb.append((char)(n%26 + (int)'A'));
        	n = n/26;
        }
        
        return sb.reverse().toString();
    }
}
