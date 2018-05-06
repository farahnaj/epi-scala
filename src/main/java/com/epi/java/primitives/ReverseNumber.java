package com.epi.java.primitives;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;

public class ReverseNumber {

  //42 -> 24
  //-314 -> -413

  public static String reverse(String num) {

    if(num == null) {
      return "";
    }

    StringBuffer stringBuffer = new StringBuffer();
    char[] chars = num.toCharArray();

    if(chars[0] == '-') {
      stringBuffer.insert(0,"-");
    }

    for(int i = chars.length -1; i>= 0; i--) {
      if(chars[i] != '-') {
        stringBuffer.append(chars[i]);
      }
    }

    return stringBuffer.toString();
  }

  public static int reverse(int num, int size) {
    int[] result = new int[size];
    int firstIndex = 0;

    while (firstIndex < size) {
      result[firstIndex] = Math.abs(num % 10);
      num = num/10;
      firstIndex++;
    }

    if(num < 0) {
      return Integer.getInteger('-' + Arrays.toString(result)).intValue();
    } else {
      return Integer.getInteger(Arrays.toString(result)).intValue();
    }

  }

  public static void main(String[] args) {
    System.out.println(ReverseNumber.reverse("42"));
    System.out.println(ReverseNumber.reverse("-314"));
    System.out.println(ReverseNumber.reverse("-31-4"));
    System.out.println(ReverseNumber.reverse(null));


    System.out.println(ReverseNumber.reverse(42, 2));


  }
}
