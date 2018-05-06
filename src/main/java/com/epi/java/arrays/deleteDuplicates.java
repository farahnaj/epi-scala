package com.epi.java.arrays;

import java.util.*;

public class deleteDuplicates {

  // remove duplicates from a sorted array

  // {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 8, 9, 10}
  //                                f
  //                                          i

  public static int removeDups(int[] array) {
    int firstElement = 0;
    for (int i = 1; i < array.length; i++) {

      if (array[firstElement] != array[i]) {
        array[firstElement + 1] = array[i];
        firstElement++;
      }
    }
    return firstElement;
  }


//  public static List<Integer> deleteDups(List<Integer> a) {
//    if(a.isEmpty()) {
//      return new ArrayList<>();
//    }
//    Set<Integer> set = new HashSet<>();
//    for(Integer i : a) {
//      set.add(i);
//    }
//    return new ArrayList(set);
//  }

  public static void main(String[] args) {

    int[] a = new int[] {0, 1, 2, 2, 3, 3, 4, 5, 6, 7, 8, 8, 9, 10};
    System.out.println(removeDups(a));
  }
}
