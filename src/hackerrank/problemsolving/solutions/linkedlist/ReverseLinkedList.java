package hackerrank.problemsolving.solutions.linkedlist;

/*
    Problem:
    https://www.hackerrank.com/challenges/reverse-a-linked-list/problem

    Solution:
    @author Karol Cichosz
 */
public class ReverseLinkedList {
    /*
  Reverse a linked list and return pointer to the head
  The input list will have at least one element
  Node is defined as
  */
  class Node {
     int data;
     Node next;
  }

    // This is a "method-only" submission.
    // You only need to complete this method.
    Node Reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node firstNode = head;
        Node secondNode = head.next;
        Node thirdNode = secondNode.next;

        firstNode.next = null;
        while (thirdNode != null) {
            secondNode.next = firstNode;
            firstNode = secondNode;
            secondNode = thirdNode;
            thirdNode = thirdNode.next;
        }
        secondNode.next = firstNode;

        return secondNode;
    }
}
