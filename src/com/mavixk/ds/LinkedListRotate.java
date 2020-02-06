package com.mavixk.ds;
import java.util.*;
import java.lang.Math;

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class LinkedListRotate {

    public static void main(String[] args) {
	// write your code here
        int n = 8;
        int k = 4;
        int[] nums = {1,2,3,4,5,6,7,8};
        Node head = null;
        Node cur = null;
        for(int i=0;i< nums.length;i++){

            Node temp = new Node(nums[i]);
            if(head == null){head = temp;cur = head;}
            else{
                cur.next = temp;
                cur = temp;
            }
        }

        cur = head;
        while(cur != null){
            System.out.println(cur.data);
            cur = cur.next;
        }
        double v = (double)1/125;
        System.out.println(v);
        //rotateArray(nums);
        //int[] c = {1,2};
        //rotateArray(c);
        //calcLogarithm();
        //rotateListcounterClock(head,10);
        //System.out.println(isPalindrome("abba"));
        System.out.println("2 raised to 3 is " + calcPower(2,3));
        System.out.println("4 raised to 4 is " + calcPower(4,4));
        System.out.println("5 raised to 3 is " + calcPower(5,3));
        System.out.println("2 raised to 8 is " + calcPower(2,8));
        System.out.println("2 raised to -2 is " + calcPower(2,-2));
        System.out.println("5 raised to -3 is " + calcPower(5,-3));
        checkPalindromicNumber();
    }

    public static void rotateListcounterClock(Node head,int k){
        Node temp = head;
        Node tail = null;
        int len = 0;
        while(temp != null){
            len++;
            if(temp.next == null)tail = temp;
            temp = temp.next;
        }

        temp = head;
        int i = 0;
        Node cur = null;
        while(i < (k % len)){
            cur = temp.next;
            temp.next = null;
            tail.next = temp;
            tail = tail.next;
            temp = cur;
            i++;
        }

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void rotateArray(int[] a){
        int n = a.length;
        int k = 4;
        //1 2 3 4 5 6 7 8  -> //3 4 5 6 7 8 1 2
        int b[] = new int[n];
        for(int i=0;i < b.length;i++){
            b[i] = a[(i + (k % n))%n];
        }
        for(Integer val:b){
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void calcLogarithm(){
        int n = 7;
        System.out.println(Math.log(n));
        System.out.println(Math.log10(n)/Math.log10(8));
    }

    public static double calcPower(int x,int n){
        double result = 1;
        if(n == 0)return 1;
        else if(n > 0 && n %2 == 0)result = result * calcPower(x,n/2) * calcPower(x,n/2);
        else if(n > 0 && n %2 != 0)result = result * x * calcPower(x,n-1);
        else if(n < 0){
            result = result * (1/calcPower(x,-n));
        }
        return result;
    }

    private static int isPalUtil(int num, int dupNum) throws Exception {

        // base condition to return once we
        // move past first digit
        if (num == 0) {
            return dupNum;
        } else {
            System.out.println(num + " " + dupNum);
            dupNum = isPalUtil(num / 10, dupNum);
        }

        // Check for equality of first digit of
        // num and dupNum
        System.out.println(num + " " + dupNum);
        if (num % 10 == dupNum % 10) {
            // if first digit values of num and
            // dupNum are equal divide dupNum
            // value by 10 to keep moving in sync
            // with num.
            return dupNum / 10;
        } else {
            // At position values are not
            // matching throw exception and exit.
            // no need to proceed further.
            throw new Exception();
        }

    }

    public static void checkPalindromicNumber(){
        try{
            int val = 323;
            isPalUtil(val,val);
            System.out.println("Yes");
        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            int val = 121;
            isPalUtil(val,val);
            System.out.println("Yes");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
