package com.ak.mycode.leetcode;

import com.ak.mycode.tools.LinkedListUtil;

public class InsertionSortList extends LinkedListUtil {

    public static void main(String[] args) {
        Integer[] input = {1,3,4,2};
        ListNode head = addElements(input);
        System.out.println(printElements(new InsertionSortList().insertionSortList(head)));
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = head;
        ListNode i= head.next;
        ListNode next = i;
        newHead.next=null;
        while(i!=null) {
            if(newHead.val>i.val) {
                next = i.next;
                i.next = newHead;
                newHead = i;
            }
            else {
                ListNode sortedPrev = newHead;
                ListNode j=newHead.next;
                while(j!=null) {
                    if(j.val>i.val) {
                        break;
                    }
                    sortedPrev = j;
                    j=j.next;
                }
                next = i.next;
                i.next = j;
                sortedPrev.next = i;
            }
            i=next;
        }
        return newHead;
    }

}

//link - https://leetcode.com/problems/insertion-sort-list/

/*
Question : -
    Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.
    The steps of the insertion sort algorithm:
    Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
    At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
    It repeats until no input elements remain.
    The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially contains only the first element in the list. One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.
 */

/*
Example : -
    Input: head = [4,2,1,3]
    Output: [1,2,3,4]
 */

//level - medium

//algorithms used - insertion sort, linked list

//available in lists -

//Time Complexity - O(N^2) since we used insertion sort

//Space Complexity - O(1)