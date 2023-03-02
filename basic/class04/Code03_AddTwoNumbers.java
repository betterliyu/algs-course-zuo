package basic.class04;

public class Code03_AddTwoNumbers {
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        }

        ListNode longNode = getLength(node1) > getLength(node2) ? node1 : node2;
        node1 = longNode == node1 ? node2 : node1;

        ListNode result = longNode;
        int overflow = 0;

        while (longNode != null) {
            int v1 = longNode.val;
            int v2 = node1 == null ? 0 : node1.val;

            int sum = v1 + v2 + overflow;
            longNode.val = sum % 10;
            overflow = sum / 10;

            // 最后一个节点且没有溢出
            if (longNode.next == null) {
                if (overflow != 0) {
                    longNode.next = new ListNode();
                    longNode.next.val = overflow;
                }
                return result;
            }
            longNode = longNode.next;
            node1 = node1 == null ? null : node1.next;
        }

        return null;
    }


}
