package hackerrank.problemsolving.solutions.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
    Problem:
    https://www.hackerrank.com/challenges/arrays-ds/problem

    Solution:
    @author Karol Cichosz

 */

public class ArraysDS {

    /*
     * Complete the reverseArray function below.
     */
    static int[] reverseArray(int[] a) {
        int rightBorder = (int)Math.floor(((float)a.length)/2);
        int tempValue;
        for (int i=0; i<rightBorder; i++) {
            tempValue = a[a.length-1-i];
            a[a.length-1-i] = a[i];
            a[i] = tempValue;
        }

        return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(scanner.nextLine().trim());

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");

        for (int arrItr = 0; arrItr < arrCount; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
            arr[arrItr] = arrItem;
        }

        int[] res = reverseArray(arr);

        for (int resItr = 0; resItr < res.length; resItr++) {
            bufferedWriter.write(String.valueOf(res[resItr]));

            if (resItr != res.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
