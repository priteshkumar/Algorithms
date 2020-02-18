package com.mavixk.ds.Search;
import java.util.*;

class Player implements Comparable<Player>{
  private String email;
  private int score;
  public Player(String email,int score){
    this.email = email;
    this.score = score;
  }

  public String getEmail(){
    return this.email;
  }

  public int getScore(){
    return this.score;
  }

  @Override
  public int compareTo(Player o) {
    return this.getEmail().compareTo(o.getEmail());
  }
}

public class PlayerSearch {
  public static void main(String[] args){
    Player[] players = new Player[6];
    players[0] = new Player("casper@gmail.com",10);
    players[1] = new Player("asper@gmail.com",90);
    players[2] = new Player("jasper@gmail.com",70);
    players[3] = new Player("asper.code@gmail.com",70);
    players[4] = new Player("abc.code@gmail.com",60);
    players[5] = new Player("cbc.code@gmail.com",30);
    Arrays.sort(players);
    System.out.println("players in sorted order with email...");
    for(Player player:players){
      System.out.println(player.getEmail());
    }

    int index = BinarySearch.binarySearch(players,"abc.code@gmail.com");
    System.out.println(players[index].getEmail() + " score is " + players[index].getScore());
    index = BinarySearch.binarySearch(players,"asper@gmail.com");
    System.out.println(players[index].getEmail() + " score is " + players[index].getScore());
  }
}
