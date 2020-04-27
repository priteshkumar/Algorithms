package com.mavixk.ds.exam.oop.ds.Hashtables;
import java.util.*;

class DevopsTool{
  private String name;
  private String version;
  public DevopsTool(String name,String version){
    this.name = name;
    this.version = version;
  }

  /**
   * overridden hashcode
   * uses prime numbers for more uniqueness
   * @return
   */
  public int hashCode(){
    final int prime = 31;
    int result = 1;
    result = result * prime + this.name.hashCode();
    result = result * prime + this.version.hashCode();
    return result;
  }

  public boolean equals(Object ob){
    if(this == ob)
      return true;
    if(ob == null)
      return false;
    if(this.getClass() != ob.getClass())
      return false;
    DevopsTool tool = (DevopsTool)ob;
    return ((this.name.equals(tool.name) == true)&& (this.version.equals(tool.version) == true));
  }
}

public class ClassHash {
  public static void main(String[] args){
  //  System.out.println(Integer.MAX_VALUE);
    ArrayList<Integer> m = new ArrayList<Integer>();
    LinkedHashSet<Integer> c = new LinkedHashSet<Integer>();
    c.add(2);
    c.add(3);
    Iterator<Integer> iter = c.iterator();
    int[] val = new int[1000000];

    DevopsTool jenkins = new DevopsTool("Jenkins","2.189");
    DevopsTool ci = new DevopsTool("Jenkins","2.189");

    //object refs are different
    System.out.println(jenkins == ci);
    //object contents are same
    System.out.println(jenkins.equals(ci));

    //check for equal hashcode
    System.out.println(jenkins.hashCode());
    System.out.println(ci.hashCode());

    //Objects hash method usage
    System.out.println(Objects.hash("Jenkins","2.189"));

    DevopsTool docker = new DevopsTool("Docker","18.0ce");
    DevopsTool aws = new DevopsTool("aws","latest");

    System.out.println(docker.hashCode());
    System.out.println(aws.hashCode());

  }
}
