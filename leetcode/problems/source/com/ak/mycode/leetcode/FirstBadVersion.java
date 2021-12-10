package com.ak.mycode.leetcode;

//https://leetcode.com/problems/first-bad-version/
class VersionControl {
    private int badVersion = 4;
    boolean isBadVersion(int version) {
        return version>=badVersion;
    }
}
public class FirstBadVersion extends VersionControl{

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        System.out.println("First Bad Version : "+firstBadVersion.firstBadVersion(5));
    }

    public int firstBadVersion(int endVersion) {
        int startVersion = 1;
        while (endVersion>startVersion) {
            int version = startVersion + (endVersion -startVersion)/2;
            if(isBadVersion(version)) endVersion = version;
            else startVersion = version + 1;
        }
        return endVersion;
    }
}
