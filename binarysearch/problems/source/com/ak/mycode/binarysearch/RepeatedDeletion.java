package com.ak.mycode.binarysearch;

//https://binarysearch.com/problems/Repeated-Deletion

//medium

//stack

//Your code took 39 milliseconds — faster than 99.28% in Java

// Top Interview Questions

public class RepeatedDeletion {

    public static void main(String[] args) {
        System.out.println(new RepeatedDeletion().solve("abbbaac"));
    }

    public String solve(String s) {
        if(s.isEmpty()) return s;
        char[] inputArray = s.toCharArray();
        char[] stack = new char[inputArray.length];
        int top = -1;
        stack[++top] = inputArray[0];
        boolean isRepeated = false;
        for (int i =1;i<inputArray.length;i++) {
            if(stack[top] == inputArray[i]) {
                isRepeated = true;
            }
            else {
                if(isRepeated) top--;
                if(top!=-1 && stack[top] == inputArray[i]) {
                    isRepeated = true;
                }
                else {
                    stack[++top] = inputArray[i];
                    isRepeated = false;
                }
            }
        }
        if(isRepeated) top--;
        return new String(stack,0,top+1);
    }
}
