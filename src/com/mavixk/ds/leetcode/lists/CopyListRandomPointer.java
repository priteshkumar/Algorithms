package mavixk.ds.leetcode.lists;

import java.util.LinkedHashMap;

public class CopyListRandomPointer {

  static class Node {
    int data;
    Node next;
    Node random;
    public Node(int val){this.data = val;}
  }

  /**
   * Copies a list using random pointers
   * leetcode list problem @link{https://leetcode.com/problems/copy-list-with-random-pointer/}
   * @param head
   * @return
   */
  public static Node copyRandomList(Node head) {
    LinkedHashMap<Node, Integer> m = new LinkedHashMap<Node, Integer>();
    LinkedHashMap<Integer, Node> n = new LinkedHashMap<Integer, Node>();
    Node temp = head;
    int i = 0;
    Node cur = null;
    Node p = null;
    Node q = null;
    while (temp != null) {
      cur = new Node(temp.data);
      m.put(temp, i);
      n.put(i, cur);
      if (p == null) {
        p = cur;
        q = p;
      } else {
        q.next = cur;
        q = cur;
      }
      temp = temp.next;
      i++;
    }

    temp = head;
    cur = p;
    while (temp != null && cur != null) {
      Node r = temp.random;
      if (r == null) {
        cur.random = null;
      } else {
        int k = m.get(r);
        cur.random = n.get(k);

      }
      temp = temp.next;
      cur = cur.next;

    }
    return p;
  }
}
