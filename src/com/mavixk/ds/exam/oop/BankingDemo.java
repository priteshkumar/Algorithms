package com.mavixk.ds.exam.oop;
import java.util.*;

abstract class HomeLoan{
  protected double amount;
  protected int time;
  public HomeLoan(double amount,int time){
    this.amount = amount;
    this.time = time;
  }
  abstract double  getRateOfIntererst();
  abstract double getSimpleInterest();
}

class Bank1 extends HomeLoan{
  public Bank1(double amount,int time){
    super(amount,time);
  }

  public double getRateOfIntererst(){
    return 7.2;
  }

  public double getSimpleInterest(){
    double si = (amount * time * this.getRateOfIntererst())/100;
    return amount + si;
  }
}

class Bank2 extends HomeLoan{
  public Bank2(double amount,int time){
    super(amount,time);
  }

  public double getRateOfIntererst(){
    return 8.1;
  }

  public double getSimpleInterest(){
    double si = (amount * time * this.getRateOfIntererst())/100;
    return amount + si;
  }
}

public class BankingDemo {
  public static void main(String[] args){
    Bank1 a = new Bank1(23400.2,2);
    Bank2 b = new Bank2(23400.2,2);
    if(a.getRateOfIntererst() < b.getRateOfIntererst()){
      System.out.println("File for loan in bank1");
      System.out.println(a.getSimpleInterest());
    }
    else{
      System.out.println("File for loan in bank2");
      System.out.println(b.getSimpleInterest());
    }
  }
}
