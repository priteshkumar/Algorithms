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
      players[0] = new Player("casper@gmail.com",90);
      players[1] = new Player("asper@gmail.com",70);
      players[2] = new Player("abc.code@gmail.com",60);
      players[3] = new Player("jasper@gmail.com",40);
      players[4] = new Player("coderwall@amail.com",99);
      players[5] = new Player("mavixk@hotmail.com",79);
      Arrays.sort(players);
      printPlayers(players);
      int index = BinarySearch.binarySearch(players,"abc.code@gmail.com");
      System.out.println("Email : " + players[index].getEmail() + "\nscore: " + players[index].getScore());
      index = BinarySearch.binarySearch(players,"mavixk@hotmail.com");
      System.out.println("Email : " + players[index].getEmail() + "\nscore: " + players[index].getScore());
  }

  public static void printPlayers(Player[] p){
    for(Player player:p){
      System.out.println(player.getEmail() + "  " + player.getScore());
    }
  }
}