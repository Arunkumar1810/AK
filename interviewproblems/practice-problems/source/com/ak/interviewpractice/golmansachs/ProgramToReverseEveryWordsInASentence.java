package com.ak.interviewpractice.golmansachs;

//https://www.faceprep.in/c/program-to-reverse-a-sentence-using-recursion/

//medium

//two pointer

//Time Complexity - O(2n) since every element visited twice

//Space Complexity - O(n) since created a separate array could have use the input string itself

//Goldman Sachs Practice

public class ProgramToReverseEveryWordsInASentence {

    public static void main(String[] args) {
        System.out.println(new ProgramToReverseEveryWordsInASentence().solution("Program to Reverse Every Words in a Sentence"));
    }

    private String solution(String sentence) {
        char[] result = sentence.toCharArray();
        int start=0;
        for (int i = 0;i<result.length;i++) {
            if(result[i]==' ') {
                for (int j = start;((i-j)%2==1 && (i-j)/2>1) || ((i-j)%2==0 && (i-j)/2>0);j++) {
                    char temp = result[j];
                    result[j] = result[i-(j-start)-1];
                    result[i-(j-start)-1] = temp;
                }
                start = i+1;
            }
        }
        for (int j = start;(result.length-1-j)/2>1;j++) {
            char temp = result[j];
            result[j] = result[result.length-1-(j-start)-1];
            result[result.length-1-(j-start)-1] = temp;
        }
        return new String(result);
    }
}
