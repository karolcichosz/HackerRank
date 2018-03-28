package hackerrank.problemsolving.solutions.linkedlist;

/*
    Problem:
    https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem

    Solution:
    @author Karol Cichosz
 */

import java.util.HashSet;
import java.util.Set;

public class FindMergeNode {
    /*
  Find merge point of two linked lists
  head pointer input could be NULL as well for empty list
  Node is defined as
  */
  class Node {
     int data;
     Node next;
  }

    int FindMergeNode(Node headA, Node headB) {
        // Complete this function
        // Do not write the main method.

        Node firstList = headA;
        Node secondList = headB;

        Set<Integer> visitedNodes = new HashSet<>();

        visitedNodes.add(firstList.data);
        visitedNodes.add(secondList.data);

        firstList = firstList.next;
        secondList = secondList.next;

        while(firstList != null && secondList != null) {
            if (isMergeNodeFound(firstList,visitedNodes)) {
                return firstList.data;
            }

            if (isMergeNodeFound(secondList,visitedNodes)) {
                return secondList.data;
            }

            firstList = firstList.next;
            secondList = secondList.next;
        }

        Node lastList;

        if (firstList == null) {
            lastList = secondList;
        } else {
            lastList = firstList;
        }

        while (lastList != null) {
            if (isMergeNodeFound(lastList,visitedNodes)) {
                return lastList.data;
            }

            lastList = lastList.next;
        }

        return Integer.MIN_VALUE;
    }

    boolean isMergeNodeFound(Node node, Set<Integer> visitedNodes) {
        if (visitedNodes.contains(node.data)) {
            return true;
        } else {
            visitedNodes.add(node.data);
            return false;
        }
    }

}
