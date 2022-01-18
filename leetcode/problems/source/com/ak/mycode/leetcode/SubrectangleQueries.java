package com.ak.mycode.leetcode;

class SubrectangleQueries {

    public static void main(String[] args) {
    }

    private int[][] rectangle = null;
    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        if(!(row1>=0&&row1<=row2&&row2<rectangle.length && col1>=0&&col1<=col2&&col2<rectangle[0].length)) return;
        for(int i=row1;i<=row2;i++)
            for(int j=col1;j<=col2;j++) rectangle[i][j] = newValue;
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }
}
