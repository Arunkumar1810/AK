package com.ak.mycode.leetcode;

import com.ak.mycode.tools.LinkedListUtil;

public class AddTwoNumbers extends LinkedListUtil {

    public static void main(String[] args) {

        Integer[] l1= {9,9,9,9,9,9,9},
                l2 = {9,9,9,9};

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode result = addTwoNumbers.addTwoNumbers(addElements(l1),addElements(l2));

        System.out.println("Result : ");
        while(result!=null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        if(l1==null) {
            l1=l2;
            l2=null;
        }
        ListNode result = l1;
        ListNode l1Parent = null;
        while(l1!=null && l2!=null) {
            int res = l1.val + l2.val + carry;
            l1.val = res%10;
            carry = res/10;
            l1Parent = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l2!=null) {
            l1Parent.next = l2;
            l1=l2;
        }

        while (l1!=null) {
            if(carry==0) return result;
            int res = l1.val + carry;
            l1.val = res%10;
            carry = res/10;
            l1Parent = l1;
            l1 = l1.next;
        }

        if(carry>0) {
            l1Parent.next = new ListNode(carry);
        }

        return result;
    }
}

//link - https://leetcode.com/problems/add-two-numbers/

/*
Question : -
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

/*
Example : -
    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.
 */

//level - medium

//algorithms used -

//available in lists - amazon-questions

//Time Complexity - O(n)

//Space Complexity - O(1)