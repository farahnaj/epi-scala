package com.epi.java.sorting;

public class QuickSort {


  public static int[] quickSort(int[] array, int target, int pivot) {

    if(target < pivot) {
      int newPivot = partition(array, target, pivot);
      quickSort(array, target ,newPivot - 1);
      quickSort(array, newPivot + 1, pivot);
    }

    return array;
  }

  public static int partition(int[] array, int target, int pivot) {
    int i = target - 1;
    int pivotElem = array[pivot];
    int finalTarget = pivot;

    for(int t = target; t <= pivot; t++) {
      int targetElem = array[t];

      if(targetElem <= pivotElem) {
        i++;
        int iElem = array[i];
        array[i] = targetElem;
        array[t] = iElem;
        finalTarget = i;
      }
    }
    return finalTarget;
  }



  public static void main(String[] args) {
    int[] array = new int[] {6,8,7,2,4,3,5};
    quickSort(array, 0, array.length - 1);
    System.out.println(array.toString());

    for(int i = 0; i < array.length; i++){
      System.out.println(i);
    }

    int[] inputArray = { 12, 81, 74, 43, 1098, 0, 8, 92, 17, 754, 912, 0, 6, 4 };
    quickSort(inputArray, 0, inputArray.length - 1);
    for(int i = 0; i < inputArray.length; i++){
      System.out.println(i);
    }
  }
}
