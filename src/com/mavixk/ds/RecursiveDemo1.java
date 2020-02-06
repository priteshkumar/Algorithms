package com.mavixk.ds;
import java.util.concurrent.ThreadLocalRandom;

public class RecursiveDemo1 {
    public static void main(String[] args){
        System.out.println(isPalindrome(("abba")));
        //System.out.println(isPalindrome("malam"));
        System.out.println(isPalindrome("latam"));
        System.out.println(getLen("devops"));
        printReversedString("helloworld");
        System.out.println();
        printReversedString("this is a book");
        System.out.println();
        System.out.println(getSumofDigits(324));
        System.out.println(getSumofDigits(93324));
        System.out.println(isSubsequence("hac","cathartic"));
        System.out.println(isSubsequence("bat","table"));
        System.out.println(isSubsequence("bat","tabcbtad"));
        int[] a = {1,2,3,4};
        //printSubsets(a);
        genFibonacci(100);
       // System.out.println(genFibonacciv2(100));
        printPattern(3);
    }

    public static boolean isPalindrome(String s){
        if(s.length() == 0 || s.length() == 1)return true;
        if(s.charAt(s.length()-1) != s.charAt(0))return false;
        else return isPalindrome(s.substring(1,s.length()-1));
    }

    /**
     * recursive function to get length of string param
     * @param s String parameter whose length needs to be calculated
     * @return length of String params
     */
    public static int getLen(String s){
        if(s.length() == 0)return 0;
        else return 1 + getLen(s.substring(1));
    }

    public static void printReversedString(String s){
        if(s.length() == 0)return;
        printReversedString(s.substring(1));
        System.out.print(s.charAt(0) + "");
    }

    public static int getSumofDigits(int n){
        if(n == 0)return 0;
        return ((n % 10) + getSumofDigits(n/10));
    }

    public static boolean isSubsequence(String a,String b){
       // System.out.println(a + " " + b);
        if(a.length() == 0)return true;
        if(a.length() > 0 && b.length() == 0)return false;
        int index = b.indexOf(a.charAt(0));
        //System.out.println(index + " ");
        return (index >= 0 && isSubsequence(a.substring(1),b.substring(index+1)));

    }

    public static void printSubsets(int[] a){
        int n = a.length;
        for(int i=0;i < (1<<n);i++){
            System.out.print("{ ");
            for(int j=0;j < n;j++){
                if((i & (1<<j)) > 0){
                    System.out.print(a[j] + " ");
                }
            }
            System.out.println("}");
        }
    }
    //{1,2,3}
    public static void printSubsetRecursive(int[] a){

    }

    public static void genFibonacci(int n){
        long[] seq = new long[n+1];
        seq[0] = 0;
        seq[1] = 1;
        for(int i=2;i<=n;i++){
            seq[i] = (seq[i-1] + seq[i-2])%10;
        }
        System.out.println(seq[n]);
    }

    public static int genFibonacciv2(int n){
        if(n == 0 || n == 1)return n;
        else return (genFibonacciv2(n-1) + genFibonacciv2(n-2))%10;
    }

    public static String printPattern(int n){
        String pattern = "";
        if(n == 1){
            pattern = "*";
            System.out.println(pattern);
        }
        else{
            pattern = "*" + printPattern(n-1);
            System.out.println(pattern);
        }
        return pattern;
    }
}
