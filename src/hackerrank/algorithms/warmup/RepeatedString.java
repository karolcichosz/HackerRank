package hackerrank.algorithms.warmup;

import java.io.*;
import java.util.*;

/*
    Problem:
    https://www.hackerrank.com/challenges/counting-valleys/problem

    Solution:
    @author Karol Cichosz
 */

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long result = n / s.length();

        int[] aCounter = new int[s.length()];
        char[] sArray = s.toCharArray();
        int counter = 0;

        for(int i=0; i<aCounter.length; i++) {
            if (sArray[i] == 'a') {
                counter++;
            }
            aCounter[i] = counter;
        }

        result *= counter;

        int rest = (int)(n % s.length());
        if (rest > 0) {
            result += aCounter[rest-1];
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
