package com.ak.mycode.leetcode;

public class BasicCalculatorII {

    public static void main(String[] args) {
        System.out.println(new BasicCalculatorII().calculate(" 3/2 "));
    }

    public int calculate(String s) {
        char[] input = s.toCharArray();
        char[] operatorStack = new char[input.length];
        int[] numbersStack = new int[input.length];
        int operatorStackHead = -1;
        int numberStackHead = -1;
        boolean isLastCharNum = false;
        for(int i=0;i<input.length;i++) {
            char c = input[i];
            if(c==' ') continue;
            if(c=='+' || c=='-' || c=='*' || c=='/') {
                if(c=='*'|| c=='/') {
                    int op1 = numbersStack[numberStackHead];
                    int op2 = 0;
                    i+=1;
                    while (i<input.length) {
                        if(input[i]==' ') {
                            i++;
                            continue;
                        }
                        if(input[i]=='+' || input[i]=='-' || input[i]=='*' || input[i]=='/')
                        {
                            i-=1;
                            break;
                        }
                        op2 = op2*10 + (input[i++]-'0');
                    }
                    int result = 0;
                    if(c=='*') {
                        result = op1*op2;
                    }
                    else if (op2!=0){
                        result = op1/op2;
                    }
                    numbersStack[numberStackHead] = result;
                }
                else {
                    operatorStack[++operatorStackHead] = c;
                }
                isLastCharNum = false;
            }
            else {
                int num = 0;
                if(isLastCharNum) {
                    num = numbersStack[numberStackHead--];
                }
                num = num*10 + (c-'0');
                numbersStack[++numberStackHead] = num;
                isLastCharNum = true;
            }
        }
        int result = numbersStack[0];
        for (int i=0,j=1;i<=operatorStackHead;i++) {
            char operator = operatorStack[i];
            int num = numbersStack[j++];
            if(operator=='+') {
                result += num;
            }
            else {
                result-=num;
            }
        }

        return result;
    }
}

//link - https://leetcode.com/problems/basic-calculator-ii/

/*
Question : -
    Given a string s which represents an expression, evaluate this expression and return its value.
    The integer division should truncate toward zero.
    You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
    Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

Constraints : -
    1 <= s.length <= 3 * 105
    s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
    s represents a valid expression.
    All the integers in the expression are non-negative integers in the range [0, 231 - 1].
    The answer is guaranteed to fit in a 32-bit integer.
 */

/*
Example : -
    Input: s = "3+2*2"
    Output: 7
 */

//level - medium

//algorithms used - stack

//available in lists -

//Time Complexity - O(n)

//Space Complexity - O(n)