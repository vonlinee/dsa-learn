package question.leetcode.problem;

import question.leetcode.LeetCode.TreeNode;

/**
 * https://leetcode.cn/problems/subtree-of-another-tree/
 * @author vonline
 * @since 2022-07-13 19:32
 */
public class P572_SubtreeOfAnotherTree {

//1先思考有几种情况
//1.1 两颗树一开始就相等 从第一个节点开始
//1.2 从左节点开始
//1.3从右节点开始
//    如果子树为null直接返回true
//    如果有一个树是null 另一个也是 true 否则 false

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return isSubroot(root, subRoot);
    }

    public boolean isSubroot(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (t == null) return true;
        return isRoot(s, t) || isSubroot(s.right, t) || isSubroot(s.left, t);
    }

    public boolean isRoot(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isRoot(s.left, t.left) && isRoot(s.right, t.right);
    }

    /**
     * 将树按先序方式序列化
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree_KMP(TreeNode root, TreeNode subRoot) {
        return false;
    }
}