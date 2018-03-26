package hackerrank.problemsolving.solutions.arrays;

import java.util.HashMap;
import java.util.Scanner;

/*
    Problem:
    https://www.hackerrank.com/challenges/sparse-arrays/problem

    Solution:
    @author Karol Cichosz
 */

public class SparseArrays {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfStrings = Integer.parseInt(in.nextLine());

        HashMap<String,Integer> stringMap = new HashMap<>();
        String currentString;

        for (int i=0; i<numOfStrings; i++) {
            currentString = in.nextLine();
            if (stringMap.containsKey(currentString)) {
                stringMap.put(currentString,stringMap.get(currentString)+1);
            } else {
                stringMap.put(currentString,1);
            }
        }

        int numOfQueries = Integer.parseInt(in.nextLine());
        String currentQuery;
        for (int i=0; i<numOfQueries; i++) {
            currentQuery = in.nextLine();

            if (stringMap.containsKey(currentQuery)) {
                System.out.println(stringMap.get(currentQuery));
            } else {
                System.out.println(0);
            }
        }
     }
}
