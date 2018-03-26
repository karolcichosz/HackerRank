package hackerrank.problemsolving.solutions.linkedlist;

/*
    Problem:
    https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list/problem

    Solution:
    @author Karol Cichosz
 */

public class DeleteNode {
    /*
  Delete Node at a given position in a linked list
  head pointer input could be NULL as well for empty list
  Node is defined as
  */
  class Node {
     int data;
     Node next;
  }

    // This is a "method-only" submission.
    // You only need to complete this method.

    Node Delete(Node head, int position) {
        // Complete this method

        if (position == 0) {
            head = head.next;
        } else {
            int index = 1;
            Node prevIndex = head;
            while (index++ < position) {
                prevIndex = prevIndex.next;
            }
            prevIndex.next = prevIndex.next.next;
        }

        return head;
    }


}
