package com.ak.mycode.binarysearch;

//https://binarysearch.com/problems/String-Addition

//easy

//array

//Your code took 4 milliseconds — faster than 100.00% in Java

//Top Interview Problems

public class StringAddition {

    public static void main(String[] args) {
        System.out.println(new StringAddition().solve("4","14"));
    }

    public String solve(String a, String b) {
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        char[] result = new char[Math.max(aArray.length,bArray.length)+1];
        int i = aArray.length-1, j = bArray.length-1;
        int carry = 0;
        int k = result.length-1;
        while (i>=0&&j>=0) {
            int num1 = aArray[i--]-'0';
            int num2 = bArray[j--]-'0';
            int sum = num1+num2+carry;
            result[k--] = (char) ((sum%10)+'0');
            carry = sum/10;
        }

        while (i>=0) {
            int num = aArray[i--]-'0';
            int sum = num+carry;
            result[k--] = (char) ((sum%10)+'0');
            carry = sum/10;
        }

        while (j>=0) {
            int num = bArray[j--]-'0';
            int sum = num+carry;
            result[k--] = (char) ((sum%10)+'0');
            carry = sum/10;
        }

        if(carry!=0) result[k--] = (char) (carry+'0');

        return new String(result,k+1,result.length-k-1);
    }
}
