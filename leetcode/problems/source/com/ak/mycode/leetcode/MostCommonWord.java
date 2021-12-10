package com.ak.mycode.leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/most-common-word
public class MostCommonWord {
    public static void main(String[] args) {
        System.out.println(
                "Result : " + new MostCommonWord().mostCommonWord(
                        "Bob. hIt, baLl",
                        new String[]{"bob","hit"}
                )
        );
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String,Integer> stringToCount = new HashMap<>();
        String maxString = null;
        int maxCount = 0;
        for (String ban : banned) {
            stringToCount.put(ban,-1);
        }
        StringBuilder currentString = new StringBuilder();
        for (char character : paragraph.toCharArray()) {
            if(character>='a' && character<='z') {
                currentString.append(character);
            }
            else if(character>='A' && character<='Z') {
                currentString.append((char) (character - 'A' + 'a'));
            }
            else {
                String string = currentString.toString();
                int count = stringToCount.getOrDefault(string,0);
                if(count!=-1 && string.length()!=0 && maxCount<++count) {
                    maxCount = count;
                    maxString = string;
                }
                stringToCount.put(string, count);
                currentString = new StringBuilder();
            }
        }
        String string = currentString.toString();
        int count = stringToCount.getOrDefault(string,0);
        if(string.length()!=0 && maxCount<=count) {
            maxString = string;
        }
        return maxString;
    }
}
