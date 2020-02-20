package com.mavixk.ds.Sorting;
import java.util.*;

class NamesSorting {

  public static void main(String ss[]) {
    Scanner scanner = new Scanner(System.in);
    int size = scanner.nextInt();
  //  String firstNames[] = new String[10];
   // String lastNames[] = new String[10];
    String[] firstNames = {"janella", "arianna", "bob", "sheryll",
        "katelynn", "alphonso", "bertha", "ivette", "michiko ","evelin"};

    String[] lastNames = {"valene" ,"krista", "lyn", "melony", "laila", "laree", "raylene",
        "lynwood ","tim ","keech"};
  /*  for (int i = 0; i < size; i++) {
      firstNames[i] = scanner.next().toLowerCase();
    }
    for (int i = 0; i < size; i++) {
      lastNames[i] = scanner.next().toLowerCase();
    }*/
    insertionSort(firstNames, false);
    insertionSort(lastNames, true);
    System.out.println("print firstnames");
    for (int i = 0; i < firstNames.length; i++) {
      System.out.println(firstNames[i]);
    }
    System.out.println("print lastnames");
    for (int i = 0; i < lastNames.length; i++) {
      System.out.println(lastNames[lastNames.length -i -1]);
    }
  }

  public static String[] insertionSort(String[] names,boolean reverse){
    int n = names.length;
    int j = 0;
    boolean flag = false;
    for(int i=1;i < n;i++){
      j = i;
      while(j > 0 && (names[j].compareTo(names[j-1]) < 0)){
        String temp = names[j-1];
        names[j-1] = names[j];
        names[j] = temp;
        j = j -1;
      }
    }
    return names;
  }
}