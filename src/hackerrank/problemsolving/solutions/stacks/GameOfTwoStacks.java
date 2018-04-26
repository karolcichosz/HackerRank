package hackerrank.problemsolving.solutions.stacks;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
    Problem:
    https://www.hackerrank.com/challenges/game-of-two-stacks/problem

    Solution:
    @author Karol Cichosz
 */

public class GameOfTwoStacks {

    /*
     * Complete the twoStacks function below.
     */
        static int twoStacks(int x, int[] a, int[] b) {
            /*
             * Write your code here.
             */

            int result = 0;
            int currentScore = 0;

            int i=0, j=0;

            while(i < a.length && currentScore + a[i] <= x) {
                currentScore += a[i];
                i++;
                result++;
            }

            while (j<b.length && currentScore + b[j] <= x) {
                currentScore += b[j];
                j++;
                result++;
            }

            if (j==b.length || i==0) {
                return result;
            }

            int currentResult = result;
            while(--i >= 0) {
                currentScore -= a[i];
                currentResult--;
                while (j<b.length && currentScore + b[j] <= x) {
                    currentScore += b[j];
                    j++;
                    currentResult++;
                }
                result = Math.max(result, currentResult);
                if (j==b.length) {
                    return result;
                }
            }

            return result;
        }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            String[] nmx = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmx[0].trim());

            int m = Integer.parseInt(nmx[1].trim());

            int x = Integer.parseInt(nmx[2].trim());

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");

            for (int aItr = 0; aItr < n; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr].trim());
                a[aItr] = aItem;
            }

            int[] b = new int[m];

            String[] bItems = scanner.nextLine().split(" ");

            for (int bItr = 0; bItr < m; bItr++) {
                int bItem = Integer.parseInt(bItems[bItr].trim());
                b[bItr] = bItem;
            }

            int result = twoStacks(x, a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}

