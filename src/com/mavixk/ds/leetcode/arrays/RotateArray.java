package mavixk.ds.leetcode.search;

public class RotateArray {

  public static void main(String[] args) {
    int[] a = new int[]{1,2,3,4,5,6,7};
    rotate(a,22);
  }

  /**
   * rotate right by k
   * <p>demo expected output : {5,6,7,1,2,3,4}
   * @param a
   * @param k
   */
  public static void rotate(int[] a, int k) {
    int[] b = new int[a.length];
    int n = a.length;
    for (int i = 0; i < b.length; i++) {
      b[(i + (k % n)) % n] = a[i];
    }

    for(int i=0; i < b.length;i++)
      System.out.print(b[i] + " ");
    System.out.println();
  }
}