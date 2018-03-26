package hackerrank.problemsolving.solutions.strings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
    Problem:
    https://www.hackerrank.com/challenges/java-string-compare/problem

    Solution:
    @author Karol Cichosz
 */

public class JavaSubstringComparisons {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        if (k<=0) {
            largest = s;
        } else
            if (s.length() < k) {
                smallest = largest = s;
            } else {

            // Complete the function
            // 'smallest' must be the lexicographically smallest substring of length 'k'
            // 'largest' must be the lexicographically largest substring of length 'k'

            List<String> substrings = new ArrayList<>();

            for (int i = 0; i < s.length() - k+1; i++) {
                substrings.add(s.substring(i,i+k));
            }

            Iterator<String> it = substrings.iterator();
            String currentSubstring;

            if (it.hasNext()) {
                currentSubstring = it.next();
                smallest = new String(currentSubstring);
                largest = new String(currentSubstring);
            }

            while(it.hasNext()) {
                currentSubstring = it.next();

                if (smallest.compareTo(currentSubstring) > 0) {
                    smallest = new String(currentSubstring);
                }

                if (largest.compareTo(currentSubstring) < 0) {
                    largest = new String(currentSubstring);
                }
            }

        }
        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
