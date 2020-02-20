package com.mavixk.ds.Search;
import java.util.*;
import java.lang.Math;

public class FindModuloPower {

  public static void main(String[] args){
    System.out.println(modularExponentiation(71045970,41535484,64735492));
    System.out.println(modularExponentiation(2,5,5));
    System.out.println(modularExponentiation(2,10,5));
    System.out.println(exponentMod(71045970,41535484,64735492));
    System.out.println(exponentMod(-1,1,20));
  }

  public static int modularExponentiation(int x,int n,int M)
  {

    if(n==0)
      return 1;
    else if(n%2 == 0)        //n is even
      return modularExponentiation(((x%M)*(x%M))%M,n/2,M);
    else                             //n is odd
      return (x*modularExponentiation(((x%M)*(x%M))%M,(n-1)/2,M))%M;

  }

  /**
   * caculcate power modulo n
   * @param A
   * @param B
   * @param C
   * @return
   */
  public static int exponentMod(int A,
      int B, int C)
  {

    // Base cases
    if (A == 0)
      return 0;
    if (B == 0)
      return 1;

    // If B is even
    long y;
    if (B % 2 == 0)
    {
      y = exponentMod(A, B / 2, C);
      y = (y * y) % C;
    }

    // If B is odd
    else
    {
      y = A % C;
      y = (y * exponentMod(A, B - 1,
          C) % C) % C;
    }

    return (int)((y + C) % C);
  }

}
