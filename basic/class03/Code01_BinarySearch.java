package basic.class03;

import basic.class02.Code03_BubbleSort;
import basic.utils.ArrayUtils;

public class Code01_BinarySearch {

    public static int binarySearch(int[] arr, int target) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        if (arr.length == 1) {
            return arr[0] == target ? 0 : -1;
        }
        int ans = -1;

        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            int midVal = arr[mid];
            if (midVal == target) {
                ans = mid;
                break;
            } else if (midVal > target) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        return ans;
    }

    public static boolean test(int[] arr, int target, int ans) {
        if (arr == null || arr.length == 0) {
            return ans == -1;
        }
        if (ans >= arr.length) {
            return false;
        }
        boolean has = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                has = true;
                if (i == ans) {
                    return true;
                }
            }
        }
        return !has ? ans == -1 : false;
    }

    public static void main(String[] args) {
        int testTimes = 50;
        System.out.println("========== 常规二分查找 ============");
        for (int i = 0; i < testTimes; i++) {
            int[] arr = ArrayUtils.createRandomArray(50, 50);
            Code03_BubbleSort.bubbleSort(arr);
            int target = (int) (Math.random() * 100);
            if (!test(arr, target, binarySearch(arr, target))) {
                ArrayUtils.print(arr);
                System.out.println("target:" + target);
                System.out.println("出错了");
                return;
            }
        }

        System.out.println("测试完成");

    }
}
