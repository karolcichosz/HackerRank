package hackerrank.problemsolving.solutions.linkedlist;

public class RemoveDuplicates {
/*
Node is defined as
*/
  class Node {
     int data;
     Node next;
  }


    Node RemoveDuplicates(Node head) {
        // This is a "method-only" submission.
        // You only need to complete this method.

        Node leftNode, rightNode;
        leftNode = head;
        rightNode = head.next;

        while(rightNode != null) {
            if (leftNode.data != rightNode.data) {
                leftNode.next = rightNode;
                leftNode = rightNode;
            }
            rightNode = rightNode.next;
        }

        leftNode.next = null;

        return head;
    }

}
