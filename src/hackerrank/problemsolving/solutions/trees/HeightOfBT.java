package hackerrank.problemsolving.solutions.trees;

/*
    Problem:
    https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem

    Solution:
    @author Karol Cichosz
 */

public class HeightOfBT {
    class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static int height(Node root) {
        // Write your code here.
        return findMaxHight(0,root);
    }

    static int findMaxHight(int previousMaxHeight, Node node) {
        int leftResult = -1;
        int rightResult = -1;

        if (node.left != null) {
            leftResult = findMaxHight(previousMaxHeight + 1, node.left);
        }

        if (node.right != null) {
            rightResult = findMaxHight(previousMaxHeight + 1, node.right);
        }

        return Math.max(previousMaxHeight,Math.max(leftResult, rightResult));
    }

}
