package com.mavixk.ds.Queue;

import java.util.*;
import java.lang.Math;
public class DequeDemo {

  public static void main(String[] args) {
    System.out.println("-3".compareTo("-2"));
    Deque<Character> s = new LinkedList<Character>();
    String temp = "abba";
    for (int i = 0; i < temp.length(); i++) {
      s.addLast(temp.charAt(i));
    }
    System.out.println(checkPalindrome(s));
    s.clear();
    temp = "acddca";
    for (int i = 0; i < temp.length(); i++) {
      s.addLast(temp.charAt(i));
    }
    System.out.println(checkPalindrome(s));
    String exp = "j+k*(k^l-m)^(n+o*p)-q+a";
    System.out.println(convertToPostfix(exp));
  }

  public static boolean checkPalindrome(Deque<Character> s) {
    while (s.size() >= 2) {
      char a = s.removeFirst();
      char b = s.removeLast();
      if (a != b) {
        return false;
      }
    }
    return true;
  }

  /**
   * Converts infix exp to postfix exp using stack
   * @param exp
   * @return
   */
  public static String convertToPostfix(String exp) {
    Stack<Character> temp = new Stack<Character>();
    String postexp = "";
    for (int i = 0; i < exp.length(); i++) {
      char val = exp.charAt(i);
      if (val == '(') {
        temp.push(val);
      } else if (val == '^' || val == '*' || val == '/' || val == '+' || val == '-') {
        if (temp.empty() == true || temp.peek() == '(') {
          temp.push(val);
        } else {
          if (val == '^') {
            temp.push(val);
          } else if (val == '*' || val == '/') {
            if (temp.peek() != '^' && temp.peek() != '*' && temp.peek() != '/') {
              temp.push(val);
            } else {
              while (temp.empty() == false && (temp.peek() == '^' || temp.peek() == '*'
                  || temp.peek() == '/')) {
                postexp =  postexp + temp.pop();
              }
              temp.push(val);
            }
          } else if (val == '+' || val == '-') {
            if (temp.peek() != '^' && temp.peek() != '*' && temp.peek() != '/' && temp.peek() != '+'
                && temp.peek() != '-') {
              temp.push(val);
            } else {
              while (temp.empty() == false && (temp.peek() == '^' || temp.peek() == '*'
                  || temp.peek() == '/' || temp.peek() == '+' || temp.peek() == '-')) {
                postexp = postexp + temp.pop();
              }
              temp.push(val);
            }
          }
        }
      } else if (val == ')') {
        while (temp.empty() == false && temp.peek() != '(') {
          postexp = postexp + temp.pop();
        }
        temp.pop();
      } else {
        postexp = postexp + val;
      }
    }
    while (temp.empty() == false) {
      postexp = postexp + temp.pop();
    }
    return postexp;
  }

}
