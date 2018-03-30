package hackerrank.problemsolving.solutions.queues;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        Scanner scanner = new Scanner(System.in);
        int numOfOperations = scanner.nextInt();
        scanner.nextLine();
        for (int i=0; i<numOfOperations; i++) {
            String[] operation = scanner.nextLine().split(" ");

            switch (operation[0]) {
                case "1":
                    stack1.add(Integer.parseInt(operation[1]));
                    break;

                case "2":
                    if (stack2.empty()) {
                        while (!stack1.empty()) {
                            stack2.push(stack1.pop());
                        }
                    }
                    stack2.pop();
                    break;

                default:
                    if (stack2.empty()) {
                        while (!stack1.empty()) {
                            stack2.push(stack1.pop());
                        }
                    }
                    System.out.println(stack2.peek());
                    break;
            }
        }
    }
}
