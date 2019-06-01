package com.interviewbit;

import java.util.List;

//This is as simple as we want to store 20 and 13 together so we store it as 2013 if we take mod by 100 we get 13 and if we divide it by 100 we get 20.
//
//for eg- a[]={4,2,0,1,3}
//
//Now you apply the first step it becomes 4+3*5=19.
//
//As quite aptly answered by Janaky Murthy you must be thinking if we updated the old value to new value like 4->19 and then we have to use this value so that’s why in the first step we are taking 19%5 so that we get the previous value that is 4 and use it for further steps.
//
//And at last if we divide 19/5 we get 3 i.e arr[arr[i]].
//
//Just keep in mind ,like its a new number system with the value as n not 10 like in decimal so we store the values by taking %n and then by multiplying by n and adding the old value.

public class RearrangeArray {

	public void arrange(List<Integer> a) {
        int size = a.size();
        for(int i = 0; i< size; i++){
            a.set(i, a.get(i) + (a.get(a.get(i))%size)*size);
        }
        
       // a.stream().forEach(System.out::println);
        for(int i = 0; i< size; i++){
            a.set(i, a.get(i)/size);   
        }
    }
}
