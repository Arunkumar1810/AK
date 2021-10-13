package com.ak.mycode.top100liked;

//https://leetcode.com/problems/reverse-linked-list
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode listNode = new ReverseLinkedList().addToLinkedList(new int[]{1,2,3,4,5});
        listNode = new ReverseLinkedList().reverseList(listNode);
        System.out.println("Result : ");
        while (listNode!=null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head!=null) {
            ListNode temp = head;
            head = head.next;
            temp.next = newHead;
            newHead = temp;
        }
        return newHead;
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
