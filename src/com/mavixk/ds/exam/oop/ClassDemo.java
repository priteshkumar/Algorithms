package com.mavixk.ds.exam.oop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Math.*;

class Circle{
  public static double radius;
  public static double area(){
    return Math.PI * radius * radius;
  }
}

public class ClassDemo {
  static final double pi;
  final int CAPACITY;
  static{
    pi = Math.PI;
  }
  public ClassDemo() {
    CAPACITY = 10;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for(int i=0;i < 4;i++) {
      String[] temp = br.readLine().split(" ");
      for(int j=0; j < temp.length;j++)
        System.out.print(temp[j] + " ");
    }
    System.out.println();
    System.out.println(pi);
    Circle.radius = 2.0;
    System.out.println(Circle.area());
  }
}
