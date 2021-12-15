package com.ak.mycode.leetcode;

public class RichestCustomerWealth {

    public static void main(String[] args) {
        System.out.println(new RichestCustomerWealth().maximumWealth(new int[][]{
                {1,2,3},
                {3,2,1},
                {4,3,2}
        }));
    }

    public int maximumWealth(int[][] accounts) {
        int max=0;
        for(int[] cust : accounts) {
            int currTotal=0;
            for(int mon : cust) currTotal+=mon;
            max=Math.max(max,currTotal);
        }
        return max;
    }

}

//link - https://leetcode.com/problems/richest-customer-wealth/

/*
Question : -
    You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the ith customer has in the jth bank. Return the wealth that the richest customer has.
    A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.

Constraints : -
    m == accounts.length
    n == accounts[i].length
    1 <= m, n <= 50
    1 <= accounts[i][j] <= 100
 */

/*
Example : -
    Input: accounts = [[1,2,3],[3,2,1]]
    Output: 6
    Explanation:
        1st customer has wealth = 1 + 2 + 3 = 6
        2nd customer has wealth = 3 + 2 + 1 = 6
        Both customers are considered the richest with a wealth of 6 each, so return 6.
 */

//level - easy

//algorithms used -

//available in lists - array-tag

//Time Complexity - O(n)

//Space Complexity - O(1)