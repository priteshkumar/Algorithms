package mavixk.ds.leetcode.lists;

class Node {

  int data;
  Node next;
}

public class LastNthNode {

  static Node headNode = null;

  public static void main(String[] args) {
    buildList();
    System.out.println(lastNthNode(2));
  }

  public static void buildList() {
    int[] a = {5,2,1,3,4,6};
    //todo later
  }

  static int lastNthNode(int n) {
    if (headNode == null || (headNode.next == null && n > 1)) {
      return -1;
    }
    if (headNode.next == null && n == 1) {
      return headNode.data;
    }

    Node fast = headNode;
    Node slow = headNode;
    // 5 2 1 3 4 6
    int i = 1;
    while (i <= n - 1 && fast != null) {
      fast = fast.next;
      i++;
    }
    if (fast == null) {
      return -1;
    }

    while (fast != null) {
      fast = fast.next;
      if (fast != null) {
        slow = slow.next;
      }
    }
    return slow.data;
  }
}
