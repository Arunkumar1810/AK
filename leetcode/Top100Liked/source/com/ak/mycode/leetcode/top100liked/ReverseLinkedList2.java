package com.ak.mycode.leetcode.top100liked;

//https://leetcode.com/problems/reverse-linked-list-ii/
public class ReverseLinkedList2 {
    public static void main(String[] args) {
        ListNode listNode = new ReverseLinkedList2().addToLinkedList(new int[]{1,2,3,4,5,6,7,8,9});
        listNode = new ReverseLinkedList2().reverseBetween(listNode,3,3);
        System.out.println("Result : ");
        while (listNode!=null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null || right==left) return head;
        ListNode result = head;
        int i=1;
        for (; i < left-1; i++) {
            head = head.next;
        }
        ListNode leftHead = null;
        if(left!=1) {
            leftHead = head;
            head = head.next;
        }
        i=left;
        ListNode rightHead = head;

        ListNode newHead = null;
        while (head!=null && i++<=right) {
            ListNode temp = head;
            head = head.next;
            temp.next = newHead;
            newHead = temp;
        }
        if(rightHead!=null) rightHead.next = head;
        if(left != 0 && leftHead!=null) leftHead.next = newHead;
        else result = newHead;
        return result;
    }


    private ListNode addToLinkedList(int[] ints) {
        ListNode head = null;
        ListNode tmp = null;
        for (int i : ints) {
            if(head==null) {
                head = new ListNode(i);
                tmp = head;
            }
            else {
                tmp.next = new ListNode(i);
                tmp = tmp.next;
            }
        }
        return head;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
