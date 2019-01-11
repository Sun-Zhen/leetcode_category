/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的深度拷贝。
 * 可以尝试cur.next.random = cur.random.next;
 *
 * @author Alden
 */
public class CopyListWithRandomPointer {
    private static final int DEFAULT_STEP = -1;

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode originHead = new RandomListNode(0);
        RandomListNode finalResult = new RandomListNode(0);

        originHead.next = head;
        RandomListNode current = head;
        RandomListNode last = finalResult;
        int len = 0;
        while (current != null) {
            len++;
            last.next = new RandomListNode(current.label);
            last = last.next;
            current = current.next;
        }
        RandomListNode[] oldNodes = new RandomListNode[len];
        RandomListNode[] newNodes = new RandomListNode[len];
        int[] stepRecords = new int[len];
        RandomListNode oldHead = head;
        RandomListNode newHead = finalResult.next;

        for (int i = 0; i < len; i++) {
            oldNodes[i] = oldHead;
            newNodes[i] = newHead;
            if (oldHead.random != null) {
                stepRecords[i] = len - getSteps(oldHead.random);
            } else {
                stepRecords[i] = DEFAULT_STEP;
            }
            oldHead = oldHead.next;
            newHead = newHead.next;
        }

        for (int i = 0; i < len; i++) {
            if (stepRecords[i] != DEFAULT_STEP) {
                newNodes[i].random = newNodes[stepRecords[i]];
            }
        }

        return finalResult.next;
    }

    private int getSteps(RandomListNode target) {
        int steps = 0;
        RandomListNode temp = target;
        while (temp != null) {
            steps++;
            temp = temp.next;
        }
        return steps;
    }
}
