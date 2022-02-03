package com.ak.mycode.leetcode;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {

    public static void main(String[] args) {
        List<Boolean> result;
        result = new KidsWithTheGreatestNumberOfCandies().kidsWithCandies(new int[]
                {3, 3, 5, -1, -2, 4}, 2);

        for (Boolean point : result) System.out.println(point);
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for(int candy : candies) {
            maxCandies = Math.max(candy,maxCandies);
        }

        List<Boolean> result = new ArrayList<>();

        for (int candy : candies) {
            result.add((candy + extraCandies) >= maxCandies);
        }

        return result;
    }
}

//link - https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

/*
Question : -
   There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.
    Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.
    Note that multiple kids can have the greatest number of candies.
 */

/*
Example : -
    Input: candies = [2,3,5,1,3], extraCandies = 3
    Output: [true,true,true,false,true]
    Explanation: If you give all extraCandies to:
    - Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
    - Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
    - Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
    - Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
    - Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
 */

//level - easy

//algorithms used -

//available in lists - array-tag

//Time Complexity - O(n)

//Space Complexity - O(n)
