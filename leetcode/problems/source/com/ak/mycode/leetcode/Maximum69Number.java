package com.ak.mycode.leetcode;

public class Maximum69Number {

    public static void main(String[] args) {
        System.out.println(new Maximum69Number.Solution().maximum69Number(966969));
    }

    public static class Solution {
        public int maximum69Number (int num) {
            int first6Dig = 0, temp = num, dig = 0;
            while (temp!=0) {
                dig++;
                int val = temp%10;
                temp = temp/10;
                if(val==6) first6Dig=dig;
            }

            num = num - (int)(6*Math.pow(10,first6Dig-1)) + (int)(9*Math.pow(10,first6Dig-1));

            return num;
        }
    }
}
