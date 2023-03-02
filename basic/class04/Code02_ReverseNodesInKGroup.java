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

    public static void reverse(ListNode start, ListNode end) {
        ListNode nextGroup = end != null ? end.next : null;

        ListNode prev = null;
        ListNode current = start;
        ListNode next;
        while (current != nextGroup) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        start.next = nextGroup;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = getKGroupTail(head, k);
        if(tail == null) {
            return head;
        }

        reverse(head, tail);
        ListNode result = tail;

        ListNode prev = head;
        while(prev.next != null) {
            head = prev.next;
            tail = getKGroupTail(head, k);
            if(tail == null) {
                break;
            } else {
                reverse(head, tail);
                prev.next = tail;
                prev = head;
            }
        }

        return result;
    }
}
