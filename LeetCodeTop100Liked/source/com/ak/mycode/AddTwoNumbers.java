package com.ak.mycode;

//https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {

    public static void main(String[] args) {

        int[] l1= {9,9,9,9,9,9,9},
                l2 = {9,9,9,9};

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode result = addTwoNumbers.addTwoNumbers(addTwoNumbers.makeList(l1),addTwoNumbers.makeList(l2));

        System.out.println("Result : ");
        while(result!=null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode makeList(int[] arr) {
        ListNode resultHead = new ListNode(arr[0], null);
        ListNode resultIter = resultHead;
        for (int i=1; i<arr.length;i++) {
            resultIter.next = new ListNode(arr[i], null);
            resultIter = resultIter.next;
        }
        return resultHead;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode resultHead = new ListNode();
        resultHead.val = l1.val + l2.val;
        int carry = resultHead.val/10;
        resultHead.val = resultHead.val%10;
        ListNode resultIter = resultHead;
        l1 = l1.next;
        l2 = l2.next;
        while(l1!=null && l2!=null)
        {
            int sum = l1.val+l2.val+carry;
            carry = sum/10;
            sum = sum%10;
            resultIter.next = new ListNode(sum, null);
            resultIter = resultIter.next;
            l1=l1.next;
            l2=l2.next;
        }

        while(l1!=null) {
            int sum = l1.val+carry;
            carry = sum/10;
            sum = sum%10;
            resultIter.next = new ListNode(sum, null);
            resultIter = resultIter.next;
            l1=l1.next;
        }

        while(l2!=null) {
            int sum = l2.val+carry;
            carry = sum/10;
            sum = sum%10;
            resultIter.next = new ListNode(sum, null);
            resultIter = resultIter.next;
            l2=l2.next;
        }

        if(carry!=0) {
            resultIter.next = new ListNode(carry % 10);
        }

        return resultHead;
    }

    static class ListNode {
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
