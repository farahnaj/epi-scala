package com.epi.java.string;

import scala.Array;

import java.util.HashMap;
import java.util.Map;

public class StringQuestions {

    //Write a function to reverse a string.
    public static String reverseString(String input) {
        if(input == null){
            return "";
        } else {
            char charArray[] = input.toCharArray();
            char result[] = new char[charArray.length];
            int lastIndex = charArray.length - 1;
            for(int i = 0; i <= lastIndex; i++) {
                result[i] = charArray[lastIndex - i];
            }
            return new String(result);
        }
    }

    public static long[] cache = new long[5000];
    public static long dpFibonacci(int n) {

        if(n == 0) {
            return 0L;
        } else if(n == 1 || n == 2) {
           return 1L;
        } if(cache[n] != 0) {
          return cache[n];
        } else {
           cache[n] = dpFibonacci(n - 1) + dpFibonacci(n - 2);
           return cache[n];
        }
    }

    public static long fibonacci(int n) {

        if(n == 0) {
            return 0L;
        } else if(n == 1 || n == 2) {
            return 1L;
        }else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        //System.out.println(StringQuestions.reverseString("Madam, I'm Adam"));
        System.out.println("fibonacci: " + StringQuestions.fibonacci(50));
        System.out.println("dpFibonacci: " + StringQuestions.dpFibonacci(50));
    }
}
