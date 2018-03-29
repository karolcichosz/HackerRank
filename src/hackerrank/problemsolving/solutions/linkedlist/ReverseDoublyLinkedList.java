package hackerrank.problemsolving.solutions.linkedlist;

/*
    Problem:
    https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem

    Solution:
    @author Karol Cichosz

 */

public class ReverseDoublyLinkedList {
    /*
  Insert Node at the end of a linked list
  head pointer input could be NULL as well for empty list
  Node is defined as
  */
  class Node {
     int data;
     Node next;
     Node prev;
  }


    Node Reverse(Node head) {
        if (head == null) {
            return head;
        }
        Node firstNode = head;
        Node secondNode = head.next;

        while(secondNode != null) {
            firstNode.next = firstNode.prev;
            firstNode.prev = secondNode;
            firstNode = secondNode;
            secondNode = secondNode.next;
        }

        firstNode.next = firstNode.prev;
        firstNode.prev = null;

        return firstNode;
    }
}
