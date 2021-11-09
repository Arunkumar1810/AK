package com.ak.mycode.leetcode;

//https://leetcode.com/explore/learn/card/linked-list/209/singly-linked-list/1290/

//tutorial

//liked list

//

//tutorial

public class DesignLinkedList {

    class MyLinkedList {

        private class LinkedListNode {
            int val;
            LinkedListNode next;

            LinkedListNode(int val) {
                this.val = val;
                this.next = null;
            }
        }

        LinkedListNode head = null;

        public MyLinkedList() {
        }

        public int get(int index) {
            LinkedListNode iterator = head;
            while (iterator!=null && index!=-1) {
                iterator = iterator.next;
                index--;
            }
            if(index == -1&& iterator!=null) return iterator.val;
            else return -1;
        }

        public void addAtHead(int val) {
            LinkedListNode newHead = new LinkedListNode(val);
            newHead.next = head;
            head = newHead;
        }

        public void addAtTail(int val) {
            if(head == null) head=new LinkedListNode(val);
            else {
                LinkedListNode iterator = head;
                while (iterator.next!=null) {
                    iterator = iterator.next;
                }
                iterator.next = new LinkedListNode(val);
            }
        }

        public void addAtIndex(int index, int val) {
            LinkedListNode iterator = head;
            while (index<=0) {

            }
            //iterator.next = new LinkedListNode();
        }

        public void deleteAtIndex(int index) {

        }
    }

}
