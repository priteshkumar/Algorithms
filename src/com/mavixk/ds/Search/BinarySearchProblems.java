package com.mavixk.ds.Search;
import java.util.*;

public class BinarySearchProblems {
  public static void main(String[] args){
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

  public static int findRotationPoint(String[] a){

    int low = 0;
    int high = a.length - 1;
    int mid = -1;
    while(low <= high){
      mid = low + (high - low)/2;
      if(low == high)return low;
      if(low == high -1){
        if(a[low].compareTo(a[high]) > 0)
          return high;
        else
          return low;
      }

      if(a[mid].compareTo(a[mid-1]) < 0  && a[mid].compareTo(a[mid+1]) < 0)return mid;
      else if(a[mid].compareTo(a[low]) > 0){
        if(a[mid].compareTo(a[high]) < 0)
          high = mid - 1;
        else
          low = mid + 1;

      }
      else if(a[mid].compareTo(a[low]) < 0){
        if(a[mid].compareTo(a[high]) < 0)
          high = mid -1;
        else
          low = mid + 1;
      }
    }
    return -1;
  }
}
