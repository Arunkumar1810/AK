package com.ak.interviewpractice.golmansachs;

//https://www.faceprep.in/python/number-of-squares-in-a-chessboard/

//easy

//mathematical (number of squares in a chess board like structure = n*n + (n-1)*(n-1) + (n-2)*(n-2) +....+ 1*1)

//Time Complexity O(n)

//Space Complexity O(1)

//Goldman Sachs Practice

public class NumberOfSquaresInAChessboard {
    public static void main(String[] args) {
        System.out.println(new NumberOfSquaresInAChessboard().solution(8));
    }

    private int solution(int x) {
        int result = 0;
        while (x>0) {
            result+=(x*x);
            x--;
        }
        return result;
    }
}
