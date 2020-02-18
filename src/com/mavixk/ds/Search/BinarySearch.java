package com.mavixk.ds.Search;
import java.util.*;

public class BinarySearch {

  public static void main(String[] args){
    Integer[] nums = {1,2,3,4,7,9,10,11};
    System.out.println("10 found at : " + binarySearch(nums,10));
    System.out.println("2 found at : " + binarySearch(nums,2));
    System.out.println("11 found at : " + binarySearch(nums,11));
    System.out.println("1 found at : " + binarySearch(nums,1));
    System.out.println("0 found at : " + binarySearch(nums,0));
    System.out.println("14 found at found : " + binarySearch(nums,14));


  }

  /**
   * Binary search for int
   * @param a
   * @param key
   * @return
   */
  public static int binarySearch(Integer[] a,int key){
    int low = 0;
    int high = a.length -1;
    int mid = -1;
    while(low <= high){
      mid = low + (high - low)/2;

      if(a[mid] == key){
        return mid;
      }
      else if (a[mid] > key)high = mid-1;
      else if(a[mid] < key)low = mid+1;
    }
    return -1;
  }

  public static int binarySearch(Player[] players,String key){
    Player[] a = players;
    int low = 0;
    int high = a.length -1;
    int mid = -1;
    while(low <= high){
      mid = low + (high - low)/2;

      if(a[mid].getEmail().equals(key)){
        return mid;
      }
      else if (a[mid].getEmail().compareTo(key) > 0)high = mid-1;
      else if(a[mid].getEmail().compareTo(key) < 0)low = mid+1;
    }
    return -1;
  }
}
