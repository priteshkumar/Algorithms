package com.mavixk.ds.Search;
import java.io.*;
import java.util.*;

public class TestCaseReader {
  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("/home/mavixk/input");
    Scanner input = new Scanner(file);
    ArrayList<Integer> a = new ArrayList<Integer>();
    while(input.hasNextInt()){
      int n = input.nextInt();
      a.add(n);
    }
    System.out.println(a);
    System.out.println(a.indexOf(350));
  }
}
