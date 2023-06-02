package basic.class06;

import basic.utils.ArrayUtils;

import java.util.Arrays;

public class Code05_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int L1, int R1, int[] inorder, int L2, int R2) {
        if (L1 < 0 || L2 < 0 || L1 > R1 || L2 > R2 || R1 > preorder.length - 1 || R2 > inorder.length - 1) {
            return null;
        }

        if (L1 == R1 || L2 == R2) {
            return new TreeNode(preorder[L1]);
        }

        int rootIn = L2;
        while (inorder[rootIn] != preorder[L1]) {
            rootIn++;
        }

        return new TreeNode(
                preorder[1],
                buildTree(preorder, L1 + 1, L1 + rootIn - L2, inorder, L2, rootIn - 1),
                buildTree(preorder, L1 + rootIn - L2 + 1, R1, inorder, rootIn + 1, R2)
        );
    }

    public static void main(String[] args) {
        int[] pre = new int[]{3, 9, 20, 15, 7};
        int[] in = new int[]{9, 3, 15, 20, 7};

        new Code05_ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(pre, in);
    }
}
