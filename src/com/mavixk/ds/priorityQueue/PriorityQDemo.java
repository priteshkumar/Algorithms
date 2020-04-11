package com.mavixk.ds.priorityQueue;
import java.util.*;

public class PriorityQDemo {
  public static final int CLUB = 1;
  public static final int SEASON = 2;
  public static final int ONLINE = 3;
  public static final int COUNTER = 4;

  static class TicketComparator implements Comparator<Ticket>{
    public int compare(Ticket a,Ticket b){
      return a.ticket_Type - b.ticket_Type;
    }
  }

  static class Ticket{
    private String customer;
    private int ticket_Type;
    public Ticket(String name,int ticket_Type){
      this.customer = name;
      this.ticket_Type = ticket_Type;
    }
  }

  public static void main(String[] args){
    PriorityQueue<Ticket> pq = new PriorityQueue<Ticket>(new TicketComparator());
    pq.add(new Ticket("Rashmi",SEASON));
    pq.add(new Ticket("Jai",CLUB));
    pq.add(new Ticket("Monica",ONLINE));
    pq.add(new Ticket("Chander",COUNTER));
    pq.add(new Ticket("Phani",SEASON));
    pq.add(new Ticket("Casper",COUNTER));
    System.out.println("printing waitlisted priority...");
    int len = pq.size();
    for(int i=0;i < len;i++){
      System.out.println(pq.peek().customer);
      pq.poll();
    }
  }
}
