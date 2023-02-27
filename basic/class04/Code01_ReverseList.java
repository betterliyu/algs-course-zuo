package basic.class04;

import java.util.ArrayList;
import java.util.List;

public class Code01_ReverseList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            value = data;
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            value = data;
        }
    }


    public static Node getRandomLinkedList(int maxLength, int maxValue) {
        int size = (int) (Math.random() * (maxLength + 1));
        if (size == 0) {
            return null;
        }
        Node head = new Node((int) (Math.random() * (maxValue + 1)));
        Node prev = head;
        size--;
        while (size > 0) {
            Node cur = new Node((int) (Math.random() * (maxValue + 1)));
            prev.next = cur;
            prev = cur;
            size--;
        }

        return head;
    }

    public static DoubleNode getRandomDoubleList(int maxLength, int maxValue) {
        int size = (int) (Math.random() * (maxLength + 1));
        if (size == 0) {
            return null;
        }
        DoubleNode head = new DoubleNode((int) (Math.random() * (maxValue + 1)));
        head.last = null;
        DoubleNode prev = head;
        size--;
        while (size > 0) {
            DoubleNode cur = new DoubleNode((int) (Math.random() * (maxValue + 1)));
            cur.last = prev;
            prev.next = cur;
            prev = cur;
            size--;
        }

        return head;
    }


    public static List<Integer> getLinkListOriginOrder(Node head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.value);
            head = head.next;
        }
        return list;
    }

    public static List<Integer> getLinkListOriginOrder(DoubleNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.value);
            head = head.next;
        }
        return list;
    }


    public static boolean checkReverseLinkedList(List<Integer> list, Node head) {
        int N = list.size();
        int index = N - 1;
        while (head != null && index >= 0) {
            Integer val = list.get(index);
            if (!val.equals(head.value)) {
                return false;
            }
            index--;
            head = head.next;
        }
        return head == null && index == -1;
    }


    public static boolean checkReverseDoubleList(List<Integer> origin, DoubleNode head) {
        DoubleNode end = null;
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            end = head;
            head = head.next;
        }
        for (int i = 0; i < origin.size(); i++) {
            if (!origin.get(i).equals(end.value)) {
                return false;
            }
            end = end.last;
        }
        return true;
    }

    public static Node reverseList(Node head) {
        Node prev = null;
        Node next = head;
        while (next != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode prev = null;
        DoubleNode cur = head;
        while (cur != null) {
            cur.last = cur.next;
            cur.next = prev;
            prev = cur;
            cur = cur.last;
        }

        return prev;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 40; i++) {
            Node node = getRandomLinkedList(20, 20);
            List<Integer> originList = getLinkListOriginOrder(node);
            Node reversed = reverseList(node);
            if (!checkReverseLinkedList(originList, reversed)) {
                System.out.println("Oops!");
                break;
            }
        }
        System.out.println("测试结束");

        for (int i = 0; i < 40; i++) {
            DoubleNode node = getRandomDoubleList(20, 20);
            List<Integer> originList = getLinkListOriginOrder(node);
            DoubleNode reversed = reverseDoubleList(node);
            if (!checkReverseDoubleList(originList, reversed)) {
                System.out.println("Oops!");
                break;
            }
        }
        System.out.println("测试结束");
    }

}
