package hackerrank.problemsolving.solutions.linkedlist;

/*
    Problem:
    https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail/problem

    Solution:
    @Karol Cichosz
 */

public class GetValueFromEnd {
    /*
  Get Nth element from the end in a linked list of integers
  Number of elements in the list will always be greater than N.
  Node is defined as
  */
  class Node {
     int data;
     Node next;
  }


    int GetNode(Node head,int n) {
        // This is a "method-only" submission.
        // You only need to complete this method.

        Node leftNode, rightNode;
        leftNode = rightNode = head;

        for (int i=0; i<n; i++) {
            rightNode = rightNode.next;
        }

        while (rightNode.next != null) {
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }

        return leftNode.data;
    }

}
