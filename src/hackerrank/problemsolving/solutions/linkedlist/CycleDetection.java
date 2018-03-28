package hackerrank.problemsolving.solutions.linkedlist;

/*
    Problem:
    https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem

    Solution:
    @author Karol Cichosz
 */

public class CycleDetection {
    /*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as:
*/
    class Node {
        int data;
        Node next;
    }

    boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node leftNode = head;
        Node rightNode = head.next;

        while (leftNode != null && rightNode.next != null) {
            if (leftNode == rightNode) {
                return true;
            }

            leftNode = leftNode.next;
            //rightNode reference moves faster then leftNode one.
            //if there exist a loop they will meet
            rightNode = rightNode.next.next;
        }

        return false;
    }

}
