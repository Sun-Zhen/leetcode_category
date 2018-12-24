/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * 输入: head = [1], x=0
 * 输出: [1]
 *
 * @author Alden
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode(0);
        ListNode current = head;
        ListNode leftNodeHead = new ListNode(0);
        ListNode leftNode = null;
        ListNode rightNodeHead = new ListNode(0);
        ListNode rightNode = null;
        while (current != null) {
            ListNode next = current.next;
            if (current.val < x) {
                if (leftNode == null) {
                    leftNode = current;
                    leftNodeHead.next = leftNode;
                } else {
                    leftNode.next = current;
                    leftNode = leftNode.next;
                }
            } else {
                if (rightNode == null) {
                    rightNode = current;
                    rightNodeHead.next = rightNode;
                } else {
                    rightNode.next = current;
                    rightNode = rightNode.next;
                }
            }
            current = next;
        }
        if (leftNode != null && rightNode != null) {
            res.next = leftNodeHead.next;
            leftNode.next = rightNodeHead.next;
            rightNode.next = null;
        } else if (leftNode != null) {
            res.next = leftNodeHead.next;
            leftNode.next = null;
        } else if (rightNode != null) {
            res.next = rightNodeHead.next;
            rightNode.next = null;
        }
        return res.next;
    }
}
