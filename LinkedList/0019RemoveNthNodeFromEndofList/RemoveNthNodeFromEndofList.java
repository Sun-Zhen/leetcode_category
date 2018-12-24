import utils.ListNode;

/**
 * @author Alden
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode temp = res;
        int step = 1;
        while (head.next != null) {
            if (step == n) {
                temp = temp.next;
            } else {
                step += 1;
            }
            head = head.next;
        }
        temp.next = temp.next.next;
        return res.next;
    }
}