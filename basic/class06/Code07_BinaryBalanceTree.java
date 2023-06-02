package basic.class06;

public class Code07_BinaryBalanceTree {
    public boolean isBalanced(TreeNode root) {
        return process(root).isBalance;
    }

    public Info process(TreeNode root) {
        Info info = new Info();
        if(root == null) {
            info.depth = 0;
            info.isBalance = true;
            return info;
        }

        Info left = process(root.left);
        Info right = process(root.right);

        info.depth =  Math.max(left.depth, right.depth) + 1;
        info.isBalance = left.isBalance && right.isBalance && Math.abs(left.depth - right.depth) <= 1;
        return info;
    }

    public static class Info {

        public boolean isBalance;
        public int depth;

        public Info() {
        }

        public Info(boolean isBalance, int depth) {
            this.isBalance = isBalance;
            this.depth = depth;
        }
    }
}
