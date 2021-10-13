package com.ak.mycode.leetcode.top100liked;

//https://leetcode.com/problems/counting-bits/
public class CountingBits {

    public static void main(String[] args) {
        int[] result = new CountingBits().countBits(5);
        for(int i : result) System.out.println(i);
    }


    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 0) { //even
                // to count the number of 1s
                result[i] = result[i >>> 1];
            } else {
                // odd number's 1s count always +1 than previous even number
                result[i] = result[i - 1] + 1;
            }
        }
        return result;
    }
}
