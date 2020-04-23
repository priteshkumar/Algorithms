package com.mavixk.ds.exam.oop;
import java.util.*;

public class CardDemo {
  public static void main(String[] args){
    double val = -1.0;
    boolean is = val == -1;
    System.exit(0);
    System.out.println(is);
    String suit = "Spades";
    System.out.println(getSuitPriority(suit));
    suit = "Diamond";
    System.out.println(getSuitPriority(suit));
  }

  public static int getSuitPriority(String suitString) {
    System.out.println(suitString);
    int priority = -1;
    switch(suitString){
      case "Spades":priority = 1;
        break;
      case "Diamond": priority = 2;
        break;
      case "Hearts":priority = 3;
        break;
      case "Clubs": priority = 4;
        break;
      default:
        break;
    }
    System.out.println(priority);
    return priority;
  }
}
