package hackerrank.problemsolving.solutions.trees;

/*
    Problem:
    https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list/problem

    Solution:
    @author Karol Cichosz
 */

public class PreOrderTraversal {
    /* you only have to complete the function given below.
Node is defined as
*/
class Node {
    int data;
    Node left;
    Node right;
}



    void preOrder(Node root) {
        System.out.print(root.data + " ");
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        }
    }
}
