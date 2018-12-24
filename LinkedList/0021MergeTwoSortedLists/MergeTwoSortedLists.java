import utils.ListNode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author Alden
 */
public class MergeTwoSortedLists {
    public utils.ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode temp = res;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                int min;
                if (l1.val <= l2.val) {
                    min = l1.val;
                    l1 = l1.next;
                } else {
                    min = l2.val;
                    l2 = l2.next;
                }
                temp.next = new ListNode(min);
            } else if (l1 != null) {
                temp.next = l1;
                break;
            } else {
                temp.next = l2;
                break;
            }
            temp = temp.next;
        }
        return res.next;
    }
}
