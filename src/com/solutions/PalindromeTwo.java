package com.solutions;

import java.util.*;


public class PalindromeTwo {

    static String changeCharInPosition(int position, char ch, String str){
        char[] charArray = str.toCharArray();
        charArray[position] = ch;
        return new String(charArray);
    }

    static String richieRich(String s, int n, int k){
        int lengthDelta = n-s.length();

        if (lengthDelta > 0) {
            for (int i=0; i<lengthDelta; i++) {
                s = "0" + s;
            }
        }

        int[] palindromeIndicator = new int[s.length()/2];
        int numOfDiffs = 0;

        // 1231 => 10<-->01   => 1331 => 1221
        for (int i=0; i<n/2; i++) {
            if (s.charAt(i) == s.charAt(n-1-i)) {
                palindromeIndicator[i] = 1;
            } else {
                numOfDiffs++;
            }

        }

        if (numOfDiffs > k) {
            return "-1";
        }

        for(int i=0; i<n/2; i++) {
            if (palindromeIndicator[i] == 0 && k > numOfDiffs && (s.charAt(i) != '9' && s.charAt(s.length()-1-i) != '9')) {
                palindromeIndicator[i] = 1;
                s = changeCharInPosition(i,'9',s);
                k -= 2;
                numOfDiffs--;
            }
        }

        String result = "";

        for (int i=0; i<n/2; i++) {
            if (palindromeIndicator[i] == 1) {
                result += s.charAt(i);
            } else {
                if (s.charAt(i) > s.charAt(s.length()-1-i)) {
                    result += s.charAt(i);
                } else {
                    result += s.charAt(s.length()-1-i);
                }
            }
        }

        if (n%2>0) {
            if (k>numOfDiffs) {
                result += "9";
            } else {
                result += s.charAt(n/2+1);
            }
        }

        for (int i=n/2-1; i>=0; i--) {
            result += result.charAt(i);
        }

        return result;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        String result = richieRich(s, n, k);
        System.out.println(result);
    }
}
