package com.ak.mycode.leetcode;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/unique-email-addresses/
public class UniqueEmailAddresses {

    public static void main(String[] args) {
        System.out.println("Result : "+new UniqueEmailAddresses().numUniqueEmails(new String[]
                {
                        "test.email+alex@leetcode.com",
                        "test.e.mail+bob.cathy@leetcode.com",
                        "testemail+david@lee.tcode.com"
                }));
    }

    public int numUniqueEmails(String[] emails) {
        Set<Long> properEmails = new HashSet<>();
        for (String email : emails) {
            long properEmailHash = 5381L;
            boolean isDomainStated = false;
            boolean isPlusStarted = false;
            for (char emailChar : email.toCharArray()) {
                if (emailChar == '+' && !isDomainStated) {
                    isPlusStarted = true;
                    continue;
                }
                if(isPlusStarted && !isDomainStated && emailChar!='@') continue;
                if(emailChar!='.' || isDomainStated)
                {
                    properEmailHash = (properEmailHash << 5) + properEmailHash + emailChar;
                }
                if(emailChar=='@') {
                    isDomainStated=true;
                }
            }
            properEmails.add(properEmailHash);
        }
        return properEmails.size();
    }
}
