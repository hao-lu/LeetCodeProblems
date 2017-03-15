public class NumMatrix {
    int sum[][];
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        sum = new int [matrix.length + 1][matrix[0].length + 1];
        for (int r = 1; r < sum.length; r++) {
            for (int c = 1; c < sum[0].length; c++) {
                sum[r][c] = matrix[r-1][c-1] + sum[r][c-1] + sum[r-1][c] - sum[r-1][c-1];
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */