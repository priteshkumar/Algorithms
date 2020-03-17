package com.mavixk.ds.stack;

import java.util.*;

public class StackDemo {

  public static void main(String[] args) {
    Stack<Integer> s = new Stack<Integer>();
    s.push(11);
    s.push(22);
    s.push(33);
    s.push(44);
    s.push(55);
    s.push(66);
    char a = '(';
    char b = ')';
    String c = String.valueOf(a) + b;
    System.out.println("matched string " + c);
    Stack<Character> sc = new Stack<Character>();
    System.out.println(s.elementAt(s.size() - 5));
    System.out.println(s);
    System.out.println(s.search(22));
    System.out.println(s.search(6));
    System.out.println(s.pop());
    System.out.println(s);
    System.out.println(matchParentheses("()[]{}"));
  }

  /**
   * Match parentheses uses stack
   * @param A
   * @return
   */
  public static int matchParentheses(String A) {
    Stack<Character> s = new Stack<Character>();
    String a = A;
    for (int i = 0; i < a.length(); i++) {
      char c = a.charAt(i);
      if (c == '(' || c == '{' || c == '[') {
        s.push(c);
      } else if (c == ')' || c == '}' || c == ']') {
        if (s.empty() == true) {
          return 0;
        }
        char top = s.pop();
        String match = "" + top + c;
        if (match.equals("()") != true && match.equals("{}") != true
            && match.equals("[]") != true) {
          return 0;
        }
      }
    }
    return (s.empty() == true) ? 1 : 0;
  }
}
