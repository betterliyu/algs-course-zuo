package basic.class01;

public class Code01_Print_32bit {
    public static void main(String[] args) {
        int num = 8278;
//        print(num);
//
//        System.out.println(Integer.MAX_VALUE + ":");
//        print(Integer.MAX_VALUE);
//
//        System.out.println(Integer.MIN_VALUE + ":");
//        print(Integer.MIN_VALUE);
//
//        System.out.println(-1 + ":");
//        print(-1);
//
//        System.out.println(0 + ":");
//        print(0);

        print(-2);
        print(1);
        print(-1);
        print(-Integer.MAX_VALUE);
    }

    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print(((1 << i) & num) == 0 ? "0" : "1");
        }
        System.out.println();
    }
}
