package com.ak.mycode.tools;

public class LinkedListUtil {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addElements(Integer[] input) {
        if(input==null || input.length==0) return null;
        ListNode head = new ListNode(input[0]);
        ListNode iterator = head;
        for (int i=1;i<input.length;i++) {
            iterator.next = new ListNode(input[i]);
            iterator = iterator.next;
        }
        return head;
    }

    public static String printElements(ListNode node) {
        StringBuilder output = new StringBuilder();
        while (node!=null) {
            output.append(node.val);
            node=node.next;
            if(node!=null) output.append("  -->  ");
        }
        return output.toString();
    }
}
