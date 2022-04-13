package com.ak.mycode.tools;

public class Test {
    public static void main (String[] args) throws java.lang.Exception
    {
        int[] result = getSquaredArray(new int[]{-9,-7,-6,-6,-3,0});
        for (int i : result) {
            System.out.println(i);
        }

        System.out.println(getFractionToDecimal(1222,999));
    }

    public static int[] getSquaredArray(int[] arr) {
        if(arr==null || arr.length==0) return null;
        int[] result = new int[arr.length];
        for(int i=0, j=arr.length-1,k=j; i<j;k--) {
            if(arr[i]*arr[i] >= arr[j]*arr[j]) {
                result[k] = arr[i]*arr[i];
                i++;
            }
            else {
                result[k] = arr[j]*arr[j];
                j--;
            }
        }
        return result;
    }

    public static String getFractionToDecimal(int numerator, int denominator) {
        int wholeNumber = numerator/denominator;

        int reminder = (numerator%denominator);

        int pos = 0;

        for(int i=denominator;i>0;i%=10) pos++;


        return getFractionPart(null,"",reminder,denominator,pos,wholeNumber+".");
    }

    private static String getFractionPart(String prevNumber, String currentNumber, int reminder, int denominator, int pos,String result) {
        for(int i=0;i<pos;i++) {
            reminder *= 10;
            while (reminder / denominator == 0) {
                reminder = reminder * 10;
                currentNumber += "0";
            }

            currentNumber += (reminder / denominator);

            reminder = reminder % denominator;
        }

        if(prevNumber!=null && prevNumber.equals(currentNumber)) {
            result+="("+currentNumber+")";
            return result;
        }
        else {
            if(prevNumber!=null) result+=prevNumber;
            prevNumber=currentNumber;
            return getFractionPart(prevNumber,"",reminder,denominator,pos,result);
        }
    }

}
