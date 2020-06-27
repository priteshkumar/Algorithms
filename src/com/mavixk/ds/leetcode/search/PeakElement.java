package mavixk.ds.leetcode.search;

public class PeakElement {
  public static void main(String[] args){
    int[] a = {1,1,3,2};
    System.out.println(findPeakElement(a));
  }

  /**
   * finds peak element :
   *  if l < i < r :  a[i] > a[i-1] && a[i] > a[i+1] => i
   *  if l == 0 && i == l + 1 : a[l] > a[i] => l
   *  if r == a.length && i == r -1 && a[i-1] < a[i] => i
    * @param a
   * @return
   */
  public static int findPeakElement(int[] a) {
    if (a.length == 1) {
      return 0;
    }
    return peak(a, 0, a.length);
  }

  public static int peak(int[] a, int l, int r) {
    if (l + 1 >= r) {
      return -1;
    }
    int mid = l + (r - l) / 2;
    if (l == 0 && mid == l + 1 && a[l] > a[mid]) {
      return l;
    } else if (r == a.length && mid == r - 1 && a[mid - 1] < a[mid]) {
      return mid;
    } else if (mid != 0 && mid != a.length - 1 && a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) {
      return mid;
    }
    int lpeak = peak(a, l, mid);
    if (lpeak >= 0) {
      return lpeak;
    }
    int rpeak = peak(a, mid, r);
    if (rpeak >= 0) {
      return rpeak;
    }
    return -1;
  }
}
