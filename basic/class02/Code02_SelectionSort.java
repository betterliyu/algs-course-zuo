package basic.class02;

import basic.utils.ArrayUtils;

public class Code02_SelectionSort {
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int len = arr.length;

        for (int i = 0; i < len; i++) {
            // 当次循环，将最小值置换到 i 的位置，也就是档次循环第一个位置
            int min = i;
            for (int j = i + 1; j < len; j++) {
                min = arr[j] < arr[min] ? j : min;
            }
            // swap
            swap(arr, min, i);
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
            selectSort(arr);
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
