package mavixk.ds.leetcode.arrays;

public class RemoveDuplicates {

  public static void main(String[] args) {
    int a[] = new int[]{1, 1, 1, 2, 2, 2, 3};
    System.out.println(removeDuplicates(a));
  }

  /**
   * removes duplicates inplace
   * at most 2 occurences of each element are allowed
   * @param a input array
   * @return length of modified array
   */
  public static int removeDuplicates(int[] a) {
    int i = 0;
    int n = a.length;
    int cur = -1;
    int k = 0;
    int len = 0;
    while (i < n) {
      if (i == 0) {
        k = 1;
        len = 1;
        cur = 1;
      } else if (a[i] == a[i - 1]) {
        if (k < 2) {
          len++;
          if (cur != -1) {
            a[cur] = a[i];
            cur = cur + 1;
          }
        }
        k++;
      } else if (a[i] != a[i - 1]) {
        if (cur != -1) {
          a[cur] = a[i];
          cur = cur + 1;
          k = 1;
        }
        len++;
      }
      i++;
    }
    return len;
  }
}

