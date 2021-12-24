package com.ak.mycode.leetcode;

public class NumberOfStepsToReduceANumberToZero {

    public static void main(String[] args) {
        System.out.println(new NumberOfStepsToReduceANumberToZero().numberOfSteps(14));
    }

    public int numberOfSteps(int num) {
        int count=0;
        while(num>0) {
            if(num%2==0) num = num/2;
            else num-=1;
            count++;
        }
        return count;
    }
}

//link - https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

/*
Question : -
    Given an integer num, return the number of steps to reduce it to zero.
    In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
 */

/*
Example : -
    Input: num = 14
    Output: 6
    Explanation:
        Step 1) 14 is even; divide by 2 and obtain 7.
        Step 2) 7 is odd; subtract 1 and obtain 6.
        Step 3) 6 is even; divide by 2 and obtain 3.
        Step 4) 3 is odd; subtract 1 and obtain 2.
        Step 5) 2 is even; divide by 2 and obtain 1.
        Step 6) 1 is odd; subtract 1 and obtain 0.
 */

//level - easy

//algorithms used -

//available in lists - math-tag

//Time Complexity - O(log n)

//Space Complexity - O(1)