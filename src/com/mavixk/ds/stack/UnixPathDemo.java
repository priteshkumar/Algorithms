package com.mavixk.ds.stack;
import java.util.*;

public class UnixPathDemo {
  public static void main(String[] args){
    String str = new String("/a/./b/../../c/");
    String res = simplifyPath(str);
    System.out.println(res);
    res = simplifyPath("/home//mavixk");
    System.out.println(res);
    res = simplifyPath("/home///mavixk/../desktop/");
    System.out.println(res);
  }

  /**
   * simplify unix path using dirstack
   * @param path
   * @return
   */
  public static String simplifyPath(String path){
    Stack<String> s = new Stack<String>();
    int n = path.length();
    String a = path;
    String res = "/"; //use stringbuilder for optimisation
    String dir = "";
    for(int i=0;i < n;i++){
      dir = "";
      while(i < n && a.charAt(i) == '/')
        i++;
      while(i < n && a.charAt(i) != '/'){
        dir = dir + a.charAt(i);
        i++;
      }
      if(dir.equals(".") == true)
        continue;
      else if(dir.equals("..") == true){
        if(s.empty() == false)
          s.pop();
      }
      else
        s.push(dir);
    }

    //use stringbuilder for more optimisation
    String temp = "";
    while(s.empty() == false){
      if(s.size() != 1)
        temp = "/" + s.pop() + temp;
      else
        temp = s.pop() + temp;
    }
    return res+temp;
  }

  /**
   * simplify unix path using stack with complex parsing logic
   * @param path
   * @return
   */
  public static String simplify(String path){
    Stack<String> s = new Stack<String>();
    int n = path.length();
    String a = path;
    String temp = "";
    int k = 0;
    boolean flag = false;
    for(int i=0 ; i < n;i = k){
      temp = "";
     int c = a.indexOf('/',i);
     if(c != -1){
       temp = temp + "/";
       //i = c;
       k = a.indexOf("/",c+1);
       if(k == -1){
         temp = "";
         temp = temp + a.substring(c);
         if(temp.equals("/.") == false && temp.equals("/..") == false && temp.equals("/") == false)
           s.push(temp);
         else if(temp.equals("/..") == true){
           if(s.empty() == false)
             s.pop();
         }
         break;
       }
       if(k != -1 && k - c == 1){
         while(k < n && a.charAt(k) == '/')k++;
         c = k-1;
         k = a.indexOf('/',c+1);
         if(k == -1)
           k = n;
       }
       if(k != -1 && k - c > 1){
         temp = temp + a.substring(c+1,k);
         if(temp.equals("/.") == false && temp.equals("/..") == false)
           s.push(temp);
         else if(temp.equals("/..") == true){
           if(s.empty() == false)
             s.pop();
         }
       }
     }
    }

    temp = "";
    if(s.empty() == true)
      return "/";
    while(s.empty() == false){
      temp = s.peek() + temp;
      s.pop();
    }
    return temp;
  }
}
