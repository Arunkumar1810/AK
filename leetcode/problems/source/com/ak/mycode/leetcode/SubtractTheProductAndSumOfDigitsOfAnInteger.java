package com.ak.mycode.leetcode;

public class SubtractTheProductAndSumOfDigitsOfAnInteger {

    public static void main(String[] args) {
        System.out.println(new SubtractTheProductAndSumOfDigitsOfAnInteger().subtractProductAndSum(4421));
    }

    public int subtractProductAndSum(int n) {
        if(n==0) return 0;
        int sum=0;
        int product = 1;
        while(n>0) {
            int digit = n%10;
            n = n/10;
            sum+=digit;
            product*=digit;
        }

        return (product-sum);
    }
}

//link - https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/

/*
Question : -
    Given an integer number n, return the difference between the product of its digits and the sum of its digits.
 */

/*
Example : -
    Input: n = 234
    Output: 15
    Explanation:
        Product of digits = 2 * 3 * 4 = 24
        Sum of digits = 2 + 3 + 4 = 9
        Result = 24 - 9 = 15
 */

//level - easy

//algorithms used -

//available in lists - math-tag

//Time Complexity - O(n)

//Space Complexity - O(1)