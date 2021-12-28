package com.ak.mycode.leetcode;

import com.ak.mycode.tools.LinkedListUtil;

public class MiddleOfTheLinkedList extends LinkedListUtil {

    public static void main(String[] args) {
        ListNode head = addElements(new Integer[]{1,2,3,4,5,6});
        MiddleOfTheLinkedList obj = new MiddleOfTheLinkedList();
        System.out.println(obj.middleNode(head).val);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null) {
            fast = fast.next;
            if(fast!=null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }
}

//link - https://leetcode.com/problems/middle-of-the-linked-list/

/*
Question : -
    Given the head of a singly linked list, return the middle node of the linked list.
    If there are two middle nodes, return the second middle node.
 */

/*
Example : -
    Input: head = [1,2,3,4,5]
    Output: [3,4,5]
    Explanation: The middle node of the list is node 3.
 */

//level - easy

//algorithms used - two pointer

//available in lists -

//Time Complexity - O(n)

//Space Complexity - O(1)