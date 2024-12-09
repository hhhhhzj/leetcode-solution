package solution;

//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//
//        你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。


//思路，找到规律。以圈为粒度，总结圈里面数据移动规律。再对每个圈里面的数据做同样的操作。

/**
 * @author Zhijian.H
 * @since 2021/5/1 下午2:34
 */
public class Solution48 {

    public static void rotate(int[][] matrix) {
        int matrixLength = matrix.length - 1;
        for (int i = 0; i < matrix.length/2; i++) {
            int length = matrix.length - i - 1;
            for (int j = i; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrixLength - j][i];
                matrix[matrixLength - j][i] = matrix[matrixLength - i][matrixLength - j];
                matrix[matrixLength - i][matrixLength - j] = matrix[j][matrixLength - i];
                matrix[j][matrixLength - i] = temp;
            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        System.out.println(matrix);

        matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(matrix);
        System.out.println(matrix);

    }


}
