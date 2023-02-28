package basic.class04;

public class Code02_ReverseNodesInKGroup {
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode getKGroupTail(ListNode node, int k) {
        ListNode cur = node;
        while (cur != null && --k > 0) {
            cur = cur.next;
        }
        return cur;
    }

    public static ListNode reverse(ListNode node, ListNode end) {
        ListNode prev = null;
        ListNode next = node;
        while (node != end) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode oldTail = getKGroupTail(head, k);
        if(oldTail == null) {
            return head;
        }

        // 暂存下一组
        ListNode nextGroup = oldTail.next;

        ListNode result = reverse(head, nextGroup);

        ListNode newHead = result;
        ListNode prevGroupTail = head;

        while(nextGroup != null) {
            head = nextGroup;
            oldTail = getKGroupTail(head, k);
            if(oldTail == null) {
                // 前一组尾节点指向当前组新头结点
                prevGroupTail.next = head;
                break;
            } else {
                // 暂存下一组第一个
                nextGroup = oldTail.next;
                newHead = reverse(head, nextGroup);
                // 前一组尾节点指向当前组新头结点
                prevGroupTail.next = newHead;
                // 新的尾节点就是原来的头结点
                prevGroupTail = head;
            }
        }

        return result;
    }
}
