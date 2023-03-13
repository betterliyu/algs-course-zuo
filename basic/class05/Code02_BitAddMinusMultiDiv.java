package basic.class05;

public class Code02_BitAddMinusMultiDiv {
    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public static int minus(int a, int b) {
        return add(a, add(~b, 1));
    }

    public static int multi(int a, int b) {
        int sum = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                sum = add(a, sum);
            }
            a <<= 1;
            b >>>= 1;
        }

        return sum;
    }


    public static boolean isNeg(int x) {
        return x < 0;
    }

    public static int negNum(int x) {
        return add(~x, 1);
    }

    public static int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;

        int res = 0;
        int i = 30; // int 32 位 除去符号位
        while (i >= 0) {
            if (x >> i >= y) {
                res |= 1 << i;
                x = minus(x, y << i);
            }
            i = minus(i, 1);
        }

        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }


    public static int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            if (b == negNum(1)) {
                return Integer.MAX_VALUE;
            } else {
                int x = add(a, 1);
                int temp = div(x, b);
                return add(temp, div(minus(a, multi(temp, b)), b));
            }
        } else {
            return div(a, b);
        }
    }



    public static void main(String[] args) {
        System.out.println(divide(Integer.MIN_VALUE, 1));
    }
}
