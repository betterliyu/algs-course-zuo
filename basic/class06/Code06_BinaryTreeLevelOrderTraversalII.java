package basic.class06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code06_BinaryTreeLevelOrderTraversalII {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        queue.add(root);
        int times = 1;
        while (!queue.isEmpty()) {
            List<Integer> group = new ArrayList<>();
            for (int i = 0; i < times; i++) {
                TreeNode current = queue.poll();
                if (current == null) {
                    break;
                }
                group.add(current.val);

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            res.add(0, group);
            times = queue.size();
        }

        return res;
    }
}
