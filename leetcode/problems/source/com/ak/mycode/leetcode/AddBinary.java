package com.ak.mycode.leetcode;

public class AddBinary {

    public static void main(String[] args) {
        String a = "1010", b="1011";
        AddBinary obj = new AddBinary();
        System.out.println(obj.addBinary(a,b));
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1, j = b.length()-1, carry = 0;
        while(i>=0 || j>=0){
            int sum = carry;
            if(j>=0) sum += b.charAt(j--) - '0';
            if(i>=0) sum += a.charAt(i--) - '0';
            sb.append(sum%2);
            carry = sum>>1;
        }
        if(carry!=0) sb.append(carry);
        return sb.reverse().toString();
    }
}

//link - https://leetcode.com/problems/add-binary/

/*
Question : -
    Given two binary strings a and b, return their sum as a binary string.
 */

/*
Example : -
    Input: a = "11", b = "1"
    Output: "100"
 */

//level - easy

//algorithms used -

//available in lists -

//Time Complexity - O(n+m)

//Space Complexity - O(n)
