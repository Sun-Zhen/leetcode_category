/**
 * @author Alden
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }

    static ListNode getNodes(int[] a) {
        if (a != null && a.length > 0) {
            ListNode[] l1 = new ListNode[a.length];
            for (int i = 0; i < a.length; i++) {
                l1[i] = new ListNode(a[i]);
                if (i > 0) {
                    l1[i - 1].next = l1[i];
                }
            }
            return l1[0];
        } else {
            return null;
        }
    }

    void dumpNodes() {
        StringBuilder sb = new StringBuilder();
        ListNode curr = this;
        while (curr != null) {
            sb.append(curr.val).append("\t");
            curr = curr.next;
        }
        System.out.println(sb.toString());
    }
}
