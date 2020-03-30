package com.mavixk.ds.stack;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

public class HistoGramMax {
  public static void main(String[] args){
    int[] h = {6,2,5,4,5,1,6};
    System.out.println(getMaxArea(h));
    h = new int[]{6,3,4,2};
    System.out.println(getMaxArea(h));
    h = new int[]{2, 1, 5, 6, 2, 3};
    System.out.println(getMaxArea(h));
  }

  /**
   * calculates max area in histogram
   * @param a
   * @return
   */
  public static int getMaxArea(int[] a){
    Entry[] temp = new Entry[a.length];
    int top = -1;
    int maxarea = -1;
    int curarea;
    int left;
    for(int i=0; i <= a.length;i++){
      ;
      while(top >= 0 && (i == a.length || (int)temp[top].getValue() > a[i])){
        if(top > 0)
          left = (int)temp[top-1].getKey();
        else
          left = -1;
        curarea = (i - left-1) * (int)temp[top].getValue();
        --top;
        if(curarea > maxarea)
          maxarea = curarea;

      }
      if(i < a.length){
        ++top;
        temp[top] = new SimpleEntry(i,a[i]);
      }
    }
    return maxarea;
  }
}
