package com.mavixk.ds;
import java.util.*;

public class HackMoney {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    int money = 0;
    while(true) {
      money = scan.nextInt();
      if(money < 0)break;
      if (hackMoney(1, money) == true)
        System.out.println("Yes");
      else
        System.out.println("No");
    }
    scan.close();
  }

  public static boolean hackMoney(long amt , long money){
    if(money < 10)return false;
    if(amt == money){
      //System.out.println("Yes");
      return true;
    }
    if(amt > money){
      return false;
    }
    boolean step1 = hackMoney(amt * 10,money);
    boolean step2 = hackMoney(amt * 20,money);
    if(step1 == true || step2 == true)
      return true;
    else
      return false;
  }
}
