package com.company;

import sun.awt.util.IdentityLinkedList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.next();

        LinkedList<Character> revertList = new LinkedList<>();
        HashMap<Integer,Character> specialSigns = new HashMap<>();


        char[] lineArray = line.toCharArray();
        for(int i=0; i<lineArray.length; i++) {
            if (!isSpecialChar(lineArray[i])) {
                revertList.addFirst(lineArray[i]);
            } else {
                specialSigns.put(i,lineArray[i]);
            }
        }

        Iterator<Character> it = revertList.iterator();
        for(int i=0; i<lineArray.length; i++) {
            if (specialSigns.containsKey(i)) {
                System.out.print(specialSigns.get(i));
            } else {
                System.out.print(it.next());
            }
        }

        System.out.println("");
    }

    private static boolean isSpecialChar(char c) {
        Pattern regex = Pattern.compile("[^A-Za-z0-9]");

        Matcher m = regex.matcher(new String(new char[]{c}));

        return m.find();
    }
}
