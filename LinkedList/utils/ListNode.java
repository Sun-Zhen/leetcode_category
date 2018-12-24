/**
 * @author Alden
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode getNodes(int[] a) {
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

    public static void dumpNodes(ListNode l) {
        StringBuilder sb = new StringBuilder();
        while (l != null) {
            sb.append(l.val).append("\t");
            l = l.next;
        }
        System.out.println(sb.toString());
    }
}
