/*
题目描述
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
*/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length != in.length){ // mismatching of pre and in
            return null;
        }
        return helper(pre, in, 0, 0, pre.length);
    }
    private TreeNode helper(int[] pre, int[] in, int preStart, int inStart, int len){
        if (len <= 0){
            return null;
        }
        TreeNode node = new TreeNode(pre[preStart]);
        int mid = 0;
        for (int i = inStart; i < inStart + len; i++){
            if (pre[preStart] == in[i]){
                mid = i;
            }
        }
        node.left = helper(pre, in, preStart + 1, inStart, mid - inStart);
        node.right = helper(pre, in, preStart + mid - inStart + 1, mid + 1, inStart + len - mid - 1);
        return node;
    }
}
