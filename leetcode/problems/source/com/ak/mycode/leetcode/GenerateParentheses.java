package com.ak.mycode.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main (String[] args) {
        List<String> result = new GenerateParentheses().generateParenthesis(4);
        for (String string : result) System.out.println(string);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        for (int i=1;i<n;i++) {
            result = generateParenthesis(i);
        }
        return result;
    }
}
