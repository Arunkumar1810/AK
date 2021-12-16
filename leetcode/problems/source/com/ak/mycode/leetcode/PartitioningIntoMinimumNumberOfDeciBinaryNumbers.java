package com.ak.mycode.leetcode;

public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

    public static void main(String[] args) {
        System.out.println(new PartitioningIntoMinimumNumberOfDeciBinaryNumbers().minPartitions("27346209830709182346"));
    }

    public int minPartitions(String n) {
        char[] nArray = n.toCharArray();
        char max = nArray[0];
        for(char c : nArray) {
            if(c>max) {
                max=c;
            }
        }
        return max - '0';
    }
}

//link - https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/

/*
Question : -
    A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros. For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.

    Given a string n that represents a positive decimal integer, return the minimum number of positive deci-binary numbers needed so that they sum up to n.
 */

/*
Example : -
    Input: n = "32"
    Output: 3
    Explanation: 10 + 11 + 11 = 32
 */

//level - medium

//algorithms used -

//available in lists - string-tag

//Time Complexity - O(n)

//Space Complexity - O(1)