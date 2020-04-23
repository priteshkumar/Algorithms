package com.mavixk.ds.exam.oop;
import java.util.*;

class InvalidPasswordException extends RuntimeException{
  public InvalidPasswordException(String message){
    super(message);
  }
}

public class ExceptionDemo {
  public static void main(String[] args){
    try {
      fun1();
    }
    catch(InvalidPasswordException e){
      //e.printStackTrace();
      System.out.println("invalid password");
    }

    //nested exception
    fun2();

    try{
      //System.exit(0);
      int val = 50/0;
      //System.exit(0);//this doenst get executed as exception occurs in first statement
    }
   catch(RuntimeException e){
      //return;//finally block will still be executed
      e.printStackTrace();
      //System.exit(0);//this will skip finally block
    }
    finally{
      System.out.println("code inside finally block");
    }
  }

  public static void fun1(){
    String password = "casper";
    if(password.length() < 8)
      throw new InvalidPasswordException("wrong password length");
  }

  public static void fun2() {
    try {
      try {
        String val = null;
        System.out.println(val.toUpperCase());
      } catch (NullPointerException e) {
        System.out.println("inside inner catch:Please fix null string");
      }
      try {
        System.out.println(40 / 0);
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("fix array index");
      }
    }
    catch(ArithmeticException e){
      System.out.println("in outer catch: fix divide by 0 error");
    }
    catch(NullPointerException e){
      System.out.println("in outer catch: fix null string");
    }
  }
}
