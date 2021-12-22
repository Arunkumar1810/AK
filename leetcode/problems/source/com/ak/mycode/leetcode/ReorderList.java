package com.ak.mycode.leetcode;

import com.ak.mycode.tools.LinkedListUtil;

public class ReorderList extends LinkedListUtil {

    public static void main(String[] args) {
        ListNode head = addElements(new Integer[]{1,2,3,4});
        new ReorderList().reorderList(head);
        System.out.println(printElements(head));
    }

    public void reorderList(ListNode head) {
        ListNode iterator = head;
        ListNode doubleIterator = head;
        ListNode parent = null;
        while(doubleIterator!=null) {
            parent = iterator;
            iterator = iterator.next;
            doubleIterator = doubleIterator.next;
            if(doubleIterator!=null) {
                doubleIterator = doubleIterator.next;
            }
        }
        if(parent!=null) parent.next = null;
        ListNode secondHead = iterator;

        ListNode headIterator = head;
        ListNode secondHeadIterator = secondHead;
        secondHead = null;

        while(secondHeadIterator!=null) {
            ListNode temp = secondHeadIterator.next;
            secondHeadIterator.next = secondHead;
            secondHead = secondHeadIterator;
            secondHeadIterator = temp;
        }
        secondHeadIterator = secondHead;

        while(headIterator!=null && secondHeadIterator!=null) {
            ListNode temp1 = secondHeadIterator.next;
            ListNode temp2 = headIterator.next;
            headIterator.next = secondHeadIterator;
            secondHeadIterator.next = temp2;
            headIterator = temp2;
            secondHeadIterator = temp1;
        }
    }
}

//link - https://leetcode.com/problems/reorder-list/

/*
Question : -
    You are given the head of a singly linked-list. The list can be represented as:
    L0 → L1 → … → Ln - 1 → Ln
    Reorder the list to be on the following form:
    L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
    You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 */

/*
Example : -
    Input: head = [1,2,3,4]
    Output: [1,4,2,3]
 */

//level - medium

//algorithms used - two pointers

//available in lists -

//Time Complexity - O(n)

//Space Complexity - O(1)
