package hackerrank.problemsolving.solutions.linkedlist;

/*
    Problem:
    https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem

    Solution:
    @author Karol Cichosz
 */

public class InsertNodeAtSpecPosition {
    /*
  Insert Node at a given position in a linked list
  head can be NULL
  First element in the linked list is at position 0
  Node is defined as
  */
  class Node {
     int data;
     Node next;
  }



    Node InsertNth(Node head, int data, int position) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        Node newNode = new Node();
        newNode.data = data;

        if (position == 0) {
            newNode.next = head;
            return newNode;
        } else {
            int index = 1;
            Node prevNode = head;

            while (index++ < position) {
                prevNode = prevNode.next;
            }

            newNode.next = prevNode.next;
            prevNode.next = newNode;

            return head;
        }
    }

}
