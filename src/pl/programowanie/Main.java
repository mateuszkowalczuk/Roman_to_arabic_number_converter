package pl.programowanie;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("ROMAN TO ARABIC NUMBER CONVERTER");
        System.out.println("--------------------------------");
        System.out.println("1. Roman to Arabic");
        System.out.println("2. Arabic to Roman");
        System.out.println("--------------------------------");
        System.out.print("What to convert?: ");
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean isTrue = true;
        String romanNumberToConvert = "";
        int arabicNumberToConvert = 0;

        while(choice == 0) {
            try {
                while (isTrue) {
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1 -> {
                            System.out.println();
                            System.out.println("ROMAN TO ARABIC");
                            System.out.print("Enter a number to convert: ");
                            Scanner romanConvert = new Scanner(System.in);
                            while(romanNumberToConvert.equals("")) {
                                romanNumberToConvert = romanConvert.nextLine();
                                char[] chars = romanNumberToConvert.toCharArray();
                                for (int i = 0; i < chars.length; i++) {
                                    switch (chars[i]){
                                        case 'M', 'D', 'C', 'L', 'X', 'V', 'I' -> System.out.print("");
                                        default -> {
                                            System.out.print("Incorrect character. Try again: ");
                                            romanNumberToConvert = "";
                                            i = chars.length;
                                        }
                                    }
                                }
                            }
                            isTrue = false;
                        }
                        case 2 -> {
                            System.out.println();
                            System.out.println("ARABIC TO ROMAN");
                            System.out.print("Enter a number to convert: ");
                            Scanner arabicConvert = new Scanner(System.in);
                            while(arabicNumberToConvert == 0) {
                                arabicNumberToConvert = arabicConvert.nextInt();
                                char[] chars = String.valueOf(arabicNumberToConvert).toCharArray();
                                for (int i = 0; i < chars.length; i++) {
                                    switch (chars[i]){
                                        case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'-> System.out.print("");
                                        default -> {
                                            System.out.print("Incorrect character. Try again: ");
                                            arabicNumberToConvert = 0;
                                            i = chars.length;
                                        }
                                    }
                                }
                            }
                            isTrue = false;
                        }
                        default -> {
                            System.out.print("Incorrect number. Try again: ");
                            choice = 0;
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.print("Incorrect character. Try again: ");
                scanner.next();
            }
        }

        int arabicResult = 0;
        StringBuilder romanResult = new StringBuilder();

        if (choice == 1) {
            char lastIndex = 0;
            char[] chars = romanNumberToConvert.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (i == 0) arabicResult += romanConvert(chars[i]);
                else if (lastIndex >= romanConvert(chars[i])) arabicResult += romanConvert(chars[i]);
                else arabicResult += romanConvert(chars[i]) - lastIndex * 2;
                lastIndex = romanConvert(chars[i]);
            }
            System.out.println("Roman " + romanNumberToConvert + " is arabic " + arabicResult);
        } else if (choice == 2){
            int sum = arabicNumberToConvert;
            while (sum != 0){
                romanResult.append(arabicConvert(sum));
                sum += arabicNumber(sum);
            }
            System.out.println("Arabic " + arabicNumberToConvert + " is roman " + romanResult);
        }
    }

    public static char romanConvert(char ch){
        char res;
        if (ch=='M') res = 1000;
        else if (ch=='D') res = 500;
        else if (ch=='C') res = 100;
        else if (ch=='L') res = 50;
        else if (ch=='X') res = 10;
        else if (ch=='V') res = 5;
        else res = 1;
        return res;
    }

    public static String arabicConvert(int sum){
        String res;
        if (sum >= 1000) res = "M";
        else if (sum >= 900) res = "CM";
        else if (sum >= 500) res = "D";
        else if (sum >= 400) res = "CD";
        else if (sum >= 100) res = "C";
        else if (sum >= 90) res = "XC";
        else if (sum >= 50) res = "L";
        else if (sum >= 40) res = "XL";
        else if (sum >= 10) res = "X";
        else if (sum >= 9) res = "IX";
        else if (sum >= 5) res = "V";
        else if (sum >= 4) res = "IV";
        else res = "I";
        return res;
    }

    public static int arabicNumber(int sum){
        int res = 0;
        if (sum >= 1000) res -= 1000;
        else if (sum >= 900) res -= 900;
        else if (sum >= 500) res -= 500;
        else if (sum >= 400) res -= 400;
        else if (sum >= 100) res -= 100;
        else if (sum >= 90) res -= 90;
        else if (sum >= 50) res -= 50;
        else if (sum >= 40) res -= 40;
        else if (sum >= 10) res -= 10;
        else if (sum >= 9) res -= 9;
        else if (sum >= 5) res -= 5;
        else if (sum >= 4) res -= 4;
        else res -= 1;
        return res;
    }
}