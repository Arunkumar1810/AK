package com.ak.mycode.leetcode;

public class MinimumSumOfFourDigitNumberAfterSplittingDigits {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumSum(4009));
    }

    private static class Solution {
        public int minimumSum(int num) {
            int small1 = 10, small2 = 10,small3 = 10, small4 = 10;
            while (num!=0) {
                int n = num%10;
                num = num/10;
                if(n<small1) {
                    int temp = small1;
                    small1 = n;
                    n = temp;
                }

                if(n<small2) {
                    int temp = small2;
                    small2 = n;
                    n = temp;
                }

                if(n<small3) {
                    int temp = small3;
                    small3 = n;
                    n = temp;
                }

                if(n<small4) {
                    small4 = n;
                }
            }
            return (small1*10 + small3) + (small2*10 + small4);
        }
    }
}
//link - https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/

/*
Question : -
    You are given a positive integer num consisting of exactly four digits.
    Split num into two new integers new1 and new2 by using the digits found in num.
    Leading zeros are allowed in new1 and new2, and all the digits found in num must be used.
    For example, given num = 2932, you have the following digits: two 2's, one 9 and one 3.
    Some possible pairs [new1, new2] are [22, 93], [23, 92], [223, 9] and [2, 329].
    Return the minimum possible sum of new1 and new2.
 */

/*
Example : -
    Input: num = 2932
    Output: 52
    Explanation: Some possible pairs [new1, new2] are [29, 23], [223, 9], etc.
    The minimum sum can be obtained by the pair [29, 23]: 29 + 23 = 52.
 */

//level - easy

//algorithms used -

//available in lists - Math tag

//Time Complexity - O(1)

//Space Complexity - O(1)
