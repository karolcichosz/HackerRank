package com.solutions;

import java.util.Scanner;

public class ClockChanger {

    static String timeConversion(String s) {


        String hour = s.substring(0,1);
    String minAndSec = s.substring(3,s.length()-2);

        if (s.charAt(s.length()-2) == 'A') {
        if (hour.equals("12")) {
            hour = "00";
        }
    } else {
        if (!hour.equals("12")) {
            hour = new String(new Integer(Integer.parseInt(hour)+12).toString());
        }
    }

        return hour+":"+minAndSec;
}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
