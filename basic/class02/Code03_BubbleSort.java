package basic.class02;

import basic.utils.ArrayUtils;

public class Code03_BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;

        for (int i = N - 1; i >= 0; i--) {
            // 从 0 ~ i， 将大的值冒泡到最后一个
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
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
            bubbleSort(arr);
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
