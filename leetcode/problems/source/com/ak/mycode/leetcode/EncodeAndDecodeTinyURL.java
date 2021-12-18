package com.ak.mycode.leetcode;

import java.util.ArrayList;

public class EncodeAndDecodeTinyURL {

    public static void main(String[] args) {
        EncodeAndDecodeTinyURL encodeAndDecodeTinyURL = new EncodeAndDecodeTinyURL();
        System.out.println(encodeAndDecodeTinyURL.decode(encodeAndDecodeTinyURL.encode("https://leetcode.com/problems/design-tinyurl")));
    }

    ArrayList<String> urls = new ArrayList<>();
    int count = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int key = count;
        urls.add(key,longUrl);
        count++;
        return "http://tinyurl.com/"+key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String keyString = shortUrl.replaceAll("http://tinyurl.com/","");
        int key = Integer.parseInt(keyString);
        return urls.get(key);
    }
}

//link - https://leetcode.com/problems/encode-and-decode-tinyurl/

/*
Question : -
    TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk. Design a class to encode a URL and decode a tiny URL.
    There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
    Implement the Solution class:
        Solution() Initializes the object of the system.
        String encode(String longUrl) Returns a tiny URL for the given longUrl.
        String decode(String shortUrl) Returns the original long URL for the given shortUrl. It is guaranteed that the given shortUrl was encoded by the same object.
 */

/*
Example : -
    Input: url = "https://leetcode.com/problems/design-tinyurl"
    Output: "https://leetcode.com/problems/design-tinyurl"
    Explanation:
        Solution obj = new Solution();
        string tiny = obj.encode(url); // returns the encoded tiny url.
        string ans = obj.decode(tiny); // returns the original url after deconding it.
 */

//level - medium

//algorithms used -

//available in lists - hash table-tag

//Time Complexity - O(1)

//Space Complexity - O(1)