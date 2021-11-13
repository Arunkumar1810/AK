package com.ak.interviewpractice.golmansachs;

//https://www.faceprep.in/python/ugly-number/

//easy

//mathematics, dynamic programming

//Time Complexity O(n)

//Space Complexity O(n)

//Goldman Sachs Practice

public class UglyNumber {

    public static void main(String[] args) {
        System.out.println(new UglyNumber().solutionSimple(150));
        System.out.println(new UglyNumber().solutionDynamic(150));
    }

    private int solutionSimple(int n) {
        int result = 0;
        while (n>0) {
            result++;
            int temp = maxDivide(result,2);
            temp = maxDivide(temp,3);
            temp = maxDivide(temp,5);
            if(temp==1) n--;
        }
        return result;
    }

    private int maxDivide(int result, int i) {
        while (result%i==0) result = result/i;
        return result;
    }

    private int solutionDynamic(int n) {
        int i2=0,i3=0,i5=0;
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        for (int i = 1 ; i < n ; i++) {
            if(uglyNums[i2] * 2 == uglyNums[i3] * 3 && uglyNums[i2] * 2 < uglyNums[i5] * 5) {
                uglyNums[i] = uglyNums[i2]*2;
                i2++;
                i3++;
            }
            else if(uglyNums[i2] * 2 < uglyNums[i3] * 3 && uglyNums[i2] * 2 == uglyNums[i5] * 5) {
                uglyNums[i] = uglyNums[i2]*2;
                i2++;
                i5++;
            }
            else if(uglyNums[i2] * 2 == uglyNums[i3] * 3 && uglyNums[i2] * 2 == uglyNums[i5] * 5) {
                uglyNums[i] = uglyNums[i2]*2;
                i2++;
                i3++;
                i5++;
            }
            else if(uglyNums[i2] * 2 < uglyNums[i3] * 3 && uglyNums[i2] * 2 < uglyNums[i5] * 5) {
                uglyNums[i] = uglyNums[i2]*2;
                i2++;
            }
            else if(uglyNums[i3] * 3 < uglyNums[i2] * 2 && uglyNums[i3] * 3 == uglyNums[i5] * 5) {
                uglyNums[i] = uglyNums[i3]*3;
                i3++;
                i5++;
            }
            else if(uglyNums[i3] * 3 < uglyNums[i2] * 2 && uglyNums[i3] * 3 < uglyNums[i5] * 5) {
                uglyNums[i] = uglyNums[i3]*3;
                i3++;
            }
            else {
                uglyNums[i] = uglyNums[i5]*5;
                i5++;
            }
        }
        return uglyNums[uglyNums.length-1];
    }
}
