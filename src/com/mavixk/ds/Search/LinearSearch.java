package com.mavixk.ds.Search;
import java.util.*;

public class LinearSearch {

    public static void main(String[] args) {
	// write your code here
        if(5.9 == 5.901)System.out.println("yes");
        int[] nums = {1,2,3,4,9,76,34,-1,-2};
        System.out.println(linearSearch(nums,9));
        System.out.println(linearSearch(nums,19));
        Integer[] a = {1,2,3,4,9,76,-2,-1};
        System.out.println(linearSearchV2(a,9));
        Double[] b = {2.3,3.2,4.0,5.2};
        System.out.println(linearSearchV2(b,5.2));
        String[] c = {"docker","jenkins","aws","ansible"};
        System.out.println(linearSearchV2(c,"aws"));
        System.out.println(linearSearchRecur(c,"jenkins",0));
        System.out.println(linearSearchRecur(c,"buildbot",0));

    }

    /**
     * Iterative linear search for int
     * @param nums
     * @param key
     * @return
     */
    public static int linearSearch(int[] nums,int key){
        int index = -1;
        int i = 0;
        for(Integer val:nums){
            if(val.equals(key)){
                index = i;
                break;
            }
            i++;
        }
        return index;
    }

    /**
     * Iterative generic linear search
     * @param a
     * @param key
     * @param <T>
     * @return
     */
    public static <T> int linearSearchV2(T[] a,T key){
        int index = -1;
        int i = 0;
        for(T val:a){
            if(val.equals(key)){
                index = i;
                break;
            }
            i++;
        }
        return index;
    }

    /**
     * Recursive generic linear search
     * @param a
     * @param key
     * @param i
     * @param <T>
     * @return
     */
    public static <T> int linearSearchRecur(T[] a,T key,int i){
        int index = -1;
        if(i >= a.length)return index;
        if(a[i].equals(key)){
            index = i;
            return index;
        }
        return linearSearchRecur(a,key,i+1);
    }
}
