package hackerrank.problemsolving.solutions.trees;

/*
    Problem:
    https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem

    Solution:
    @author Karol Cichosz
 */

public class InsertionInBST {
     /* Node is defined as : */
 class Node {
         int data;
         Node left;
         Node right;
     }

     Node Insert(Node root,int value) {
        if (root == null) {
            root = new Node();
            root.data = value;
            root.left = root.right = null;
        } else if (root.data > value){
            root.left = Insert(root.left,value);
        } else if (root.data < value) {
            root.right = Insert(root.right,value);
        }

        return root;
    }



}
