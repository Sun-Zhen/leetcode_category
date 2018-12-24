/**
 * @author Alden
 */
public class AddTwoNumbers {

    private static final int TAG = 10;

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean flag = false;
        ListNode head = l1;
        while (l1 != null) {
            if (l2 != null) {
                l1.val = flag ? l1.val + l2.val + 1 : l1.val + l2.val;
            } else {
                l1.val = flag ? l1.val + 1 : l1.val;
            }
            if (l1.val >= TAG) {
                flag = true;
                l1.val -= TAG;
            } else {
                flag = false;
            }
            if (l2 != null) {
                if (l1.next == null && l2.next != null) {
                    l1.next = l2.next;
                    l2 = null;
                } else {
                    l2 = l2.next;
                }
            }
            if (l1.next == null && flag && l2 == null) {
                l1.next = new ListNode(1);
                flag = false;
            }
            l1 = l1.next;
        }
        return head;
    }

    /**
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[] a1 = {2, 4, 3};
//        int[] a2 = {5, 6, 4};
//        int[] a1 = {5};
//        int[] a2 = {5};
        int[] a1 = {0};
        int[] a2 = {7, 3};
        ListNode l1 = ListNode.getNodes(a1);
        ListNode l2 = ListNode.getNodes(a2);
        l1.dumpNodes();
        l2.dumpNodes();
        AddTwoNumbers test = new AddTwoNumbers();
        ListNode result = test.addTwoNumbers(l1, l2);
        result.dumpNodes();
    }
}