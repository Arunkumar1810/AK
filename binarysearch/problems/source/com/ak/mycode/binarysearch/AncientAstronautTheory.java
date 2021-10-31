package com.ak.mycode.binarysearch;

//https://binarysearch.com/problems/Ancient-Astronaut-Theory

//easy

//array

//Your code took 4 milliseconds — faster than 99.77% in Java

//Top Interview Problems

public class AncientAstronautTheory {
    public static void main(String[] args) {
        System.out.println(new AncientAstronautTheory().solve("acb","aaaa h ccc i bbb"));
    }

    public boolean solve(String dictionary, String s) {
        if(dictionary.isEmpty() || s.isEmpty()) return true;
        char[] dictionaryArray = dictionary.toCharArray();
        char[] inputArray = s.toCharArray();
        int dictionaryPointer = 0;
        for (char c : inputArray) {
            if (dictionaryArray[dictionaryPointer] != c) {
                for (int j = 0; j < dictionaryArray.length; j++) {
                    if (c == dictionaryArray[j]) {
                        if (j >= dictionaryPointer) {
                            dictionaryPointer = j;
                            break;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
