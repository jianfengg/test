package com.test.main;

import java.util.LinkedList;

public class Test3 {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(1);
        list.add(2);
        list.add(3);
        TreeNode treeNode = createTreeNode(list);

        printVal(treeNode);

    }


    public static void printVal(TreeNode node) {
        if (null == node) {
            return;
        }

        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(node);

        while (!nodes.isEmpty()) {
            node = nodes.pop();

            System.out.print(node.val);


            if (node.left != null) {
                nodes.add(node.left);
            }


            if (node.right != null) {
                nodes.add(node.right);
            }

        }

    }


    public static TreeNode createTreeNode(LinkedList<Integer> list) {
        TreeNode node = null;
        if (list.isEmpty()) {
            return null;
        }
        Integer data = list.removeFirst();
        if (data != null) {
            node = new TreeNode(data);

            node.left = createTreeNode(list);
            node.right = createTreeNode(list);
        }

        return node;
    }

}
