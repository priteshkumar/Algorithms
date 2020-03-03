package com.mavixk.ds.Sorting;
import java.util.*;

class FreqComparator implements Comparator<ArrayList<Integer>>{
  public int compare(ArrayList<Integer> a,ArrayList<Integer> b){
    if(a.get(1) > b.get(1))return -1;
    else if(a.get(1) < b.get(1))return 1;
    else if(a.get(0) < b.get(0))return -1;
    return 0;
  }
}

public class FrequencySorting {

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] a = new int[n];
    for(int i=0;i < n;i++){
      a[i] = scan.nextInt();
    }
    sortByFreq(a,n);
  }

  /**
   * Counting sort based algorithm.
   * Sorts array based on frequency of elements
   * <p>
   * Elements having equal frequency ,smaller element is placed first
   * <p>
   * @param arr
   * @param n
   */
  public static void sortByFreq(int arr[], int n)
  {
    //elements are in range(1-60)
    int[] a = arr;
    ArrayList<ArrayList<Integer>> alist = new ArrayList<ArrayList<Integer>>(61);
    for(int i=0; i < 61;i++){
      ArrayList<Integer> plist = new ArrayList<Integer>(2);
      plist.add(i);
      plist.add(0);
      alist.add(plist);
    }

    for(int i=0;i < n;i++){
      int val = (alist.get(a[i])).get(1);
      (alist.get(a[i])).set(1,val+1);
    }

    Collections.sort(alist,new FreqComparator());
    StringBuilder sb = new StringBuilder();
    ListIterator<ArrayList<Integer>> iter = alist.listIterator();
    while(iter.hasNext()){
      ArrayList<Integer> b = iter.next();
      int k = b.get(1);
      int val = b.get(0);
      String s = String.valueOf(val);
      while(k > 0){
        sb.append(s + " ");
        k--;
      }
    }
    System.out.print(sb.toString());
  }
}
