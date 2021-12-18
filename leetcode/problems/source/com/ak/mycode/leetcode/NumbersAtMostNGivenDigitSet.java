package com.ak.mycode.leetcode;

public class NumbersAtMostNGivenDigitSet {

    public static void main(String[] args) {
        System.out.println(new NumbersAtMostNGivenDigitSet().atMostNGivenDigitSet(new String[]{"3","5","7"},5));
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {
        int digitsOfN = findDigits(n);
        String nStr = String.valueOf(n);
        int result = 0;
        for(int i=1;i<digitsOfN;i++) {
            result += Math.pow(digits.length,i);
        }

        for (int i = 0; i < digitsOfN; i++) {
            boolean hasSameNum = false;
            for (String d : digits) {
                if (d.charAt(0) < nStr.charAt(i)) {
                    result += Math.pow(digits.length, digitsOfN -i-1);
                } else if (d.charAt(0) == nStr.charAt(i)) {
                    hasSameNum = true;
                }
            }
            if (!hasSameNum) return result;
        }

        return result+1;
    }

    public int findDigits(int n) {
        int digits =0;
        while(n!=0) {
            digits++;
            n=n/10;
        }
        return digits;
    }
}

//link - https://leetcode.com/problems/numbers-at-most-n-given-digit-set/

/*
Question : -
    Given an array of digits which is sorted in non-decreasing order. You can write numbers using each digits[i] as many times as we want. For example, if digits = ['1','3','5'], we may write numbers such as '13', '551', and '1351315'.
    Return the number of positive integers that can be generated that are less than or equal to a given integer n.
 */

/*
Example : -
    Input: digits = ["1","3","5","7"], n = 100
    Output: 20
    Explanation:
        The 20 numbers that can be written are:
        1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
 */

//level - hard

//algorithms used -

//available in lists -

//Time Complexity - O(n)

//Space Complexity - O(1)