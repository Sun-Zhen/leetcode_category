/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 注:
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @author Alden
 */
public class SwapNodesInPairs {
    ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode current = res.next;
        ListNode last = res;
        while (current != null && current.next != null) {
            ListNode next = current.next;
            ListNode temp = next.next;
            current.next = temp;
            next.next = current;
            last.next = next;

            last = current;
            current = temp;
        }
        return res.next;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        ListNode l1 = ListNode.getNodes(a);
        l1.dumpNodes();
        SwapNodesInPairs test = new SwapNodesInPairs();
        ListNode l2 = test.swapPairs(l1);
        l2.dumpNodes();
    }
}
