package com.mavixk.ds.exam.oop;
import java.util.*;

class DevOpsTool{
  private String name;
  private String sourcelang;
  static int version = 2;

  public DevOpsTool(){
    this.name = "TravisCi";
    this.sourcelang = "Python";
  }

  public DevOpsTool(String name,String sourcelang){
    this.name = name;
    this.sourcelang = sourcelang;
  }

  static void printBaseConfig(){
    System.out.println("baseconfig is null");
  }

  void printConfig(){
    System.out.println("Tool: " + this.name);
    System.out.println("SourceCode: " + this.sourcelang);
  }
}

class Jenkins extends DevOpsTool{

  public Jenkins(String name, String sourcelang) {
    super(name, sourcelang);
  }

  static void printBaseConfig(){
    System.out.println("base config in subclass is null");
  }

  public void printConfig(){
    printBaseConfig();
    super.printConfig();
  }
}

public class StaticClassMethod {
  public static void main(String[] args){
    Jenkins ci = new Jenkins("Jenkins","Java");
    DevOpsTool tool = ci;
    ci.printConfig();
    tool.printBaseConfig(); // base class static method shadows subclass static method
  }
}
