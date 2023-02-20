package basic.class02;

import java.sql.SQLOutput;

/**
 * 求数组指定范围的和
 */
public class Code05_RangeSum {

    // ========= 矩阵实现 ========

    // 构建矩阵
    public static int[][] createResultMatrix(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int N = arr.length;
        int[][] result = new int[N][N];

        for (int vert = 0; vert < N; vert++) {
            for (int horiz = vert; horiz < N; horiz++) {
                if (horiz > vert) {
                    result[vert][horiz] = result[vert][horiz - 1] + arr[horiz];
                } else if (horiz == vert) {
                    result[vert][horiz] = arr[horiz];
                }
            }
        }

        return result;
    }

    // 矩阵实现
    public static int getRangeSum(int[][] resultMatrix, int start, int end) {
        if (start > end || start < 0 || end >= resultMatrix.length) {
            return 0;
        }
        return resultMatrix[start][end];
    }


    // ========= 前缀和实现 ========
    public static int[] createPrefixSumArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int N = arr.length;
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                result[i] = arr[i];
            } else {
                result[i] = result[i - 1] + arr[i];
            }
        }
        return result;
    }

    // 矩阵实现
    public static int getRangeSum2(int[] resultArray, int start, int end) {
        if (start > end || start < 0 || end >= resultArray.length) {
            return 0;
        }
        if (start == 0) {
            return resultArray[end];
        }
        return resultArray[end] - resultArray[start - 1];
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 8, 2, 5, -9, 3, 7, 1, 9, 6};

        int N = arr.length;

        System.out.println("矩阵实现");
        int[][] resMatrix = createResultMatrix(arr);

        for (int vert = 0; vert < N; vert++) {
            for (int horiz = 0; horiz < N; horiz++) {
                System.out.print(getRangeSum(resMatrix, vert, horiz) + "\t");
            }
            System.out.println();
        }

        System.out.println("0~5: " + getRangeSum(resMatrix, 0, 5));
        System.out.println("4~5: " + getRangeSum(resMatrix, 4, 5));
        System.out.println("-1~5: " + getRangeSum(resMatrix, -1, 5));
        System.out.println("4~3: " + getRangeSum(resMatrix, 4, 3));
        System.out.println("5~9: " + getRangeSum(resMatrix, 5, 9));
        System.out.println("4~14: " + getRangeSum(resMatrix, 4, 14));


        System.out.println("前缀和实现");
        int[] prefixSumArray = createPrefixSumArray(arr);


        for (int i = 0; i < N; i++) {
            System.out.print(prefixSumArray[i] + " ");
        }
        System.out.println();
        System.out.println("0~5: " + getRangeSum2(prefixSumArray, 0, 5));
        System.out.println("4~5: " + getRangeSum2(prefixSumArray, 4, 5));
        System.out.println("-1~5: " + getRangeSum2(prefixSumArray, -1, 5));
        System.out.println("4~3: " + getRangeSum2(prefixSumArray, 4, 3));
        System.out.println("5~9: " + getRangeSum2(prefixSumArray, 5, 9));
        System.out.println("4~14: " + getRangeSum2(prefixSumArray, 4, 14));
    }

}
