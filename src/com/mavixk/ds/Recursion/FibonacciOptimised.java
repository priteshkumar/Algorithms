package com.mavixk.ds;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;
import java.math.BigInteger;
import java.math.BigDecimal;

class Solution {
    public static int fib(int N) {
        if (N <= 1) {
            return N;
        }
        int[][] A = new int[][]{{1, 1}, {1, 0}};
        matrixPower(A, N-1);

        return A[0][0];
    }

    static void matrixPower(int[][] A, int N) {
        if (N <= 1) {
            return;
        }
        matrixPower(A, N/2);
        multiply(A, A);

        int[][] B = new int[][]{{1, 1}, {1, 0}};
        if (N%2 != 0) {
            multiply(A, B);
        }
    }

    static void multiply(int[][] A, int[][] B) {
        int x = A[0][0] * B[0][0] + A[0][1] * B[1][0];
        int y = A[0][0] * B[0][1] + A[0][1] * B[1][1];
        int z = A[1][0] * B[0][0] + A[1][1] * B[1][0];
        int w = A[1][0] * B[0][1] + A[1][1] * B[1][1];

        A[0][0] = x;
        A[0][1] = y;
        A[1][0] = z;
        A[1][1] = w;
    }
}

public class FibonacciOptimised {
    static final BigDecimal SQRT_5 = BigDecimal.valueOf(Math.sqrt(5));
    static final BigDecimal GR = (BigDecimal.ONE.add(SQRT_5).divide(BigDecimal.valueOf(2)));
    static final BigDecimal NGR = GR.negate().add(BigDecimal.ONE);

    // Binet algorithm
    private static long fibGoldenRatio(int n) {

        if (n < 0) {
            return -1;
        }

        return BigDecimal.ONE.divide(SQRT_5).multiply((GR.pow(n).subtract(NGR.pow(n)))).toBigInteger().longValue();
    }

    public static void main(String[] args){
        // Java Program to find n'th fibonacci Number
        int n = 1;
        Scanner scan = new Scanner(System.in);
        double a = 10.4;
        BigDecimal d = BigDecimal.valueOf(11.0);
        BigDecimal e = new BigDecimal("2.1");
        d = d.divide(e,RoundingMode.HALF_UP);
        System.out.println(d);
        //System.out.println(Math.round(5.61));
        //System.out.println(Math.round(5.43));
        //System.out.println(Math.round(3.49999));
        //System.out.println(Math.round(3.5));
        //System.out.println(d.round(new MathContext(1, RoundingMode.HALF_UP)));
        System.out.println(d.setScale(0,RoundingMode.HALF_UP));

        while(n > 0) {
            n = scan.nextInt();
            if(n < 0)break;
             System.out.println(Solution.fib(n));
            //System.out.println(n + "th fibonacci number is : " + getFibonacci(n));
        }
    }

    public static BigDecimal getFibonacci(int n){
        double sq = Math.sqrt(5);
        double phi = (1 + Math.sqrt(5)) / 2;
        BigDecimal bd = BigDecimal.valueOf(phi);
        bd = bd.pow(n);
        bd = bd.divide(BigDecimal.valueOf(sq),2,RoundingMode.CEILING);
        System.out.println(bd);
        //System.out.println(Math.round(Math.pow(phi,n)/Math.sqrt(5)));
        bd.setScale(0,BigDecimal.ROUND_HALF_UP);
        System.out.println(bd.setScale(0,RoundingMode.FLOOR));
       // System.out.println(bd + " to bigint " + bd.toBigInteger());
        return bd.setScale(0,RoundingMode.HALF_UP);
    }
}

//67 : 44945570212853
//68 : 72723460248141
//69 : 117669030460994
//70 : 190392490709135
//100: 354224848179261915075
//101: fib 573147844013817084101
