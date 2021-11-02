package com.ak.mycode.binarysearch;

//https://binarysearch.com/problems/Text-Editor

//easy

//stack

//Your code took 24 milliseconds — faster than 98.88% in Java

//Top Interview Problems

public class TextEditor {

    public static void main(String[] args) {
        System.out.println(new TextEditor().solve("<-"));
    }

    public String solve(String s) {
        char[] result = new char[s.length()];
        char[] input = s.toCharArray();
        int top = -1;
        for (int i = 0 ; i < input.length ; i++) {
            if(input[i] == '<' && i+1<input.length && input[i+1] == '-') {
                if(top>-1)top--;
                i++;
            }
            else {
                result[++top] = input[i];
            }
        }
        return new String(result,0,top+1);
    }
}
