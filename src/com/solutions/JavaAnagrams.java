package com.solutions;

import java.util.*;

public class JavaAnagrams {

    static boolean isAnagram(String a, String b) {
        LinkedList<Character> alist = new LinkedList<>();

        for(char c : a.toLowerCase().toCharArray()) {
            alist.add(c);
        }

        String bLowerCase = new String(b.toLowerCase());

        Character bChar;
        for (int i=0; i<b.length(); i++) {
            bChar = new Character(bLowerCase.charAt(i));

            if (!alist.removeFirstOccurrence(bChar)) {
                return false;
            }
        }

        if (alist.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
