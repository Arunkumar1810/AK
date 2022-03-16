package com.ak.mycode.leetcode;

import com.ak.mycode.tools.LinkedListUtil;

public class ConvertBinaryNumberInALinkedListToInteger {

    public static void main(String[] args) {
        System.out.println(new Solution().getDecimalValue(
                LinkedListUtil.addElements(new Integer[]{
                        1,0,1
                })
        ));
    }

    private static class Solution {
        public int getDecimalValue(LinkedListUtil.ListNode head) {
            return helper(head,0);
        }

        private int size = -1;
        public int helper(LinkedListUtil.ListNode head, int count) {
            size++;
            int result = 0;
            if(head.next!=null) {
                result += helper(head.next,count+1);
            }
            result += (head.val * Math.pow(2,size-count));
            return result;
        }
    }
}
//link - https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

/*
Question : -
    Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
    Return the decimal value of the number in the linked list.
 */

/*
Example : -
    Input: head = [1,0,1]
    Output: 5
    Explanation: (101) in base 2 = (5) in base 10
 */

//level - easy

//algorithms used -

//available in lists - Math Tag

//Time Complexity - O(n)

//Space Complexity - O(1)
