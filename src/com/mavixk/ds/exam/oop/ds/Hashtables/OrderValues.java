package com.mavixk.ds.exam.oop.ds.Hashtables;
import java.util.*;

public class OrderValues {
  public static void main(String[] args){
    HashMap<Integer,String> m = new HashMap<Integer, String>();
    m.put(1,"jenkins");
    m.put(2,"jenkins");
    m.put(3,"docker");
    m.put(4,"aws");
    m.put(5,"ansible");
    m.put(6,"aws");
    m.put(7,"github");
    String s = "hello";
    System.out.println('d' - 97);
    System.out.println((char)99);
    LinkedHashMap<String,Integer> res = new LinkedHashMap<String,Integer>();
    for(Integer key:m.keySet()){
      String val = m.get(key);
      if(res.get(val) == null){
        res.put(val,key);
      }
    }

    for(String key:res.keySet()){
      System.out.println(key);
    }

  }
}
