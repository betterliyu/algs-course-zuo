package basic.class03;

import basic.class02.Code03_BubbleSort;
import basic.utils.ArrayUtils;

public class Code03_BinarySearchLastSmaller {

    /**
     * 找到数组中最后一个小于等于 x 的位置
     * @return
     */
    public static int binarySearchLastSmallerOrEqual(int[] arr, int target) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        if (arr.length == 1) {
            return arr[0] <= target ? 0 : -1;
        }

        int ans = -1;

        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            int midVal = arr[mid];
            if (midVal > target) {
                R = mid - 1;
            } else {
                ans = mid;
                L = mid + 1;
            }
        }

        return ans;
    }


    // 测试： 找到数组中最后一个小于等于 x 的位置
    public static int test(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > target) {
                return i == 0 ? -1 : i -1;
            }
        }
        return arr.length - 1;
    }

    public static void main(String[] args) {

        int testTimes = 50;
        System.out.println("========== 二分查找 找到数组中最一个小于等于 x 的位置 ============");
        for (int i = 0; i < testTimes; i++) {
            int[] arr = ArrayUtils.createRandomArray(40, 50);
            Code03_BubbleSort.bubbleSort(arr);
            int target = (int)(Math.random() * 100);
            if(test(arr, target) != binarySearchLastSmallerOrEqual(arr, target)) {
                ArrayUtils.print(arr);
                System.out.println("target:" + target);
                System.out.println("出错了");
                System.out.println("测试结果：" + test(arr, target));
                System.out.println("执行结果：" + binarySearchLastSmallerOrEqual(arr, target));
                return;
            }
        }

        System.out.println("测试完成");

    }
}
