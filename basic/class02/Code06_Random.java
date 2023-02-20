package basic.class02;

/**
 * 求数组指定范围的和
 */
public class Code06_Random {

    // 将生成[0， x)之间的数的概率 x 改为 x^2

    /**
     * 生成随机数，随机数在[0, x)区间的概率为 x^2
     * <p>
     * 第一次随机数满足条件的概率为 x，第二次的概率也是 x，两次都满足的条件即为 x^2
     *
     * @return 随机数
     */
    public static double randomXByPow2() {
        return Math.max(Math.random(), Math.random());
    }

    ////////////////////////////////////////
    // 使用[1, 5]之间整数等概率随机数生成器，创建[3, 8]之间整数等概率随机数生成器，不可以使用其他随机数函数

    public static int random1_5() {
        return (int) (Math.random() * 5) + 1;
    }

    // 0 或 1 等概率生成器
    public static int random0Or1() {
        int num = 0;
        do {
            num = random1_5();
        } while (num == 3);
        return num < 3 ? 0 : 1;
    }

    // 0 ~ 7
    public static int random0_7() {
        // 三位二进制 每一位等概率随机出现 0 或 1，000 ~ 111 每个数出现概率 为  1/2 * 1/2 * 1/2 = 1/8
        return (random0Or1() << 2) + (random0Or1() << 1) + (random0Or1() << 0);
    }

    // [3, 8]之间整数等概率随机数生成器
    public static int random3_8() {

        int ran = 0;
        // 0 ~ 5
        // 如果大于5，重新随机，则 0 ~ 5 随机出现的概率为 1/8 + ( 2/8/6) = 1/6
        do {
            ran = random0_7();
        } while (ran > 5);

        // 3 ~ 8
        return ran + 3;
    }


    // 0 1 不等概率随机 =》 0 1 等概率随机
    public static int randomUnequalProbability0_1() {
        return Math.random() > 0.76 ? 1 : 0;
    }

    /**
     * 等概率返回0 1
     * 执行两次，一共有四种结果  00，01，10，,11    01 10 的概率相等
     * 得到 00 11 的结果时重新计算，这样就只会有 10 01 两种情况，概率相等
     * @return
     */
    public static int randomEqualProbability0_1() {
        int num = 0;
        do {
            num = randomUnequalProbability0_1();
        } while (num == randomUnequalProbability0_1());
        return num;
    }


    public static void main(String[] args) {
        int times = 1000000;


        System.out.println("=======将生成[0， x)之间的数的概率 x 改为 x^2=======");

        int count = 0;
        for (int i = 0; i < times; i++) {
            if (randomXByPow2() < 0.3) {
                count++;
            }
        }
        System.out.println("出现在[0, 0.3)的概率为：" + ((double) count / (double) times));


        System.out.println("");
        System.out.println("=======使用[1, 5]之间整数等概率随机数生成器，创建[0, 7]之间整数等概率随机数生成器=======");
        int[] counts = new int[5];
        for (int i = 0; i < times; i++) {
            counts[random1_5() - 1]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println("出现" + (i + 1) + "的概率为：" + ((double) counts[i] / (double) times));
        }

        System.out.println("=======0 1 等概率生成器=======");
        counts = new int[2];
        for (int i = 0; i < times; i++) {
            counts[random0Or1()]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println("出现" + i + "的概率为：" + ((double) counts[i] / (double) times));
        }

        System.out.println("=======0~7 等概率生成器=======");
        counts = new int[8];
        for (int i = 0; i < times; i++) {
            counts[random0_7()]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println("出现" + (i + 1) + "的概率为：" + ((double) counts[i] / (double) times));
        }

        System.out.println("=======3~8 等概率生成器=======");
        counts = new int[6];
        for (int i = 0; i < times; i++) {
            counts[random3_8() - 3]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println("出现" + (i + 3) + "的概率为：" + ((double) counts[i] / (double) times));
        }

        System.out.println("出现在[0, 0.3)的概率为：" + ((double) count / (double) times));


        System.out.println("");
        System.out.println("=======0,1 不等概率生成器 转为 0 1 等概率生成器=======");
        counts = new int[2];
        for (int i = 0; i < times; i++) {
            counts[randomEqualProbability0_1()]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println("出现" + i + "的概率为：" + ((double) counts[i] / (double) times));
        }

    }

}
