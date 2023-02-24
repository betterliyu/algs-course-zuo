package basic.class03;

import basic.utils.ArrayUtils;

public class Code03_BinarySearchLocalMinimal {

    /**
     * 找到数组中任意一个局部最小值
     *
     * @return
     */
    public static int binarySearchLocalMinimal(int[] arr) {
        if (arr == null || arr.length < 1) {
            return -1;
        }

        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }

        int N = arr.length;

        if (arr[N - 1] < arr[N - 2]) {
            return N - 1;
        }

        int ans = -1;

        int L = 0;
        int R = arr.length - 1;
        while (L < R - 1) {
            int mid = (L + R) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else {
                if (arr[mid] > arr[mid - 1]) {
                    R = mid;
                } else if (arr[mid] > arr[mid + 1]) {
                    L = mid;
                }
            }
        }

        return ans;
    }

    // 测试：找到数组中任意一个局部最小值
    public static boolean test(int[] arr, int ans) {
        if (arr == null || arr.length == 0) {
            return -1 == ans;
        }
        boolean prevBigger = ans == 0 ? true : arr[ans - 1] > arr[ans];
        boolean nextBigger = ans == arr.length - 1 ? true : arr[ans + 1] > arr[ans];
        return prevBigger && nextBigger;
    }

    public static void main(String[] args) {

        int testTimes = 50;
        System.out.println("========== 找到数组中任意一个局部最小值 ============");
        for (int i = 0; i < testTimes; i++) {
            int[] arr = ArrayUtils.createConsecutiveNotEqualArray(20, 20);
            if (!test(arr, binarySearchLocalMinimal(arr))) {
                System.out.println("出错了");
                System.out.println("执行结果：" + binarySearchLocalMinimal(arr));
                return;
            }
        }

        System.out.println("测试完成");

    }
}
