package com.mavixk.ds;
import java.util.*;
import java.lang.Math;

public class SieveOfEratothenes {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        genSieveOfEratothenes(17);

    }

    public static void genSieveOfEratothenes(int n){
        boolean[] primes  = new boolean[n+1];
        for(int i=0;i < primes.length;i++){
            primes[i] = true;
        }
        for(int i=2;i*i <= n;i++){
            if(primes[i] == true){
                for(int j=i*i;j<=n;j = j + i){
                    primes[j] = false;
                }
            }
        }
        for(int i=2;i <=n;i++){
            if(primes[i] == true)System.out.print(i + " ");
        }
    }
}
