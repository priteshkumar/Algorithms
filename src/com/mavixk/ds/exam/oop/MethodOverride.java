package com.mavixk.ds.exam.oop;
import java.util.*;

class Rectangle{
  private int length;
  private int breadth;
  public Rectangle(int l,int b){
    this.length = l;
    this.breadth = b;
  }

  public int getLength(){
    return this.length;
  }

  public int getBreadth(){
    return this.breadth;
  }

  public int getArea(){
    return this.length * this.breadth;
  }

  public int getPerimeter(){
    return (2* this.length) + (2* this.breadth);
  }
}


class Square extends Rectangle{
  public Square(int l) {
    super(l, l);
  }

  public int getArea(){
    return super.getArea();
  }

  public int getPerimeter(){
    return super.getPerimeter();
  }
}

public class MethodOverride{
  public static void main(String[] args){
    Square s = new Square(4);
    System.out.println(s.getArea());
    System.out.println(s.getPerimeter());
  }
}