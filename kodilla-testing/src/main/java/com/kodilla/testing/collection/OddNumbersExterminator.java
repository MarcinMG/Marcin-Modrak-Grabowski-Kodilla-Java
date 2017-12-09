package com.kodilla.testing.collection;

import java.util.*;
import java.lang.*;

public class OddNumbersExterminator {

     public ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {

         ArrayList<Integer> evenNumbers = new ArrayList<Integer>();
         for(Integer tempNumbers : numbers){
             if(tempNumbers % 2 == 0){
                 evenNumbers.add(tempNumbers);
             }
         }
         return evenNumbers;
     }

}
