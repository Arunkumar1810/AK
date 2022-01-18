package com.ak.mycode.leetcode;

public class MaximumNumberOfWordsFoundInSentences {

    public static void main(String[] args) {
        String[] sentences = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        MaximumNumberOfWordsFoundInSentences obj = new MaximumNumberOfWordsFoundInSentences();
        System.out.println(obj.mostWordsFound(sentences));
    }

    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String sentence : sentences) {
            int count = 1;
            for (char c : sentence.toCharArray()) {
                if (c == ' ') count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}

//link - https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/

/*
Question : -
    A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
    You are given an array of strings sentences, where each sentences[i] represents a single sentence.
    Return the maximum number of words that appear in a single sentence.
 */

/*
Example : -
    Input: sentences = ["alice and bob love leetcode", "i think so too", "this is great thanks very much"]
    Output: 6
    Explanation:
    - The first sentence, "alice and bob love leetcode", has 5 words in total.
    - The second sentence, "i think so too", has 4 words in total.
    - The third sentence, "this is great thanks very much", has 6 words in total.
    Thus, the maximum number of words in a single sentence comes from the third sentence, which has 6 words.
 */

//level - easy

//algorithms used -

//available in lists - array-tag

//Time Complexity - O(n)

//Space Complexity - O(1)

//Inference - Used smaller data types like byte short in place of int based on the constraint requirement