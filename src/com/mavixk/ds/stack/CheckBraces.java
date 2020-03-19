package com.mavixk.ds.stack;
import java.util.*;

public class CheckBraces {
  public static void main(String[] args){
    String exp = "a+b";
    System.out.println(checkDuplicate(exp));
    exp = "((a+b))";
    System.out.println(checkDuplicate(exp));
    exp = "(a+(b+c))";
    System.out.println(checkDuplicate(exp));
    exp = "(((a+1))+(b+1))";
    System.out.println(checkDuplicate(exp));
    exp = "(a+b)+((c+d))";
    System.out.println(checkDuplicate(exp));
    exp = "((a+b)) + c";
    System.out.println(checkDuplicate(exp));
    exp = "(2)";
    System.out.println(checkDuplicate(exp));
  }

  //(a + (b +c))
  public static boolean checkDuplicate(String exp){
    Stack<Character> s = new Stack<Character>();
    boolean flag = false;
    int lasto = -1;
    int firstc = -1;
    for(int i=0; i < exp.length();){
      while(i < exp.length() && exp.charAt(i) != ')'){
        s.push(exp.charAt(i));
        if(exp.charAt(i) == '(')
          lasto = i;
        i++;
      }
      if(i >= exp.length())break;
      if(exp.charAt(i) == ')'){
        if(s.peek() == '('){
          flag = true;
          break;
        }
        else{
          int count = 0;
          while(s.peek() != '('){
            s.pop();
            count++;
          }
          s.pop();
          if(count <= 1){flag = true;break;}
        }
      }
      i++;
    }
    return flag == true?true:false;
  }
}
