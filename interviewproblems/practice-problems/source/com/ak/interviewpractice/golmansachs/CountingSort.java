package com.ak.interviewpractice.golmansachs;

//https://www.faceprep.in/python/counting-sort/

//easy

//counting sort

/* Time Complexity
O(2n + (l - k)) where n : size of input, k : min of the input, l : max of the input.
2n : iterated once to get max and min, iterated once to add in the count array
l - k : this is the size of count array iterated through it once.
 */

/* Space Complexity
O(l - k) where k : min of the input, l : max of the input.
l - k : this is the size of count array
 */

//Goldman Sachs Practice

public class CountingSort {

    public static void main(String[] args) {
        int[] result = new CountingSort().solution(new int[] {0,3,9});
        for (int i : result) {
            System.out.println(i);
        }
    }

    private int[] solution(int[] input) {
        int maxEle = 0;
        int minEle = 0;
        for (int i : input) {
            if(maxEle<i) maxEle = i;
            if(minEle>i) minEle = i;
        }

        int[] countArray = new int[maxEle-minEle+1];

        for (int i : input) {
            countArray[i-minEle]++;
        }

        for (int i = 0,j=0;i<countArray.length&&j<input.length;) {
            if(countArray[i]>0) {
                input[j++] = i+minEle;
                countArray[i]--;
            }
            else i++;
        }
        return input;
    }
}
