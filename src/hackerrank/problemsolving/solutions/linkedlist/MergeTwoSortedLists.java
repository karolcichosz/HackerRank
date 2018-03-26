package hackerrank.problemsolving.solutions.linkedlist;

/*
    Problem:
    https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem

    Solution:
    @author Karol Cichosz
 */

public class MergeTwoSortedLists {
    /*
  Merge two linked lists
  head pointer input could be NULL as well for empty list
  Node is defined as
  */
  class Node {
     int data;
     Node next;
  }


    Node mergeLists(Node headA, Node headB) {
        // This is a "method-only" submission.
        // You only need to complete this method

        if (headA == null) {
            return headB;
        }

        if (headB == null) {
            return headA;
        }

        Node newHead, currentNode;

        if (headA.data < headB.data) {
            newHead = headA;
            headA = headA.next;
        } else {
            newHead = headB;
            headB = headB.next;
        }

        currentNode = newHead;

        while(headA != null && headB != null) {
            if (headA.data < headB.data) {
                currentNode.next = headA;
                headA = headA.next;
            } else {
                currentNode.next = headB;
                headB = headB.next;
            }
            currentNode = currentNode.next;
        }

        if (headA == null) {
            currentNode.next = headB;
        } else {
            currentNode.next = headA;
        }

        return newHead;
    }

}
