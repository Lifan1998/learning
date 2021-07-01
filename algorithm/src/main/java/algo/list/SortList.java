package algo.list;

/**
 * @author fan.li
 * @date 2021-06-29
 * @description
 */

public class SortList {

    public static void main(String[] args) {
    }


    /**
     * 注意找中间坐标
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        // 找到中间节点
        while (fast != null) {
            slow = slow.next;

            if (fast.next == null) {
                fast = fast.next;
            }
            fast = fast.next.next;
        }
        // 切割成两个链表，一个以头结点，一个是slow节点
        ListNode start = slow.next;
        slow.next = null;
        // 排序前面的链表
        ListNode left = sortList(head);
        // 排序后面的链表
        ListNode right = sortList(start);
        // 合并两个有序链表
        return merge(left, right);
    }

    // merge 两个有序链表
    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode head = new ListNode();
        ListNode temp = head;
        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                temp.next = node2;
                node2 = node2.next;
            } else {
                temp.next = node1;
                node1 = node1.next;
            }
        }
        if (node1 != null) {
            temp.next = node1;
        }
        if (node2 != null) {
            temp.next = node2;
        }
        return head.next;
    }
}

