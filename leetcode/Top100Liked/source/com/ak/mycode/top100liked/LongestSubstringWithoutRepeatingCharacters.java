package com.ak.mycode.top100liked;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("cdvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        if(s==null) return 0;
        if(s.length()==1) return 1;
        char[] c=s.toCharArray();

        int current=0;
        int mSum =0;

        for(int i=1; i<c.length;i++){
            for(int j=current;j<i;j++){
                if(c[j]==c[i]) {
                    current= j+1;
                    break;
                }
            }
            mSum= Math.max(mSum, i-current+1);
        }

        return mSum;
    }
}
