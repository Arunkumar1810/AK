package com.ak.mycode.binarysearch;

//https://binarysearch.com/problems/Add-Binary-Numbers

//array

//medium

//Your code took 6 milliseconds — faster than 99.82% in Java

public class AddBinaryNumbers {

    public static void main(String[] args) {
        System.out.println(new AddBinaryNumbers().solve("000", "0"));
    }

    public String solve(String a, String b) {
        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();
        char[] resultCharArray = new char[Math.max(aCharArray.length, bCharArray.length)+1];
        char carry = '0';
        int k = resultCharArray.length - 1, i = aCharArray.length - 1, j = bCharArray.length - 1;
        for (;i >= 0 && j >= 0;i--,j--) {
            if (aCharArray[i] == '1') {
                if (bCharArray[j] == '1') {
                    if(carry == '1') {
                        resultCharArray[k--] = '1';
                    }
                    else {
                        resultCharArray[k--] = '0';
                        carry = '1';
                    }
                }
                else {
                    if(carry == '1') {
                        resultCharArray[k--] = '0';
                        carry = '1';
                    }
                    else {
                        resultCharArray[k--] = '1';
                    }
                }
            } else {
                if (bCharArray[j] == '1') {
                    if(carry == '1') {
                        resultCharArray[k--] = '0';
                        carry = '1';
                    }
                    else {
                        resultCharArray[k--] = '1';
                    }
                }
                else {
                    if(carry == '1') {
                        resultCharArray[k--] = '1';
                        carry = '0';
                    }
                    else {
                        resultCharArray[k--] = '0';
                    }
                }
            }
        }

        for (;i>=0;i--) {
            if(aCharArray[i] == '1') {
                if(carry == '1') {
                    resultCharArray[k--] = '0';
                }
                else {
                    resultCharArray[k--] = '1';
                    carry = '0';
                }
            }
            else {
                if(carry == '1') {
                    resultCharArray[k--] = '1';
                    carry = '0';
                }
                else {
                    resultCharArray[k--] = '0';
                }
            }
        }

        for (;j>=0;j--) {
            if(bCharArray[j] == '1') {
                if(carry == '1') {
                    resultCharArray[k--] = '0';
                }
                else {
                    resultCharArray[k--] = '1';
                    carry = '0';
                }
            }
            else {
                if(carry == '1') {
                    resultCharArray[k--] = '1';
                    carry = '0';
                }
                else {
                    resultCharArray[k--] = '0';
                }
            }
        }
        resultCharArray[k] = carry;
        for (k=0;k<resultCharArray.length-1&&resultCharArray[k]!='1';k++);
        return new String(resultCharArray,k,resultCharArray.length-k);
    }
}
