package com.ak.mycode.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GenerateParentheses {

    public static void main (String[] args) {
        List<String> result = new GenerateParentheses().generateParenthesis(4);
        for (String string : result) System.out.println(string);
    }

    public List<String> generateParenthesis(int n) {
        List<String>[] dp = new ArrayList[n+1];
        List<String> result = new ArrayList<>();
        result.add("");
        dp[0] = result;
        for(int i = 1;i<=n;i++) {
            dp[i] = generateParenthesis(i,dp);
        }
        return dp[n];
    }

    public List<String> generateParenthesis(int n, List<String>[] dp) {
        List<String> result = new ArrayList<>();
        for(String pattern : dp[n-1]) {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(pattern);
            sb.append(")");
            result.add(sb.toString());
        }
        HashSet<String> res = new HashSet<>();
        for(int i=1;i<n;i++) {
            for(String part1 : dp[i]) {
                for(String part2 : dp[n-i]) {
                    res.add(new StringBuilder().append(part1).append(part2).toString());
                }
            }
        }
        result.addAll(res);
        return result;
    }
}
