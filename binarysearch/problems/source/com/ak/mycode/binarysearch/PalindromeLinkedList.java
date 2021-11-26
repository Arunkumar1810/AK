package com.ak.mycode.binarysearch;

//https://binarysearch.com/problems/Palindrome-Linked-List

//Medium

//Two Pointer

//Time Complexity - O(n)

//Space Complexity - O(1)

//Your code took 100 milliseconds — faster than 70.51% in Java

//Reversed linked list until middle and iterate both pointers to check palindrome

public class PalindromeLinkedList {

    public static void main(String[] args) {
        int[] input = new int[]{5,3,1,3,5};
        LLNode head = new LLNode();
        LLNode iter = head;
        for (int i=0;i<input.length;i++) {
            iter.val = input[i];
            iter.next = i==input.length-1?null:new LLNode();
            iter = iter.next;
        }

        System.out.println(new PalindromeLinkedList().solve(head));
    }
    public boolean solve(LLNode node) {
        LLNode pointerFromMidToStart = null;
        LLNode pointerFromMidToEnd = node;
        LLNode endPointer = node;
        while (endPointer!=null && endPointer.next!=null) {
            endPointer = endPointer.next.next;
            LLNode temp = pointerFromMidToStart;
            pointerFromMidToStart = pointerFromMidToEnd;
            pointerFromMidToEnd = pointerFromMidToEnd.next;
            pointerFromMidToStart.next = temp;
        }

        if(endPointer != null) {
            pointerFromMidToEnd = pointerFromMidToEnd.next;
        }

        while (pointerFromMidToEnd!=null && pointerFromMidToStart!=null) {
            if(pointerFromMidToEnd.val!=pointerFromMidToStart.val) return false;
            pointerFromMidToEnd = pointerFromMidToEnd.next;
            pointerFromMidToStart = pointerFromMidToStart.next;
        }

        return true;
    }

    private static class LLNode {
        int val;
        LLNode next;
    }
}
