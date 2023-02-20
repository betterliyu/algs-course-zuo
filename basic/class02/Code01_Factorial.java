package basic.class02;

public class Code01_Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(10));
    }

    /**
     * 计算一个数的阶乘
     * @param num
     * @return
     */
    public static int factorial(int num) {
        int result= 1;
        for (int i = 1; i <= num; i++) {
            result = result * i;
        }
        return result;
    }
}
