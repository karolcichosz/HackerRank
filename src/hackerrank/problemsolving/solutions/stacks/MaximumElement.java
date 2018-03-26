package hackerrank.problemsolving.solutions.stacks;

import java.util.Scanner;
import java.util.Stack;

/*
    Problem:
    https://www.hackerrank.com/challenges/maximum-element/problem

    Solution:
    @Karol Cichosz
 */

public class MaximumElement {

        private static class StackNode {
            public Integer element;
            public Integer currentMax;

            public StackNode(Integer element, Integer currentMax) {
                this.element = element;
                this.currentMax = currentMax;
            }
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int lineCounter = in.nextInt();
            int type;
            int elementNum;
            int lastMax;
            Stack<StackNode> stack = new Stack<>();

            for (int i=0; i<lineCounter; i++) {
                type = in.nextInt();
                switch(type) {
                    case 1:
                        elementNum = in.nextInt();

                        if (stack.empty()) {
                            stack.push(new StackNode(elementNum,elementNum));
                        } else {
                            lastMax = stack.peek().currentMax;
                            if (lastMax < elementNum) {
                                lastMax = elementNum;
                            }
                            stack.push(new StackNode(elementNum,lastMax));
                        }
                        break;

                    case 2:
                        stack.pop();
                        break;

                    case 3:
                        System.out.println(stack.peek().currentMax);
                        break;
                }
            }
         }
}
