import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * @author Alden
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        boolean hasCycle = false;
        Map<ListNode, Boolean> map = new HashMap<>();
        while (head != null) {
            if (map.getOrDefault(head, false)) {
                hasCycle = true;
                break;
            } else {
                map.put(head, true);
            }
            head = head.next;
        }
        return hasCycle;
    }
}
