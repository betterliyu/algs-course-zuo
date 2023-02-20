package basic.utils;

public class ArrayUtils {
    public static int[] createRandomArray(int maxLength, int maxValue) {
        int len = (int) (Math.random() * (maxLength + 1));
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }

    public static int[] createConsecutiveNotEqualArray(int maxLength, int maxValue) {
        int len = (int) (Math.random() * (maxLength + 1));
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            do {
                arr[i] = (int) (Math.random() * (maxValue + 1));
            } while(i > 0 && arr[i] == arr[i - 1]);

        }
        return arr;
    }


    public static boolean isSorted(int[] arr) {
        if (arr == null || arr.length < 2) {
            return true;
        }
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max > arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] copy(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
