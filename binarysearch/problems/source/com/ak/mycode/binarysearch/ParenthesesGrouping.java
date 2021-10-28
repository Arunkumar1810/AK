package com.ak.mycode.binarysearch;

import java.util.ArrayList;
import java.util.List;

//https://binarysearch.com/problems/Parentheses-Grouping

//easy

//stack, array

//Your code took 17 milliseconds — faster than 98.44% in Java

public class ParenthesesGrouping {

    public static void main(String[] args) {
        String[] result = new ParenthesesGrouping().solve("()()(()())");
        for (String string : result) {
            System.out.println(string);
        }
    }

    public String[] solve(String s) {
        char[] stack = new char[s.length()];
        int stackHead = 0;
        char[] input = s.toCharArray();
        int balancedNumber = 0;
        List<String> result = new ArrayList<>();
        for (char in : input) {
            if(in == '(') {
                stack[stackHead++] = '(';
                balancedNumber++;
            }
            else {
                if(balancedNumber == 1) {
                    stack[stackHead] = ')';
                    result.add(new String(stack,0,stackHead+1));
                    stackHead = 0;
                    balancedNumber = 0;
                }
                else {
                    stack[stackHead++] = ')';
                    balancedNumber--;
                }
            }
        }
        String[] resultArray = new String[result.size()];
        result.toArray(resultArray);
        return resultArray;
    }
}
