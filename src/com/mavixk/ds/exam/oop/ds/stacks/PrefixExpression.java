package com.mavixk.ds.exam.oop.ds.stacks;
import java.util.*;

public class PrefixExpression {
  public static void main(String[] args){
    String exp = "* - 6 / 5 2 - / 8 4 1";
    //exp = "( + 7 ( * 8 12 ) ( * 2 ( + 9 4 ) 7 ) 3 )";
    //exp = "- / * 20 * 50 + 3 6 300 2";
    System.out.println(evalPrefix(exp));

  }

  public static int prec(char val){
    if(val == '+')
      return 1;
    else if(val == '-')
      return 2;
    else if(val == '*')
      return 3;
    else if(val == '/')
      return 4;
    else
      return -1;
  }

  public static int evalPrefix(String exp){
    Stack<Integer> temp = new Stack<Integer>();
    //Integer.valueOf("+");
    String[] v = exp.split(" ");
    for(int i=v.length-1;i >= 0;i--){
      String c = v[i];

      if(c.equals("*") || c.equals("/") || c.equals("+") || c.equals("-")){
        int a = temp.pop();
        int b = temp.pop();
        int res=0;
        switch(c){
          case "+":res = a + b;
            break;
          case "-": res = a - b;
            break;
          case "*": res = a * b;
            break;
          case "/": res = a/b;
            break;
          default:
            break;
        }
        temp.push(res);
      }
      else if((c.equals(")") == false) && (c.equals("(") == false)){
        temp.push(Integer.valueOf(c));
      }
      //System.out.println(temp);
    }
    return temp.pop();
  }
}
