package com.mavixk.ds.Hashing;
import java.util.*;

public class LongestZeroSum {
  public static void main(String[] args){
    Integer[] a =  {27, -24, -27, -8, -8, 27, -24, -11, -15, 8, 19, 2, 7, -28, -18, 10, 12};
    System.out.println(lszero(new ArrayList<Integer>(Arrays.asList(a))));
    ArrayList<List<Integer>> v = new ArrayList<List<Integer>>();
    List<Integer> e = new ArrayList<Integer>();
    e.add(2);
    e.add(7);
    v.add(e);
    ArrayList<List<Integer>> c = new ArrayList<List<Integer>>();
    List<Integer> d = new ArrayList<Integer>();
    d.add(3);
    d.add(4);
    c.add(d);
    v.addAll(c);
    System.out.println(v);
  }

  public static ArrayList<Integer> lszero(ArrayList<Integer> a) {
    LinkedHashMap<Integer,List<Integer>> m = new LinkedHashMap<Integer, List<Integer>>();
    int maxlen = -1;
    List<Integer> c = null;
    List<Integer> in = new ArrayList<Integer>();

    for(int i=0 ; i < a.size();i++){ //{1 ,2 ,-3 ,3}
      int sum = 0 - a.get(i);
      //m.clear();
      List<Integer> temp = new ArrayList<Integer>();
      temp.add(i);
      m.put(a.get(i),temp);
      int cursum = a.get(i);
      in.clear();
      in.add(i);
      for(int j=i+1; j < a.size();j++){//1,2,-3,3
        in.add(j);
        List<Integer> p = m.get(0 - a.get(j));

        if(p != null){
          //p.add(j);
          int plen = p.size() + 1;
          if(maxlen < plen && plen <= a.size() && (j - p.get(p.size()-1) == 1)){
            maxlen = p.size() + 1;
            c = new ArrayList<Integer>(p);
            c.add(j);
            System.out.println(c);
          }
        }

          temp = new ArrayList<Integer>();
          temp.add(j);
          List<Integer> d = m.get(a.get(j));
          if(d == null || d.size() <= temp.size())
            m.put(a.get(j),temp);
          temp = new ArrayList<Integer>(in);
          //temp.add(j);
          cursum = cursum + a.get(j);
          d = m.get(cursum);
          if(d == null || d.size() < temp.size())
            m.put(cursum ,temp);

        //System.out.println(m);
      }
      if(i == 9)
        System.out.println(m);
      m.clear();

    }
    //System.out.println(maxlen);
    //System.out.println(m);
    for(int i=0 ; i < c.size();i++){
      int val = a.get(c.get(i));
      c.set(i,val);
    }
    return (ArrayList<Integer>) c;
  }
}
