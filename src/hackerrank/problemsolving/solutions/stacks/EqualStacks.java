package hackerrank.problemsolving.solutions.stacks;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/*
    Problem:
    https://www.hackerrank.com/challenges/equal-stacks/problem

    Solution:
    @author Karol Cichosz
 */


public class EqualStacks {

    private static Stack<Integer> getStack(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int value = 0;

        for(int i=array.length-1; i>=0; i--) {
            value += array[i];
            stack.push(value);
        }

        return stack;
    }

    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        int result =0;

        PriorityQueue<Stack<Integer>> queue = new PriorityQueue<>(3, new Comparator<Stack<Integer>>() {
            private Integer getMaxValue(Stack<Integer> stack) {
                if (stack == null || stack.empty()) {
                    return new Integer(0);
                } else {
                    return stack.peek();
                }
            }

            @Override
            public int compare(Stack<Integer> integers, Stack<Integer> t1) {
                return getMaxValue(t1).compareTo(getMaxValue(integers));
            }
        });

        queue.add(getStack(h1));
        queue.add(getStack(h2));
        queue.add(getStack(h3));

        boolean solutionFound = false;
        Iterator<Stack<Integer>> it;
        Integer s1, s2, s3;
        Stack<Integer> topStack, iteratedStack;
        do {
            it = queue.iterator();

            iteratedStack = it.next();
            s1 = iteratedStack.isEmpty() ? 0 : iteratedStack.peek();
            iteratedStack = it.next();
            s2 = iteratedStack.isEmpty() ? 0 : iteratedStack.peek();
            iteratedStack = it.next();
            s3 = iteratedStack.isEmpty() ? 0 : iteratedStack.peek();

            if (s1.equals(s2) && s2.equals(s3)) {
                result = s1;
                solutionFound = true;
            } else {
                topStack = queue.poll();
                topStack.pop();
                queue.add(topStack);
            }

        } while (!solutionFound);

        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
