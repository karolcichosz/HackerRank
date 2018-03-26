package hackerrank.problemsolving.solutions.linkedlist;

/*
    Problem:
    https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list/problem

    Solution:
    @author Karol Cichosz
 */

public class InsertNodeAtTheHead {
    /*
  Insert Node at the beginning of a linked list
  head pointer input could be NULL as well for empty list
  Node is defined as
  */
  class Node {
     int data;
     Node next;
  }

// This is a "method-only" submission.
// You only need to complete this method.

    Node Insert(Node head,int x) {
        Node newHead = new Node();
        newHead.data = x;
        newHead.next = head;

        return newHead;
    }

}
