package com.mavixk.ds.exam.oop;

interface BuildTool {

  default public void display() {
    System.out.println("this is build tool");
  }

  void showlog();
}

interface PackageTool {

  default public void display() {
    System.out.println("this is packaging tool");
  }

  void showlog();
}

public class MultiInterfaceDemo implements BuildTool, PackageTool {

  public static void main(String[] args) {
    MultiInterfaceDemo m = new MultiInterfaceDemo();
    m.showlog();
    m.display();
  }

  public void display() {
    BuildTool.super.display();
    PackageTool.super.display();
  }

  public void showlog() {
    System.out.println("logging tool results");
  }

  private interface ConfigTool {

    default public void configure() {
      System.out.println("configured aws");
    }
  }
}
