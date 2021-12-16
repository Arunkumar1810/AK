package com.ak.mycode.leetcode;

public class DefangingAnIPAddress {

    public static void main(String[] args) {
        System.out.println(new DefangingAnIPAddress().defangIPaddr("255.100.50.0"));
    }

    public String defangIPaddr(String address) {
        char[] addressArray = address.toCharArray();
        char[] result = new char[addressArray.length+6];
        for(int i=0,j=0;i<addressArray.length&&j<result.length;i++){
            if(addressArray[i]=='.') {
                result[j++] = '[';
            }
            result[j++] = addressArray[i];
            if(addressArray[i]=='.') {
                result[j++] = ']';
            }
        }
        return new String(result);
    }
}

//link - https://leetcode.com/problems/defanging-an-ip-address/

/*
Question : -
    Given a valid (IPv4) IP address, return a defanged version of that IP address.

    A defanged IP address replaces every period "." with "[.]".
 */

/*
Example : -
    Input: address = "1.1.1.1"
    Output: "1[.]1[.]1[.]1"
 */

//level - easy

//algorithms used -

//available in lists - string-tag

//Time Complexity - O(n)

//Space Complexity - O(n)