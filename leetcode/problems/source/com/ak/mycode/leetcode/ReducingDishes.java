package com.ak.mycode.leetcode;

import java.util.Arrays;

public class ReducingDishes {

    public static void main(String[] args) {
        System.out.println(new ReducingDishes().maxSatisfaction(new int[]{-1,-8,0,5,-9}));
    }

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int singleSum = 0;
        int totalSum = 0;
        int n = satisfaction.length;
        for (int i = n - 1; i >= 0; i--) {
            if (singleSum + satisfaction[i] >= 0) {
                singleSum += satisfaction[i];
                totalSum += singleSum;
            } else {
                break;
            }
        }
        return totalSum;
    }
}

//link - https://leetcode.com/problems/reducing-dishes/

/*
Question : -
    A chef has collected data on the satisfaction level of his n dishes. Chef can cook any dish in 1 unit of time.
    Like-time coefficient of a dish is defined as the time taken to cook that dish including previous dishes multiplied by its satisfaction level i.e. time[i] * satisfaction[i].
    Return the maximum sum of like-time coefficient that the chef can obtain after dishes preparation.
    Dishes can be prepared in any order and the chef can discard some dishes to get this maximum value.
 */

/*
Example : -
    Input: satisfaction = [-1,-8,0,5,-9]
    Output: 14
    Explanation: After Removing the second and last dish, the maximum total like-time coefficient will be equal to (-1*1 + 0*2 + 5*3 = 14).
                 Each dish is prepared in one unit of time.
 */

//level - hard

//algorithms used - dp

//available in lists - dp-tag

//Time Complexity - O(n)

//Space Complexity - O(1)
