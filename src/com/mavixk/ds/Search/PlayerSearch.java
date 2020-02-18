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
