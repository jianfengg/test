package com.test.datastructure.tree;

/**
 * @author gjf
 * @description
 * @date 2022/8/15  19:40
 */
public class Solution {

    public static void main(String[] args) {

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val > val) {

            root.left = insertIntoBST(root.left, val);

        } else {

            root.right = insertIntoBST(root.right, val);

        }

        return root;

    }

}
