import utils.ListNode;

/**
 * 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @author Alden
 */
public class ReverseNodesInkGroup {
    public ListNode reverseKGroup(ListNode head, final int k) {
        ListNode[] la = new ListNode[k];
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode current = head;
        ListNode last = res;
        int i = 0;
        while (current != null) {
            if (i == k) {
                for (; i > 0; i--) {
                    last.next = la[i - 1];
                    last = last.next;
                }
                last.next = current;
            }
            la[i++] = current;
            current = current.next;
        }
        if (i == k) {
            for (; i > 0; i--) {
                last.next = la[i - 1];
                last = last.next;
            }
            last.next = null;
        }
        return res.next;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
//        int[] a = {2, 1};
        ListNode l1 = ListNode.getNodes(a);
        ReverseNodesInkGroup test = new ReverseNodesInkGroup();
        ListNode.dumpNodes(l1);
        ListNode l2 = test.reverseKGroup(l1, 2);
        ListNode.dumpNodes(l2);
    }
}
