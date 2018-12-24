/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * @author Alden
 */
public class ReverseLinkedList2 {
    ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode res = new ListNode(0);
        res.next = head;
        int i = 1;
        ListNode last = res;
        ListNode start = new ListNode(0);
        ListNode reverseNode = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current;
            current = current.next;
            if (i < m) {
                last = last.next;
            }
            if (i == m) {
                start.next = temp;
                reverseNode = temp;
                reverseNode.next = null;
            }
            if (i > m && i <= n) {
                last.next = temp;
                temp.next = start.next;
                start.next = temp;
            }
            if (i == n) {
                reverseNode.next = current;
            }
            i++;
        }
        return res.next;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        ListNode l1 = ListNode.getNodes(a);
        l1.dumpNodes();
        ReverseLinkedList2 test = new ReverseLinkedList2();
        ListNode l2 = test.reverseBetween(l1, 2, 4);
        l2.dumpNodes();
    }
}
