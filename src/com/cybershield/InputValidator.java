package com.cybershield;

import java.util.Scanner;

public class InputValidator {

    public static int readInt(
            Scanner scanner,
            String message,
            int min,
            int max) {

        while (true) {

            System.out.print(message);

            try {

                int value = Integer.parseInt(
                        scanner.nextLine()
                );

                if (value >= min && value <= max) {
                    return value;
                }

                System.out.println(
                        "Please enter a value between "
                                + min + " and " + max + "."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a number."
                );
            }
        }
    }

    public static String readNonEmptyString(
            Scanner scanner,
            String message) {

        while (true) {

            System.out.print(message);

            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println(
                    "Input cannot be empty. Please try again."
            );
        }
    }
}
