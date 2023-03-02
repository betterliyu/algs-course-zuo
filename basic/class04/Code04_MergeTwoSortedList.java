package basic.class04;

public class Code04_MergeTwoSortedList {
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode current = null;
        if (list1.val > list2.val) {
            current = list2;
            list2 = list2.next;
        } else {
            current = list1;
            list1 = list1.next;
        }

        ListNode head = current;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                current.next = list2;
                list2 = list2.next;
            } else {
                current.next = list1;
                list1 = list1.next;
            }
            current = current.next;
        }

        current.next = list1 == null ? list2 : list1;

        return head;
    }
}
