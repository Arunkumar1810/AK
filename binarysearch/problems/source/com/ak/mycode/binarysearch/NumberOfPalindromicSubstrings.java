package com.ak.mycode.binarysearch;

//https://binarysearch.com/problems/Number-of-Palindromic-Substrings

//medium

//two pointer

//Your code took 8 milliseconds — faster than 100.00% in Java

//Top Interview Problems

public class NumberOfPalindromicSubstrings {
    public static void main(String[] args) {
        System.out.println(new NumberOfPalindromicSubstrings().solve("aacca"));
    }

    public int solve(String s) {
        int result = s.length();
        result+=findPalindromesAround(s.toCharArray(),result/2,result/2 +1,true,true);
        result+=findPalindromesAround(s.toCharArray(),result/2,true,true);
        return result;
    }

    public int findPalindromesAround(char[] input,int left, int right,boolean isLeft, boolean isRight) {
        int result = 0;
        for (int i = left,j=right; i>=0&&j<input.length;i--,j++) {
            if(input[i] != input[j]) {
                break;
            }
            else {
                result+=1;
            }
        }
        if(isLeft && left>0) {
            result+=findPalindromesAround(input,left-1,left,true,false);
        }

        if(isRight && right<input.length-1) {
            result+=findPalindromesAround(input,right,right+1,false,true);
        }
        return result;
    }

    public int findPalindromesAround(char[] input,int middle,boolean isLeft, boolean isRight) {
        int result = 0;
        for (int i = middle+1,j=middle-1; i<input.length&&j>=0;i++,j--) {
            if(input[i] != input[j]) {
                break;
            }
            else {
                result+=1;
            }
        }
        if(isLeft && middle>0) {
            result+=findPalindromesAround(input,middle-1,true,false);
        }

        if(isRight && middle<input.length-1) {
            result+=findPalindromesAround(input,middle+1,false,true);
        }
        return result;
    }
}
