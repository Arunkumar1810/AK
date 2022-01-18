package com.ak.mycode.leetcode;

import java.util.HashMap;

public class FinalValueOfVariableAfterPerformingOperations {

    public static void main(String[] args) {
        System.out.println(new FinalValueOfVariableAfterPerformingOperations().finalValueAfterOperations(
                new String[]{"--X","X++","X++"}
            ));
    }

    public int finalValueAfterOperations(String[] operations) {
        int x=0;
        for(String operation : operations) {
            int op = 2;
            if(operation.charAt(1)=='+') {
                op=1;
            }
            if(op==1) {
                x+=1;
            }
            else {
                x-=1;
            }
        }
        return x;
    }
}

//link - https://leetcode.com/problems/final-value-of-variable-after-performing-operations/

/*
Question : -
    There is a programming language with only four operations and one variable X:
    ++X and X++ increments the value of the variable X by 1.
    --X and X-- decrements the value of the variable X by 1.
    Initially, the value of X is 0.
    Given an array of strings operations containing a list of operations, return the final value of X after performing all the operations.

 */

/*
Example : -
    Input: operations = ["--X","X++","X++"]
    Output: 1
    Explanation: The operations are performed as follows:
    Initially, X = 0.
    --X: X is decremented by 1, X =  0 - 1 = -1.
    X++: X is incremented by 1, X = -1 + 1 =  0.
    X++: X is incremented by 1, X =  0 + 1 =  1.
 */

//level - easy

//algorithms used -

//available in lists - array-tag

//Time Complexity - O(n)

//Space Complexity - O(1)

//inference hashmap can also be used