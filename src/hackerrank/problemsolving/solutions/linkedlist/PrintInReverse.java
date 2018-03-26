package hackerrank.problemsolving.solutions.linkedlist;

import java.util.Stack;

/*
    Problem:
    https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem

    Solution:
    @author Karol Cichosz
 */

public class PrintInReverse {
    /*
  Print elements of a linked list in reverse order
  head pointer input could be NULL as well for empty list
  Node is defined as
  */
  class Node {
     int data;
     Node next;
  }

    // This is a "method-only" submission.
    // You only need to complete this method.

    void ReversePrint(Node head) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        Node node = head;

        Stack<Integer> stack = new Stack<>();
        while(node != null) {
            stack.push(node.data);
            node = node.next;
        }

        while(!stack.empty()) {
            System.out.println(stack.pop());
        }

    }

}
