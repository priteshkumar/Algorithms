package com.mavixk.ds.Search;
import java.util.*;

public class BinarySearchProblems {
  public static void main(String[] args){
    int val = -1;
   // System.out.println((val + 20)% 20);
    int[] d = {0,1,2,3,4,5,6,7,8,10};
    System.out.println("first occurence of 0 is " + findLowerBound(d,1));
    Scanner input = new Scanner(System.in);
    long n = input.nextLong();
    //find floor squareroot
    System.out.println(findfloorSqrt(n));

    //Find rotation point
    String[] words = new String[]{
        "ptolemaic",
        "retrograde",
        "supplant",
        "undulate",
        "xenoepist",
        "asymptote",  // <-- rotates here!
        "babka",
        "banoffee",
        "engender",
        "karpatka",
        "othellolagkage",
        "ovasium",
        "owasium",
        "oxasium"

    };
    System.out.println(findRotationPoint(words));
    String[] words2 = {"cape","cake"};
    System.out.println(findRotationPoint(words2));
    String[] words3 = {"grape","orange","plum","radish","apple"};
    System.out.println(findRotationPoint(words3));

    int[] b = {1,2,4,4,4,4,6,7,7,7,9};
    System.out.println("first occurence of 4 is " + findLowerBound(b,4));
    System.out.println("last occurence of 4 is " + findUpperBound(b,4));
    System.out.println("first occurence of 7 is " + findLowerBound(b,7));
    System.out.println("first occurence of 9 is " + findLowerBound(b,9));
  }

  public static long findfloorSqrt(long x){
    long l = 1;
    long r = x/2;
    long mid = 0;
    while(l <= r){
      mid = l + (r -l)/2;
      if(mid * mid > x){
        if (((mid - 1) * (mid -1)) <= x)return mid -1;
        r = mid;
      }
      else if(mid * mid == x)return mid;
      else if(mid * mid < x){
        if( x - (mid * mid) <= 1)return mid;
        l = mid;
      }
    }
    return 0;
  }

  public static int sqrtV2(int A) {
    if( A < 2)return A;
    long l = 1;
    long r = A/2;
    long mid = 0;
    long result = 0;
    while(l <= r){
      mid = l + (r -l)/2;
      long sqr = mid * mid;
      if(sqr == A)return (int)mid;

      if(sqr < A){
        l = mid + 1;
        result = mid;
      }
      if(sqr > A){
        r = mid -1;
      }

    }
    return (int)result;
  }

  /**
   * Finds number of rotations for sorted rotated array
   * @param a
   * @return
   */
  public static int findRotationPoint(String[] a){
    int low = 0;
    int high = a.length -1;
    int mid = 0;
    int n = a.length;
    while(low <= high){
      if(a[low].compareTo(a[high]) <= 0)return low;
      mid = low + (high - low)/2;
      int next = (mid + 1)%n;
      int prev = (mid-1+n)%n;
      if(a[mid].compareTo(a[prev]) <=0 && a[mid].compareTo(a[next]) <= 0)
        return mid;
      if(a[mid].compareTo(a[high]) <= 0)
        high = mid -1;
      if(a[mid].compareTo(a[low]) >= 0)
        low = mid +1;
    }
    return -1;
  }

  /**
   * Finds the first occurence of key in the array
   * lower bound is given as:
   * mid == low && a[low] == key || a[mid] == key && a[mid-1] < key
   * @param a
   * @param key
   * @return int first index of key
   */
  public static int findLowerBound(int[] a , int key){
    int low = 0;
    int high = a.length - 1;
    int mid = 0;
    int k = 0;
    while(low <= high){
      k = k + 1;
      System.out.println(k);
      mid = low + (high - low)/2;
      if((mid == low && a[mid] == key) || (a[mid] == key && a[mid-1] < key))
        return mid;
      else if(a[mid] >= key)
        high = mid -1;
      else
        low = mid + 1;
    }
    return -1;
  }

  /**
   * Finds the last occurence of key in array
   * @param a
   * @param key
   * @return int last index of key
   */
  public static int findUpperBound(int[] a , int key){
    int low = 0;
    int high = a.length -1;
    int mid = 0;
    while(low <= high){
      mid = low + (high - low)/2;
      if((mid == high && a[mid] == key) || (a[mid] == key && key < a[mid+1]))
        return mid;
      else if(a[mid] <= key)
        low = mid +1;
      else
        high = mid -1;
    }
    return -1;
  }
}
