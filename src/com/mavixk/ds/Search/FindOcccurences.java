package com.mavixk.ds.Search;

import java.util.ArrayList;
import java.util.List;

public class FindOcccurences {
  public static void main(String[] args){
    FindOcccurences occurences = new FindOcccurences();
    List<Integer> alist = new ArrayList<Integer>();
    for(int i = 1;i < 4;i++){
      alist.add(i);
    }
    alist.add(7);
    alist.add(7);
    alist.add(7);
    for(int i=9;i < 11;i++)alist.add(i);

    System.out.println(occurences.findCount(alist,7));
  }

  public int findCount(final List<Integer> A, int B) {
    int firstindex = getFirstIndex(A,B);
    int lastindex = getLastIndex(A,B);
    if(firstindex == -1)return 0;
    return (lastindex - firstindex + 1);
  }

  public int getFirstIndex(final List<Integer> A,int B){
    final List<Integer> a = A;
    int low = 0;
    int high = a.size() -1;
    int mid = 0;
    while(low <= high){
      mid = low + (high - low)/2;
      if((low == mid && B == a.get(low)) || (a.get(mid) == B && a.get(mid) > a.get(mid-1)))
        return mid;
      else if(a.get(mid) >= B)
        high = mid -1;
      else
        low = mid +1;
    }

    return -1;
  }

  public int getLastIndex(final List<Integer> A,int B){
    final List<Integer> a = A;
    int low = 0;
    int high = a.size() -1;
    int mid = 0;
    while(low <= high){
      mid = low + (high - low)/2;
      if((high == mid && B == a.get(high)) || (a.get(mid) == B && a.get(mid) < a.get(mid+1)))
        return mid;
      else if(a.get(mid) <= B)
        low = mid + 1;
      else
        high = mid -1;
    }

    return -1;
  }

}
