package mavixk.ds.leetcode.arrays;

public class Find2ndlargest {

  public static void main(String[] args) {
    int[] a = {3, 4, 4,5, 5, 1, 6, 6};
    System.out.println(getSecondlargest(a));
    System.out.println(getThirdlargest(a));
    int[] b = new int[]{3,2,3,3};
    System.out.println(getSecondlargest(b));
    System.out.println(getThirdlargest(b));
    int[] c = new int[]{7,7,7};
    System.out.println(getSecondlargest(c));
    System.out.println(getThirdlargest(c));
  }

  /**
   * Finds 2nd largest element
   * @param a
   * @return
   */
   public static int getSecondlargest(int[] a) {
    int first = Integer.MIN_VALUE;
    int sec = Integer.MIN_VALUE;
    for (int i = 0; i < a.length; i++) {
      if (a[i] > first) {
        sec = first;
        first = a[i];
      } else if (a[i] > sec && a[i] != first) {
        sec = a[i];
      }
    }
    if(sec == Integer.MIN_VALUE)
      System.out.println("2nd largets element doesnt exist");
    return sec;
  }

  /**
   * Finds 3rd largest tracking first/sec/third largest
   * ensures correct result in case of duplicate elements
   * @param a input array
   * @return 3rd largest element
   */
  public static int getThirdlargest(int[] a) {
    int first = Integer.MIN_VALUE;
    int sec = Integer.MIN_VALUE;
    int third = Integer.MIN_VALUE;
    for (int i = 0; i < a.length; i++) {
      if (a[i] > first) {
        third = sec;
        sec = first;
        first = a[i];
      } else if (a[i] > sec && a[i] != first) {
        third = sec;
        sec = a[i];
      } else if (a[i] > third && a[i] != first && a[i] != sec) {
        third = a[i];
      }
    }
    if(third == Integer.MIN_VALUE)
      System.out.println("3rd largets element doesnt exist");
    return third;
  }
}
