package com.ak.mycode;

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
                if(!string.equals("")) {
                    if(stringToCount.containsKey(string)) {
                        int count = stringToCount.get(string);
                        if(count!=-1) {
                            count = count+1;
                            if(maxCount<count) {
                                maxCount = count;
                                maxString = string;
                            }
                            stringToCount.put(string, count);
                        }
                    }
                    else {
                        if(maxCount<1) {
                            maxString = string;
                        }
                        stringToCount.put(string,1);
                    }
                    currentString = new StringBuilder();
                }
            }
        }
        String string = currentString.toString();
        if(!string.equals("")) {
            if(stringToCount.containsKey(string)) {
                int count = stringToCount.get(string);
                if(count!=-1) {
                    count = count+1;
                    if(maxCount<count) {
                        maxString = string;
                    }
                    stringToCount.put(string, count);
                }
            }
            else {
                if(maxCount<1) {
                    maxString = string;
                }
                stringToCount.put(string,1);
            }
        }
        return maxString;
    }
}
