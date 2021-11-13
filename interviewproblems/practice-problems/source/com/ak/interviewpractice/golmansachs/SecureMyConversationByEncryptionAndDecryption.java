package com.ak.interviewpractice.golmansachs;

//https://www.csestack.org/coding-challenge-secure-my-conversation-by-encryption-and-decryption/

//medium

//array

//Time Complexity - O(n) where n is the length of input (since we iterate through every element at most once the time complexity is O(n))

//Space Complexity - O(n) where n is the result of adding or subtracting the size of input and the elements of privateKey (since we create a result array in n size)

//Goldman Sachs Practice

public class SecureMyConversationByEncryptionAndDecryption {

    public static void main(String[] args) {
        System.out.println(new SecureMyConversationByEncryptionAndDecryption().solution(1,"Open","123"));
        System.out.println(new SecureMyConversationByEncryptionAndDecryption().solution(2,"Oppeeeen","124"));
    }

    private String solution (int type, String input, String privateKey) {
        int resultSize = input.length();
        char[] privateKeyArray = privateKey.toCharArray();

        //to get resultant array size
        for (char prK : privateKeyArray) {
            if(type == 1) {
                resultSize = resultSize + (prK - '0' - 1) ;
            }
            else {
                resultSize = resultSize - (prK - '0' - 1);
            }
        }

        char[] result = new char[resultSize];
        int count = 0;
        char[] inputArray = input.toCharArray();
        int privateKeyCounter = 0;
        int i =0;

        //iterate through input string until input string completed or privateKey completed
        while (i<inputArray.length) {

            //to add the character in the result while the privateKey value for the current character is greater than 0
            if (privateKeyArray[privateKeyCounter] > '0') {
                if (type == 1) {
                    //encryption so expanding (i.e., count increased for all iterations while i not increased )
                    result[count++] = inputArray[i];
                } else {
                    //decryption so compressing (i.e., i increased for all iterations while count not increased )
                    result[count] = inputArray[i++];
                }
                //decrementing privateKey value for current character
                privateKeyArray[privateKeyCounter] = (char) (privateKeyArray[privateKeyCounter] - 1);
            }

            //private key for the current character i
            if(privateKeyArray[privateKeyCounter]=='0')
            {
                //increasing i when private key is 0 for encryption
                if (type==1) i++;
                //increasing count when private key is 0 for decryption
                else count++;

                //break when private key is over else increment private key array
                if(privateKeyCounter<privateKeyArray.length-1) privateKeyCounter++;
                else break;
            }
        }

        //edge case when private key length is less than the decrypted String
        while (i<inputArray.length) {
            result[count++] = inputArray[i++];
        }

        return new String(result,0,count);
    }

}
