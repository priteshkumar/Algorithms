package com.mavixk.ds;
import java.lang.reflect.Array;
import java.util.*;

public class SubsetDemo {
    public static void main(String[] args){
        ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        //Collections.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        //printAllsubsets(nums,list,nums.size()-1);
        String out = "";
        printSubsetOfLen(nums,out,nums.size(),3);
    }

    /**
     * prints all distinct subsets of a given set
     * @param a Input ArrayList of numbers
     * @param out List to hold result
     * @param index Current ArrayList index
     */
    public static void printAllsubsets(List<Integer> a,List<Integer> out,int index){

        if(index < 0){
            System.out.println(out);
            return;
        }
        out.add(a.get(index));
        printAllsubsets(a,out,index -1);
        out.remove(out.size()-1);

        //skip duplicate elements
        while(index > 0 && a.get(index) == a.get(index -1)){
            index--;
        }

        printAllsubsets(a,out,index -1);
    }

    /**
     * Prints distinct subsets of length k for given set
     * @param a
     * @param out
     * @param index
     */
    public static void printSubsetOfLen(List<Integer> a,String out,int index,int k){
        if(k > index){
     //       System.out.println("return");
               return;
        }
        if(k == 0){
            System.out.println(out);
            return;
        }

        for(int i = index-1;i >= 0;i--){
           // System.out.println(out + " " + i + " " + index);
            printSubsetOfLen(a,a.get(i) + " " + out,i,k-1);
        }
    }
}
