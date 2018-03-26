package hackerrank.problemsolving.solutions.linkedlist;

/*
    Problem:
    https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/problem

    Solution:
    @author Karol Cichosz
 */

public class InsertNodeOnATail {
    /*
  Insert Node at the end of a linked list
  head pointer input could be NULL as well for empty list
  Node is defined as
  */
  class Node {
     int data;
     Node next;
  }

    Node Insert(Node head,int data) {
// This is a "method-only" submission.
// You only need to complete this method.
        Node helpNode = head;
        while(helpNode.next != null) {
            helpNode = helpNode.next;
        }

        helpNode.next = new Node();
        helpNode.next.data = data;

        return head;
    }

}
