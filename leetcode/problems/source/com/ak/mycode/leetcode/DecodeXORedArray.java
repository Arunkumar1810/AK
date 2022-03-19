package com.ak.mycode.leetcode;

public class DecodeXORedArray {

    public static void main(String[] args) {
        int[] result = new Solution().decode(new int[]{1,2,3},1);
        for (int i : result) System.out.println(i);
    }

    private static class Solution {
        public int[] decode(int[] encoded, int first) {
            int[] result = new int[encoded.length+1];
            result[0] = first;
            for(int i = 1;i<result.length;i++) {
                result[i] = result[i-1] ^ encoded[i-1];
            }
            return result;
        }
    }
}
//link - https://leetcode.com/problems/decode-xored-array/

/*
Question : -
    There is a hidden integer array arr that consists of n non-negative integers.
    It was encoded into another integer array encoded of length n - 1, such that encoded[i] = arr[i] XOR arr[i + 1]. For example, if arr = [1,0,2,1], then encoded = [1,2,3].
    You are given the encoded array. You are also given an integer first, that is the first element of arr, i.e. arr[0].
    Return the original array arr. It can be proved that the answer exists and is unique.
 */

/*
Example : -
    Input: encoded = [1,2,3], first = 1
    Output: [1,0,2,1]
    Explanation: If arr = [1,0,2,1], then first = 1 and encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
 */

//level - easy

//algorithms used -

//available in lists - Array Tag

//Time Complexity - O(n)

//Space Complexity - O(1)
