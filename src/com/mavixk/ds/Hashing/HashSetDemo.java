package com.mavixk.ds.Hashing;
import java.util.*;

public class HashSetDemo {
  public static void main(String[] args){
    int[] a = {4, 5, 8, 9, 7, 6, 7, 3, 3};
    System.out.println(checkContiguous(a));
    int[] b = {4, 8, 9, 7, 6, 7, 3, 3};
    System.out.println(checkContiguous(b));
  }

  public static boolean checkContiguous(int[] a){
    HashSet<Integer> m = new HashSet<Integer>();
    Map<Integer,String> map = new HashMap<>();
    map.put(1,"A");
    map.put(2,"A");
    map.put(3,"B");
    LinkedHashSet<String> s = new LinkedHashSet<>();
    for(Integer val:map.keySet()){
      s.add(map.get(val));
    }
    Iterator<String> c = s.iterator();
    while(c.hasNext()){
      System.out.print(c.next() + " ");
    }

    for(int i=0; i < a.length;i++){
      m.add(a[i]);
    }
    int temp = a[0];
    int lcount = 0;
    while(m.contains(temp) == true){
      lcount++;
      temp--;
    }
    int rcount = 0;
    temp = a[0] + 1;
    while(m.contains(temp) == true){
      lcount++;
      temp++;
    }
    return (lcount + rcount) == m.size()?true:false;
  }
}
