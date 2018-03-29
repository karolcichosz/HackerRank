package hackerrank.problemsolving.solutions.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    Problem:
    https://www.hackerrank.com/challenges/dynamic-array/problem

    Solution:
    @author Karol Cichosz
 */

public class DynamicArray {

    /*
     * Complete the dynamicArray function below.
     */
    static int[] dynamicArray(int n, int[][] queries) {
            List<List<Integer>> solutions = new ArrayList<>();

            for (int i=0; i<n; i++) {
                solutions.add(new ArrayList<>());
            }

            List<Integer> result = new ArrayList<>();
            int queryType;
            int x, y, lastAnswer = 0;
            int seq;

            for (int i=0; i<queries.length; i++) {
                queryType = queries[i][0];
                x = queries[i][1];
                y = queries[i][2];

                seq = (x^lastAnswer)%n;
                if (queryType == 1) {
                    solutions.get(seq).add(y);
                } else {
                    lastAnswer = solutions.get(seq).get(y%solutions.get(seq).size());
                    result.add(lastAnswer);
                }
            }

            return result.stream().mapToInt(i -> i).toArray();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nq[0].trim());

        int q = Integer.parseInt(nq[1].trim());

        int[][] queries = new int[q][3];

        for (int queriesRowItr = 0; queriesRowItr < q; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 3; queriesColumnItr++) {
                int queriesItem = Integer.parseInt(queriesRowItems[queriesColumnItr].trim());
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = dynamicArray(n, queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
