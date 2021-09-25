package com.ak.mycode;

public class FindNumbersWithEvenNumberOfDigits {

    public static void main(String[] args) {
        int[] input = {12,345,2,6,7896};
        int result = new FindNumbersWithEvenNumberOfDigits().findNumbers(input);
        System.out.println("Result : "+result);
    }

    public int findNumbers(int[] nums) {
        //My Solution
        /*
        if(nums.length>=1 && nums.length<=500) {
            int numbersWithEvenNumberOfDigits = 0;
            for(int num : nums) {
                if(num>=1 && num<=(Math.pow(10,5))) {
                    if(getDigits(num)%2 == 0) {
                    //if(((int) Math.log10(num)+1) % 2 == 0) {
                        numbersWithEvenNumberOfDigits++;
                    }
                }
            }
            return numbersWithEvenNumberOfDigits;
        }
        return 0;
         */

        //Best Solution
        ///*
        int res=0;
        for(int x:nums)
        {
            //res+=(int)Math.log10(x)&1;
            res+=(getDigits(x)-1)&1;
        }
        return res;
        //*/
    }

    public int getDigits(int num) {
        int digits = 0;
        while (num!=0) {
            num = num/10;
            digits++;
        }
        return digits;
    }
}
