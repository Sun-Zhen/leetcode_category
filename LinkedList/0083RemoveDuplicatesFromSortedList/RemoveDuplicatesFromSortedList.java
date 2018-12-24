/**
 * 例子1
 * 输入: 1->1->2
 * 输出: 1->2
 * 例子2
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * @author Alden
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            if (next != null) {
                if (next.val == current.val) {
                    current.next = next.next;
                } else {
                    current = current.next;
                }
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
