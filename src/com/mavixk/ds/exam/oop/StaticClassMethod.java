package com.mavixk.ds.exam.oop;

class DevOpsTool {

  static int version = 2;
  private final String name;
  private final String sourcelang;

  public DevOpsTool() {
    this.name = "TravisCi";
    this.sourcelang = "Python";
  }

  public DevOpsTool(String name, String sourcelang) {
    this.name = name;
    this.sourcelang = sourcelang;
    System.out.println(this.getClass().getName());
  }

  static void printBaseConfig() {
    System.out.println("baseconfig is null");
  }

  void printConfig() {
    System.out.println("Tool: " + this.name);
    System.out.println("SourceCode: " + this.sourcelang);
  }
}

class Jenkins extends DevOpsTool {

  //private int slaves;
  public Jenkins(String name, String sourcelang) {
    super(name, sourcelang);
    //this.slaves = 2;
  }

  static void printBaseConfig() {
    System.out.println("base config in subclass is null");
  }

  public void printConfig() {
    printBaseConfig();
    super.printConfig();
  }

  //public void runJob(){System.out.println("running build job");}
}

public class StaticClassMethod {

  public static void main(String[] args) {
    Jenkins ci = new Jenkins("Jenkins", "Java");
    DevOpsTool tool = ci;
    //ci.printConfig();
    DevOpsTool.printBaseConfig(); // base class static method shadows subclass static method
    tool.printConfig(); // calls overridden method via superclass ref type

    //results in ClassCast exception
    try {
      Jenkins jenkins = (Jenkins) new DevOpsTool();
    } catch (ClassCastException e) {
      e.printStackTrace();
    }

    Jenkins jenkins = (Jenkins) tool; //do upcast
    jenkins.printConfig();
  }
}
