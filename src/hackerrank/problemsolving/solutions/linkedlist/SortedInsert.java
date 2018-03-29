package hackerrank.problemsolving.solutions.linkedlist;

/*
    Problem:
    https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem

    Solution:
    @author Karol Cichosz
 */

public class SortedInsert {
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

    Node SortedInsert(Node head,int data) {
      if (head == null) {
          head = new Node();
          head.data = data;
          return head;
      }

      Node newNode;
      if (head.data >= data) {
          newNode = new Node();
          newNode.data = data;
          newNode.next = head;
          head.prev = newNode;
          return newNode;
      }

      Node node = head;
      while(node.next != null && node.next.data < data) {
          node = node.next;
      }

        newNode = new Node();
        newNode.data = data;
      if (node.next == null) {
          newNode.prev = node;
          node.next = newNode;
      } else {
          node.next.prev = newNode;
          newNode.next = node.next;
          newNode.prev = node;
          node.next = newNode;
      }

      return head;
    }

}
