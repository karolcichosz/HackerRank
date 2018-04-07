package hackerrank.problemsolving.solutions.queues;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/*
    Problem:
    https://www.hackerrank.com/challenges/truck-tour/problem

    Solution:
    @author Karol Cichosz
 */

public class TrackTour {

    /*
     * Complete the truckTour function below.
     */
    static int truckTour(int[][] petrolpumps) {
        int pretender = 0;

        List<List<Integer>> petrolList = new ArrayList<>();
        int currentPetrolScore = petrolpumps[0][0]-petrolpumps[0][1];

        boolean petrolIndex = (currentPetrolScore >= 0) ? true : false;

        petrolList.add(new ArrayList<Integer>());
        int currentPetrol = 0;

        petrolList.get(0).add(currentPetrol);
        petrolList.get(0).add(currentPetrolScore);

        for (int i=1; i<petrolpumps.length; i++) {
            currentPetrolScore = petrolpumps[i][0]-petrolpumps[i][1];

            if ((currentPetrolScore >= 0) == petrolIndex) {
                petrolList.get(petrolList.size()-1).set(1,petrolList.get(petrolList.size()-1).get(1) + currentPetrolScore);
            } else {
                petrolList.add(new ArrayList<Integer>());
                petrolList.get(petrolList.size()-1).add(i);
                petrolList.get(petrolList.size()-1).add(currentPetrolScore);
                petrolIndex = petrolIndex ? false : true;
            }
        }

        petrolList.get(0).add(petrolList.get(0).get(1));
        int smallestVal = petrolList.get(0).get(1);

        for (int i=1; i<petrolList.size(); i++) {
            petrolList.get(i).add(petrolList.get(i-1).get(2)+ petrolList.get(i).get(1));

            smallestVal = Math.min(smallestVal,petrolList.get(i).get(2));
        }

        boolean resultFound = false;

        for (int i=0; !resultFound && i<petrolList.size(); i++) {
            if (petrolList.get(i).get(2) - smallestVal <= petrolList.get(i).get(1)) {
                pretender = petrolList.get(i).get(0);
                resultFound = true;
            }
        }

    return pretender;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] petrolpumps = new int[n][2];

        for (int petrolpumpsRowItr = 0; petrolpumpsRowItr < n; petrolpumpsRowItr++) {
            String[] petrolpumpsRowItems = scanner.nextLine().split(" ");

            for (int petrolpumpsColumnItr = 0; petrolpumpsColumnItr < 2; petrolpumpsColumnItr++) {
                int petrolpumpsItem = Integer.parseInt(petrolpumpsRowItems[petrolpumpsColumnItr].trim());
                petrolpumps[petrolpumpsRowItr][petrolpumpsColumnItr] = petrolpumpsItem;
            }
        }

        int result = truckTour(petrolpumps);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
