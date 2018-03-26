package com.solutions;

import java.util.Scanner;

public class CodePad01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] strArray = in.nextLine().split("\\s+");

        int[] array = new int[strArray.length];

        for (int i=0; i<strArray.length; i++) {
            array[i] = Integer.parseInt(strArray[i]);
        }

        int leftIndex=0;
        int rightIndex = array.length-1;
        int switchValue;

        while(leftIndex < rightIndex) {
            if (array[leftIndex]%2 == 1) {
                leftIndex++;
            } else {
                while((array[rightIndex]%2 == 0) && (leftIndex < rightIndex)) {
                    rightIndex--;
                }
                if (leftIndex < rightIndex) {
                    switchValue = array[leftIndex];
                    array[leftIndex] = array[rightIndex];
                    array[rightIndex] = switchValue;
                }

            }
        }

        for(int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }
}
