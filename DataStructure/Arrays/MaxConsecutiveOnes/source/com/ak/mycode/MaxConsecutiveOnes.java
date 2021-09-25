package com.ak.mycode;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] input = {};
        int result = new MaxConsecutiveOnes().findMaxConsecutiveOnes(input);
        System.out.println("Result : "+result);
    }

    public int findMaxConsecutiveOnes(int[] nums) {

        /* My Solution And The Best Solution*/
        int maxNumberOfOnes = 0;
        int numberOfOnes = 0;
        for (int num : nums) {
            if (num == 1) {
                numberOfOnes++;
            } else {
                if (maxNumberOfOnes < numberOfOnes) {
                    maxNumberOfOnes = numberOfOnes;
                }
                numberOfOnes = 0;
            }
        }
        if (maxNumberOfOnes < numberOfOnes) {
            maxNumberOfOnes = numberOfOnes;
        }
        return maxNumberOfOnes;



    }
}
