package com.ak.mycode.leetcode;

public class DIStringMatch {

    public static void main(String[] args) {
        int[] result = new DIStringMatch.Solution().diStringMatch("IDID");
        for (int i : result) {
            System.out.print(i+"\t");
        }
    }

    private static class Solution {
        public int[] diStringMatch(String s) {
            int[] result = new int[s.length()+1];
            int smallValue = 0, largeValue = s.length(),i=0;
            for(char c : s.toCharArray()) {
                if(c=='I') {
                    result[i++] = smallValue++;
                }
                else {
                    result[i++] = largeValue--;
                }
            }
            if(s.charAt(s.length()-1) == 'I') {
                result[i] = smallValue;
            }
            else {
                result[i] = largeValue;
            }
            return result;
        }
    }
}
