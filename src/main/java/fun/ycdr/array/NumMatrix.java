package fun.ycdr.array;

import java.util.Arrays;

public class NumMatrix {
    private int[][] preSum;
    public NumMatrix(int[][] matrix) {
        int[][] preSum=new int[matrix.length][matrix[0].length+1];
        for (int i = 0; i < preSum.length; i++) {
            for (int j = 1; j < preSum[i].length; j++) {
                preSum[i][j] = preSum[i][j-1]+matrix[i][j-1];
            }
        }
        this.preSum = preSum;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        System.out.println(Arrays.deepToString(preSum));
        int sum=0;
        for (int i = row1; i <= row2; i++) {
            sum+=preSum[i][col2+1]-preSum[i][col1];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] p=new int[][]{{3,0,1,4,2},{5,6,3,2,1}, {1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix numMatrix = new NumMatrix(p);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // return 8 (红色矩形框的元素总和)
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); // return 11 (绿色矩形框的元素总和)
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); // return 12 (蓝色矩形框的元素总和)
    }
}