package hackerrank.problemsolving.solutions.trees.binarysearchtree;

/*
    Problem:
    https://www.hackerrank.com/challenges/is-binary-search-tree/problem

    Solution:
    @author Karol Cichosz
 */

public class IsItBST {
/*The Node class is defined as follows:
*/
    class Node {
        int data;
        Node left;
        Node right;
     }

    boolean checkBST(Node root) {
        int leftBoundary = Integer.MIN_VALUE;
        int rightBoundary = Integer.MAX_VALUE;

        if (root == null) {
            return true;
        }

        return checkBST(root.left, leftBoundary, root.data) && checkBST(root.right, root.data, rightBoundary);
    }

    boolean checkBST(Node node, int leftIndex, int rightIndex) {
        if (node == null) {
            return true;
        }

        if (node.data <= leftIndex || node.data >= rightIndex) {
            return false;
        }

        return checkBST(node.left, leftIndex, node.data) && checkBST(node.right, node.data, rightIndex);
    }

}
