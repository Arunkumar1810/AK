package com.ak.mycode.leetcode;

public class MinimumCostToMoveChipsToTheSamePosition {

    public static void main(String[] args) {
        System.out.println(new Solution().minCostToMoveChips(new int[] {
                2,2,2,3,3
        }));
    }
    private static class Solution {
        public int minCostToMoveChips(int[] nums) {
            int numOfOdds=0, numOfEvens=0;
            for(int i : nums) {
                if(i%2==0) numOfEvens++;
                else numOfOdds++;
            }
            return Math.min(numOfEvens, numOfOdds);
        }
    }
}
