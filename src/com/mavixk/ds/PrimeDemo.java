package com.mavixk.ds;
import java.util.*;
import java.lang.Math;

public class PrimeDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 /*       int n = scan.nextInt();
        for (int i = 2; i <= n; i++) {
            boolean flag = checkPrime(i);
            if (flag == true) System.out.println(i);
        }*/
        genPrimes(20);
    }

    public static boolean checkPrime(int n) {
        if (n == 2) return true;

        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void genPrimes(int n) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 2; i <= n; i++) {
            list.add(i);
        }

        int p = 0;
        while (true) {

            ListIterator iter = list.listIterator();
            if (p == 0) p = 2;
            else {
                int nextp = p;
                while (iter.hasNext()) {
                    nextp = (int)iter.next();
                    if(nextp > p)break;
                }
                if(nextp == p)break;
                p = nextp;
            }
            while (iter.hasNext()) {
                int val = (int) iter.next();
                if ((val != p) && (val % p == 0)) {
                    iter.remove();
                }
            }
        }

      //  System.out.println("out of while loop");
        for(Integer prime:list){
            System.out.print(prime + " ");
        }
        System.out.println();
    }
}
