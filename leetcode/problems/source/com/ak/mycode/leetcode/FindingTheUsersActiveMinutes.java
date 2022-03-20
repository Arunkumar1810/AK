package com.ak.mycode.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindingTheUsersActiveMinutes {

    public static void main(String[] args) {
        int[] result = new Solution().findingUsersActiveMinutes(
                new int[][] {
                        {0,5},{1,2},{0,2},{0,5},{1,3}
                }, 5
        );

        for (int i : result) System.out.println(i);
    }

    private static class Solution {
        public int[] findingUsersActiveMinutes(int[][] logs, int k) {
            Map<Integer, Set<Integer>> uam = new HashMap<>();
            for(int[] action : logs) {
                Set<Integer> time = uam.getOrDefault(action[0],new HashSet<>());
                time.add(action[1]);
                uam.put(action[0],time);
            }

            int[] result = new int[k];
            for(Set<Integer> times : uam.values()) {
                int key = times.size();
                result[key-1]++;
            }

            return result;
        }
    }
}
//link - https://leetcode.com/problems/finding-the-users-active-minutes/

/*
Question : -
    You are given the logs for users' actions on LeetCode, and an integer k. The logs are represented by a 2D integer array logs where each logs[i] = [IDi, timei] indicates that the user with IDi performed an action at the minute timei.
    Multiple users can perform actions simultaneously, and a single user can perform multiple actions in the same minute.
    The user active minutes (UAM) for a given user is defined as the number of unique minutes in which the user performed an action on LeetCode. A minute can only be counted once, even if multiple actions occur during it.
    You are to calculate a 1-indexed array answer of size k such that, for each j (1 <= j <= k), answer[j] is the number of users whose UAM equals j.
    Return the array answer as described above.
 */

/*
Example : -
    Input: logs = [[0,5],[1,2],[0,2],[0,5],[1,3]], k = 5
    Output: [0,2,0,0,0]
    Explanation:
        The user with ID=0 performed actions at minutes 5, 2, and 5 again.
        Hence, they have a UAM of 2 (minute 5 is only counted once).
        The user with ID=1 performed actions at minutes 2 and 3. Hence, they have a UAM of 2.
        Since both users have a UAM of 2, answer[2] is 2, and the remaining answer[j] values are 0.
 */

//level - medium

//algorithms used - HashTable

//available in lists - HashTable Tag

//Time Complexity - O(n)

//Space Complexity - O(n)
