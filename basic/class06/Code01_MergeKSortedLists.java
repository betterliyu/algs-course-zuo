package basic.class06;


import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Code01_MergeKSortedLists {
    public static class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> listNodeQueue = new PriorityQueue<>(new ListNodeComparator());
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                listNodeQueue.add(lists[i]);
            }
        }

        ListNode head = listNodeQueue.poll();

        if (head == null) {
            return null;
        }

        ListNode current = head;

        if (current.next != null) {
            listNodeQueue.add(current.next);
        }

        while (!listNodeQueue.isEmpty()) {
            current.next = listNodeQueue.poll();
            current = current.next;

            if (current.next != null) {
                listNodeQueue.add(current.next);
            }
        }
        return head;
    }

}
