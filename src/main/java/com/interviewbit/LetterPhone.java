package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LetterPhone {

	final static String[] keyCharacters = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String A) {
        List<String> keyChars = Arrays.stream(A.split(""))
        							  .map(c -> Integer.parseInt(c))
        							  .map(i -> keyCharacters[i])
        							  .collect(Collectors.toList());
        return letterCombinations(keyChars);
    }
    
    public List<String> letterCombinations(List<String> keyChars) {
        ArrayList<String> combinations = new ArrayList<>();
        if(!keyChars.isEmpty() && keyChars.size() == 1) return Arrays.stream(keyChars.get(0).split("")).collect(Collectors.toCollection(ArrayList::new));
        if(keyChars.isEmpty()) return combinations;
        String top = keyChars.get(0);
        for(int i=0; i< top.length(); i++){	
        	char letter = top.charAt(i);
        	ArrayList<String> tempCombos = letterCombinations(keyChars.subList(1, keyChars.size())).stream()
																						        	.map(c -> letter + c)
																						        	.collect(Collectors.toCollection(ArrayList::new));
			combinations.addAll(tempCombos);
        }
        
        return combinations;
    }
}
