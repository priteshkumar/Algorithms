package com.mavixk.ds;
import java.util.*;

public class PowerDemo {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(calcPower(n,4));
        System.out.println(calcPower(n,5));
        System.out.println(calcPowerOptimised(n,4));
        System.out.println(calcPowerOptimised(n,5));
    }

    public static long calcPower(int n,int p){
        long result=1;
        if(p == 0)return 1;
        else if (p % 2 == 0){
            result = result * calcPower(n,p/2);
            result *= result;
        }
        else if (p % 2 != 0){
            result = result * n;
            result = result * calcPower(n,p-1);
        }
        return result;
    }

    public static long calcPowerOptimised(int n,int p){
        long result;
        if(p == 0)return 1;
        result = calcPowerOptimised(n,p/2);
        if(p % 2 == 0)result = result * result;
        else if(p % 2 != 0){
            result = n * result * result;
        }
        return result;
    }
}
