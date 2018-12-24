import utils.ListNode;

/**
 * 示例1
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例2
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * @author Alden
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        final ListNode res = new ListNode(0);
        res.next = head;
        ListNode current = head;
        ListNode last = res;
        int len = 0;
        while (current != null) {
            current = current.next;
            last = last.next;
            len++;
        }
        last.next = head;
        if (len != 0) {
            k %= len;
        } else {
            k = 0;
        }
        int i = 0;
        current = head;
        while (i < len - k) {
            last = last.next;
            current = current.next;
            i++;
        }
        last.next = null;
        res.next = current;
        return res.next;
    }

    public static void main(String[] args) {
//        int[] a = {1, 2, 3, 4, 5};
//        int[] a = {0, 1, 2};
        int[] a = {};
        ListNode l1 = ListNode.getNodes(a);
        ListNode.dumpNodes(l1);
        RotateList test = new RotateList();
        ListNode l2 = test.rotateRight(l1, 0);
        ListNode.dumpNodes(l2);
    }
}
