package com.ak.mycode.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CellsInAOnAnExcelSheet {

    public static void main(String[] args) {
        List<String> result = new Solution().cellsInRange("K1:L2");
        for (String s : result) System.out.println(s);
    }
    private static class Solution {
        public List<String> cellsInRange(String s) {
            if(s == null || s.length() != 5) return null;
            List<String> result = new ArrayList<>();
            char startColumn = s.charAt(0), startRow = s.charAt(1), endColumn = s.charAt(3), endRow = s.charAt(4);
            StringBuilder sb = new StringBuilder();
            for(char column = startColumn ; column<=endColumn ; column++) {
                for(char row = startRow ; row <= endRow ; row++) {
                    sb.append(column);
                    sb.append(row);
                    result.add(String.valueOf(sb));
                    sb.delete(0,2);
                }
            }
            return result;
        }
    }
}
//link - https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet/

/*
Question : -
    A cell (r, c) of an excel sheet is represented as a string "<col><row>" where:
        <col> denotes the column number c of the cell. It is represented by alphabetical letters.
            For example, the 1st column is denoted by 'A', the 2nd by 'B', the 3rd by 'C', and so on.
        <row> is the row number r of the cell. The rth row is represented by the integer r.
    You are given a string s in the format "<col1><row1>:<col2><row2>",
    where <col1> represents the column c1, <row1> represents the row r1,
    <col2> represents the column c2, and <row2> represents the row r2, such that r1 <= r2 and c1 <= c2.
    Return the list of cells (x, y) such that r1 <= x <= r2 and c1 <= y <= c2.
    The cells should be represented as strings in the format mentioned above and be sorted in non-decreasing order first by columns and then by rows.
 */

/*
Example : -
    Input: s = "K1:L2"
    Output: ["K1","K2","L1","L2"]
    Explanation:
        The above diagram shows the cells which should be present in the list.
        The red arrows denote the order in which the cells should be presented.
 */

//level - easy

//algorithms used -

//available in lists - String Tag

//Time Complexity - O(n)

//Space Complexity - O(n)
