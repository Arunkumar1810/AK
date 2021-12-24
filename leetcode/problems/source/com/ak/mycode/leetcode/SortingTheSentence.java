package com.ak.mycode.leetcode;

public class SortingTheSentence {

    public static void main(String[] args) {
        System.out.println(new SortingTheSentence().sortSentence("eHwJm3 xvJDHiymHBeCO2 uQjltjGlmIPdeOHsXSuD1"));
    }

    public String sortSentence(String s) {
        String[] splitString = s.split(" ");
        int[] indexes = new int[splitString.length];
        for(int i=0;i<splitString.length;i++) {
            String string = splitString[i];
            int index = string.charAt(string.length()-1)-'0';
            string = string.substring(0,string.length()-1);
            splitString[i] = string;
            indexes[i] = index;
        }

        quickSort(indexes,splitString,0,indexes.length-1);

        StringBuilder result = new StringBuilder();
        for (int i=0;i<splitString.length-1;i++) {
            result.append(splitString[i]).append(" ");
        }
        result.append(splitString[splitString.length-1]);
        return result.toString();
    }

    private void quickSort(int[] indexes, String[] splitString, int start, int end) {
        if(start>=end) return;

        int pivot = indexes[end],newPivotIndex=end-1;
        for (int i=start,j=end-1;i<=j;) {
            if(indexes[i]<pivot) {
                i++;
            }
            else {
                if (indexes[j] <= pivot) {
                    int tempIndex = indexes[i];
                    String tempString = splitString[i];

                    indexes[i] = indexes[j];
                    splitString[i] = splitString[j];

                    indexes[j] = tempIndex;
                    splitString[j] = tempString;
                    i++;
                }
                newPivotIndex = j;
                j--;
            }
        }

        if(indexes[newPivotIndex]>pivot) {
            int tempIndex = indexes[newPivotIndex];
            String tempString = splitString[newPivotIndex];

            indexes[newPivotIndex] = indexes[end];
            splitString[newPivotIndex] = splitString[end];

            indexes[end] = tempIndex;
            splitString[end] = tempString;

            quickSort(indexes,splitString,start,newPivotIndex-1);
            quickSort(indexes,splitString,newPivotIndex+1,end);
        }
        else {
            quickSort(indexes,splitString,start,end-1);
        }
    }
}

//link - https://leetcode.com/problems/sorting-the-sentence/

/*
Question : -
    A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each word consists of lowercase and uppercase English letters.
    A sentence can be shuffled by appending the 1-indexed word position to each word then rearranging the words in the sentence.
    For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 This1" or "is2 sentence4 This1 a3".
    Given a shuffled sentence s containing no more than 9 words, reconstruct and return the original sentence.
 */

/*
Example : -
    Input: s = "is2 sentence4 This1 a3"
    Output: "This is a sentence"
    Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the numbers.
 */

//level - easy

//algorithms used - quick sort

//available in lists - sorting-tag

//Time Complexity - O(n log n)

//Space Complexity - O(n)
