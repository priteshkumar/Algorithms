package com.mavixk.ds;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class DuplicateDemo {
    public static boolean checkDuplicates(int[] a){
        Arrays.sort(a);
        int n = a.length;
        int prev = a[0];
        boolean duplicateFlag = false;
        for(int i=1;i < n;i++){
            if(a[i] == prev){
                duplicateFlag = true;
                break;
            }
            else prev = a[i];
        }
        return duplicateFlag;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of students");
        int n = scan.nextInt();
        int[] id = getInput(n);
        printIds(id);
        System.out.println(checkDuplicates(id));
        int[] test = {2,3,4,1,34,9,-1};
        System.out.println("array has duplicate element : " + checkDuplicates(test));
    }

    public static void printIds(int[] ids){
        for(Integer id:ids){
            System.out.print(id + " ");
        }
        System.out.println();
    }

    public static int[] getInput(int n){
        int id[] = new int[n];
        for(int i=0;i <n;i++){
            id[i] = getrandomNumber(1,2*n);
        }
        return id;
    }

    public static int getrandomNumber(int min,int max){
        int random = ThreadLocalRandom.current().nextInt(min,max+1);
        return random;
    }
}
