package basic.class06;

import basic.utils.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

public class Code05_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        HashMap<Integer, Integer> rootIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            rootIndexMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, rootIndexMap);
    }

    public TreeNode buildTree(int[] preorder, int L1, int R1, int[] inorder, int L2, int R2, HashMap<Integer, Integer> rootIndexMap) {
        if (L1 < 0 || L2 < 0 || L1 > R1 || L2 > R2 || R1 > preorder.length - 1 || R2 > inorder.length - 1) {
            return null;
        }

        if (L1 == R1 || L2 == R2) {
            return new TreeNode(preorder[L1]);
        }

        int rootIn = rootIndexMap.get(preorder[L1]);

        return new TreeNode(
                preorder[L1],
                buildTree(preorder, L1 + 1, L1 + rootIn - L2, inorder, L2, rootIn - 1, rootIndexMap),
                buildTree(preorder, L1 + rootIn - L2 + 1, R1, inorder, rootIn + 1, R2, rootIndexMap)
        );
    }

    public static void main(String[] args) {
        int[] pre = new int[]{3, 9, 20, 15, 7};
        int[] in = new int[]{9, 3, 15, 20, 7};

        new Code05_ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(pre, in);
    }
}
