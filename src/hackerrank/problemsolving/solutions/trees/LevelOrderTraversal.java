package hackerrank.problemsolving.solutions.trees;

import java.util.LinkedList;
import java.util.Queue;

/*
    Problem:
    https://www.hackerrank.com/challenges/tree-level-order-traversal/problem

    Solution:
    @author Karol Cichosz
 */

public class LevelOrderTraversal {


 class Node {
     int data;
     Node left;
     Node right;
 }

    void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node currentNode;

        while(!queue.isEmpty()) {
            currentNode = queue.remove();

            System.out.print(currentNode.data + " ");

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }

}
