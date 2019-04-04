package com.crackingthecodinginterview.arrays;

public class URLify {

	public String encodeSpaces(String url, int trueLength) {
		
		char[] urlChars = new char[url.length()];
		
		int j = 0;
		for (int i = 0; i < trueLength; i++) {
			if(url.charAt(i) == ' ') {
				urlChars[j++] = '%';
				urlChars[j++] = '2';
				urlChars[j++] = '0';
			}
			else {
				urlChars[j++] = url.charAt(i);
			}
		}
		
		return new String(urlChars);
	}
}
