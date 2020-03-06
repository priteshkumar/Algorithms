package com.mavixk.ds;
import java.util.*;

class Interval{
  int start;
  int end;
  public Interval(int start,int end){
    this.start = start;
    this.end = end;
  }
}

public class MergeIntervalsDemo {

  public static void main(String[] args){
    ArrayList<Interval> intervals = new ArrayList<Interval>();
    //[1,2],[3,5],[6,7],[8,10],[12,16] ... [4,9]
    intervals.add(new Interval(1,2));
    intervals.add(new Interval(3,5));
    intervals.add(new Interval(6,7));
    intervals.add(new Interval(8,10));
    intervals.add(new Interval(12,16));
    intervals = insertInterval(intervals,new Interval(4,9));
    System.out.println(intervals);
    for(Interval i:intervals){
      System.out.print("[" + i.start + "," + i.end + "] ");
    }
    System.out.println();
    intervals.clear();
    intervals.add(new Interval(1,3));
    intervals.add(new Interval(6,9));
    intervals = insertInterval(intervals,new Interval(10,14));
    System.out.println(intervals);
    for(Interval i:intervals){
      System.out.print("[" + i.start + "," + i.end + "] ");
    }
    System.out.println();

  }


  public static ArrayList<Interval> insertInterval(ArrayList<Interval> intervals,
      Interval newInterval) {
    ArrayList<Interval> res = new ArrayList<Interval>();
    ArrayList<Interval> a = intervals;
    Interval k = newInterval;
    int i = 0;
    boolean added = false;
    while(i < a.size()){ //[1,2],[3,5],[6,7],[8,10],[12,16] ... [4,9]
      if(k.start > a.get(i).end) { // [1,2] [6,9] [10,12]   [3,5]
        res.add(a.get(i));
        i++;
      }
      else if(k.start <= a.get(i).end){
        added = true;
        if(k.end < a.get(i).start){
          res.add(k);
          res.add(a.get(i));
        }
        else {
          int s = a.get(i).start;
          int e = a.get(i).end;
          s = s <= k.start ? s : k.start;
          e = e >= k.end ? e : k.end;
          res.add(new Interval(s, e));
        }
        int j = i + 1;
        while(j < a.size()){
          if(a.get(j).start > res.get(res.size()-1).end) {
            res.add(a.get(j));
            j++;
          }
          else if(a.get(j).start <= res.get(res.size()-1).end){
            int n = res.size() -1;
            int start = res.get(n).start <= a.get(j).start?res.get(n).start:a.get(j).start;
            int end = res.get(n).end >= a.get(j).end?res.get(n).end:a.get(j).end;
            res.get(n).start = start;
            res.get(n).end = end;
            j++;
          }
        }
        break;
      }
    }
    if(added == false)
      res.add(k);
    return res;
  }
}
