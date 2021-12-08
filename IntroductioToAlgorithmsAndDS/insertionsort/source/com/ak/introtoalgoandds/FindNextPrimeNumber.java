package com.ak.introtoalgoandds;

public class FindNextPrimeNumber {
    public static int findNextPrimeNumber(int n) {
        if(n<=1) return 2;
        int prime = n;
        boolean isFound = false;
        while (!isFound) {
            prime++;
            isFound = isPrime(prime);
        }
        return prime;
    }

    private static boolean isPrime(int prime) {
        if(prime<=1) return false;
        if(prime<=3) return true;

        if(prime%2==0 || prime%3==0) return false;

        for (int i=5; i*i<=prime; i+=6) {
            if(prime%i==0 || prime%(i+2)==0)
                return false;
        }

        return true;
    }
}
