package com.ak.mycode.leetcode;

public class GoalParserInterpretation {

    public static void main(String[] args) {
        System.out.println(new GoalParserInterpretation().interpret("G()()()()(al)"));
    }

    public String interpret(String command) {
        StringBuilder result = new StringBuilder("");
        char[] input = command.toCharArray();
        for(int i=0; i<input.length;i++) {
            if(input[i]=='G') {
                result.append("G");
            }
            else if(input[i]=='(') {
                if(input[i+1]==')') {
                    result.append("o");
                    i++;
                }
                else {
                    result.append("al");
                    i+=3;
                }
            }
        }
        return result.toString();
    }
}
//link - https://leetcode.com/problems/goal-parser-interpretation/

/*
Question : -
    You own a Goal Parser that can interpret a string command.
    The command consists of an alphabet of "G", "()" and/or "(al)" in some order.
    The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" as the string "al".
    The interpreted strings are then concatenated in the original order.
    Given the string command, return the Goal Parser's interpretation of command.
 */

/*
Example : -
    Input: command = "G()(al)"
    Output: "Goal"
    Explanation: The Goal Parser interprets the command as follows:
        G -> G
        () -> o
        (al) -> al
        The final concatenated result is "Goal".
 */

//level - easy

//algorithms used -

//available in lists - string tag

//Time Complexity - O(n)

//Space Complexity - o(n)
