package basic.class02;

import basic.utils.ArrayUtils;

public class Code04_InsertSort {
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;

        for (int i = 1; i < N; i++) {
            int newNumIndex = i;
            while (newNumIndex - 1 >= 0 && arr[newNumIndex] < arr[newNumIndex - 1]) {
                swap(arr, newNumIndex, newNumIndex - 1);
                newNumIndex--;
            }

        }
    }

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int testTimes = 50;

        for (int i = 0; i < testTimes; i++) {
            int[] arr = ArrayUtils.createRandomArray(40, 100);
            int[] temp = ArrayUtils.copy(arr);
            insertSort(arr);
            if (!ArrayUtils.isSorted(arr)) {
                ArrayUtils.print(temp);
                ArrayUtils.print(arr);
                System.out.println("排序错误");
                break;
            }
        }
        System.out.println("测试结束");
    }
}
