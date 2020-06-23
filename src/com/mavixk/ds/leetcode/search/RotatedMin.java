package mavixk.ds.leetcode.search;

public class RotatedMin {
  public static int findMin(int[] a) {
    int l = 0;
    int r = a.length -1;
    int mid = 0;
    int n = a.length;
    while(l <= r){
      if(a[l] <= a[r])return a[l];

      mid = l + (r -l)/2;
      int next = (mid + 1) % n;
      int prev = (mid -1 + n) % n;
      if(a[mid] <= a[prev] && a[mid] <= a[next])
        return a[mid];
      else if(a[mid] <= a[r])
        r = mid -1;
      else if(a[mid] >= a[l])
        l = mid + 1;
    }

    return -1;
  }

  public static void main(String[] args){
    System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
  }
}
