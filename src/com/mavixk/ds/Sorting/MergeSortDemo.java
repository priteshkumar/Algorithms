package com.mavixk.ds.Sorting;
import java.util.*;

public class MergeSortDemo {

  public static void main(String[] args) {
    int[] a = {1, 3, 9, 79, 23, 22, 24};
    int[] b = new int[20];
    for (int i = 20; i >= 1; i--) {
      b[i - 1] = i;
    }
    mergeSort(a, 0, a.length - 1);
    printArray(a);
  }

  public static void printArray(int[] a) {
    for (Integer val : a) {
      System.out.print(val + " ");
    }
    System.out.println();
  }

  public static void merge(int Arr[], int start, int mid, int end) {

    // create a temp array
    int temp[] = new int[end - start + 1];

    // crawlers for both intervals and for temp
    int i = start, j = mid + 1, k = 0;

    // traverse both arrays and in each iteration add smaller of both elements in temp
    while (i <= mid && j <= end) {
      if (Arr[i] <= Arr[j]) {
        temp[k] = Arr[i];
        k += 1;
        i += 1;
      } else {
        temp[k] = Arr[j];
        k += 1;
        j += 1;
      }
    }

    // add elements left in the first interval
    while (i <= mid) {
      temp[k] = Arr[i];
      k += 1;
      i += 1;
    }

    // add elements left in the second interval
    while (j <= end) {
      temp[k] = Arr[j];
      k += 1;
      j += 1;
    }

    // copy temp to original interval
    for (i = start; i <= end; i += 1) {
      Arr[i] = temp[i - start];
    }
  }

// Arr is an array of integer type
// start and end are the starting and ending index of current interval of Arr

  public static void mergeSort(int Arr[], int start, int end) {

    if (start < end) {
      int mid = (start + end) / 2;
      mergeSort(Arr, start, mid);
      mergeSort(Arr, mid + 1, end);
      merge(Arr, start, mid, end);
    }
  }
}