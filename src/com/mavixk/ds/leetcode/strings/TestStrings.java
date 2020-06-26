package mavixk.ds.leetcode.strings;

public class TestStrings {
  public static void main(String[] args){
    String str1 = "UpGrad";
    //read intern() method

    String str2 = str1.intern();
    String str3 = new String("UpGrad");
    String str4 = str3.intern();
    System.out.print((str1 == str2)+" ");
    System.out.print((str1 == str3)+" ");
    System.out.print((str1 == str4)+" ");
    System.out.print((str2 == str3)+" ");
    System.out.print((str2 == str4)+" ");
    System.out.print((str3 == str4));
  }
}
