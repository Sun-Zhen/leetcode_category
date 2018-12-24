/**
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * @author Alden
 */
public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode current = head;
        ListNode last = res;
        boolean duplicate = false;
        while (current != null) {
            ListNode next = current.next;
            if (next != null) {
                if (current.val != next.val) {
                    if (duplicate) {
                        last.next = next;
                        current = next;
                        duplicate = false;
                    } else {
                        last = current;
                        current = next;
                    }
                } else {
                    duplicate = true;
                    current = current.next;
                }
            } else {
                if (duplicate) {
                    last.next = null;
                }
                current = null;
            }
        }
        return res.next;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 4, 4, 5};
        ListNode l1 = ListNode.getNodes(a);
        ListNode.dumpNodes(l1);
        RemoveDuplicatesFromSortedList2 test = new RemoveDuplicatesFromSortedList2();
        ListNode l2 = test.deleteDuplicates(l1);
        ListNode.dumpNodes(l2);
    }
}
