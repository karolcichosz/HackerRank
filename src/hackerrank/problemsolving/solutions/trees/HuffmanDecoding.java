package hackerrank.problemsolving.solutions.trees;

/*
    Problem:
    https://www.hackerrank.com/challenges/tree-huffman-decoding/problem

    Solution:
    @author Karol Cichosz
 */

public class HuffmanDecoding {

   class Node {
       public int frequency; // the frequency of this tree
       public char data;
       public Node left, right;
   }

    void decode(String S ,Node root) {
        int strPointer = 0;
        Node currentNode = root;
        char currentCode;

        while(strPointer < S.length()) {
            currentCode = S.charAt(strPointer);

            if (currentCode == '0') {
                if (currentNode.left != null) {
                    currentNode = currentNode.left;
                    if (currentNode.left == null && currentNode.right == null) {
                        System.out.print(currentNode.data);
                        currentNode = root;
                    }
                }
            } else {
                if (currentNode.right != null) {
                    currentNode = currentNode.right;
                    if (currentNode.left == null && currentNode.right == null) {
                        System.out.print(currentNode.data);
                        currentNode = root;
                    }
                }
            }
            strPointer++;
        }
    }

}
