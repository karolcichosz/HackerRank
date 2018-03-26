package com.company;

import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.next();

        List<Integer> palindromeMidPoints = new ArrayList<>();
        palindromeMidPoints.add(0);

        int palindMidDistance;

        if (input.length()%2 == 1) {
            palindMidDistance = input.length()/2;
        } else {
            palindMidDistance = input.length()/2 - 1;
        }

        for (int i=1; i<=palindMidDistance; i++) {
            if (isPalindromeMid(input,i)) {
                palindromeMidPoints.add(i);
            }
        }

        Iterator<Integer> it = palindromeMidPoints.iterator();
        List<String> palindromeFrontAddOns = new ArrayList<>();

        while(it.hasNext()) {
            palindromeFrontAddOns.add(createPalindromeFrontAddOns(input,it.next()));
        }

        Iterator<String> itAddOns = palindromeFrontAddOns.iterator();

        String resultString = itAddOns.next();
        String currentPalindromeString;

        while(itAddOns.hasNext()) {
            currentPalindromeString = itAddOns.next();

            if (resultString.length() > currentPalindromeString.length()) {
                resultString = currentPalindromeString;
            }
        }

        System.out.println(resultString.length());
    }

    private static String createPalindromeFrontAddOns(String input, Integer index) {
        char[] charArray = input.substring(2*index+1).toCharArray();

        String result = "";

        for (int i=charArray.length-1; i>=0; i--) {
            result += charArray[i];
        }

        return result;
    }

    private static boolean isPalindromeMid(String input, int i) {
        return isPalindromeMid(input, i-1,i+1);
    }

    private static boolean isPalindromeMid(String input, int leftIndex, int rightIndex) {
        if (leftIndex < 0) {
            return true;
        }

        if (input.charAt(leftIndex) == input.charAt(rightIndex)) {
            return isPalindromeMid(input, leftIndex-1, rightIndex+1);
        } else {
            return false;
        }
    }
}
