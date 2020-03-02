package com.mavixk.ds.Sorting;
import java.util.*;

public class BubbleSortDemo {
  public static void main(String[] args){
    int[] nums = {8,7,5,4,1,3,2};
    int[] nums2 = {2,2,3,4,1,1};
    System.out.println("bubble sort demo");
    bubbleSort(nums);
    bubbleSort(nums2);
    printArray(nums);
    printArray(nums2);
    System.out.println("selection sort demo");
    selectionSort(nums);
    printArray(nums);
    System.out.println("insertion sort demo");
    insertionSort(nums);
    printArray(nums);
    int[] nums3 = {5,4,3,2,1};
    insertionSort(nums3);
    printArray(nums3);
    int[] nums4 = {4,3,17,21,20};
    insertionSortV2(nums4);
    printArray(nums4);
  }

  public static void printArray(int[] a){
    for(Integer val:a){
      System.out.print(val + " ");
    }
    System.out.println();
  }

  /**
   * Bubble sort
   * @param a
   */
  public static void bubbleSort(int[] a){
    int n = a.length;
    for(int i=0;i < n;i++){
      for(int j=1;j < n-i;j++){
        if(a[j] < a[j-1]){
          int temp = a[j-1];
          a[j-1] = a[j];
          a[j] = temp;
        }
      }
    }
  }

  /**
   * Selection sort
   * @param a
   */
  public static void selectionSort(int[] a){
    int n = a.length;
    int min = -1;
    for(int i=0;i < n-1;i++){
      min = i;
      for(int j=i+1;j < n;j++){
        if(a[j] < a[i])
          min = j;
      }
      if(min != i){
        int temp = a[i];
        a[i] = a[min];
        a[min] = temp;
      }
    }
  }

  /**
   * Insertion sort
   * @param a
   */
  public static void insertionSort(int[] a){
    int n = a.length;
    for(int i=1;i < n;i++){
      for(int j=i; j > 0;j--){
        if(a[j-1] > a[j]){
          int temp = a[j-1];
          a[j-1] = a[j];
          a[j] = temp;
        }
        else
          break;
      }
    }
  }

  /**
   * insertion sort version2
   * @param a
   */
  public static void insertionSortV2(int[] a){

    int n = a.length;
    int j = -1;
    for(int i=1;i < n;i++){
      j = i;
      while(j > 0 && a[j-1] > a[j]){
        int temp = a[j-1];
        a[j-1] = a[j];
        a[j] = temp;
        j = j -1;
      }
    }
  }
}
