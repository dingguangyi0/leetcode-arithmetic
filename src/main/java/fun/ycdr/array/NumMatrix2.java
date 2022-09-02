package fun.ycdr.array;

import java.util.Arrays;

public class NumMatrix2 {
    private int[][] preSum;
    public NumMatrix2(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] preSum=new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i-1][j]+preSum[i][j-1]-preSum[i-1][j-1]+matrix[i-1][j-1];
            }
        }
        this.preSum = preSum;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2+1][col2+1]-preSum[row2+1][col1]-preSum[row1][col2+1]+preSum[row1][col1];
    }

    public static void main(String[] args) {
        int[][] p=new int[][]{
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}};
        NumMatrix2 numMatrix = new NumMatrix2(p);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // return 8 (红色矩形框的元素总和)
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); // return 11 (绿色矩形框的元素总和)
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); // return 12 (蓝色矩形框的元素总和)
    }
}