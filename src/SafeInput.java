import java.util.Scanner;
public class SafeInput {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        String test = getRegExString(scanner, "SSN", "^\\d{3}-\\d{2}-\\d{4}$");
        System.out.println(test);
    }

    /**
     *
     *
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */

    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;


    }

    public static int getInt(Scanner pipe, String prompt) {
        boolean done = false;
        int retInt = 0; // Set this to zero length. Loop runs until it isn't
        String trash;
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            if (!pipe.hasNextInt()) {
                trash = pipe.next();
                continue;
            } else {
                retInt = pipe.nextInt();
                done = true;
            }
        } while (!done);
        return retInt;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        boolean done = false;
        double retDouble = 0;
        String trash;
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            if (!pipe.hasNextDouble()) {
                trash = pipe.next();
            } else {
                retDouble = pipe.nextDouble();
                done = true;
            }
        } while (!done);
        return retDouble;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        boolean done = false;
        int guess = 0;
        String trash;
        do {
            System.out.print("\n" + prompt + "[" + low + "-" + high + "]" + ": "); // show prompt add space
            if (!pipe.hasNextInt()) {
                trash = pipe.next();
            } else {
                guess = pipe.nextInt();
                if (guess >= low && guess <= high) {
                    done = true;

                }
            }
        } while (!done);
        return guess;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        boolean done = false;
        double guess = 0;
        String trash;
        do {
            System.out.print("\n" + prompt + "[" + low + "-" + high + "]" + ": "); // show prompt add space
            if (!pipe.hasNextDouble()) {
                trash = pipe.next();
            } else {
                guess = pipe.nextDouble();
                if (guess >= low && guess <= high) {
                    done = true;

                }
            }
        } while (!done);
        return guess;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String userInput;
        while (true) {
            System.out.print(prompt + ": ");
            userInput = pipe.nextLine();
            if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes")) {
                return true;
            } else if (userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("no")) {
                return false;
            }
        }
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String userInput;
        while (true) {
            System.out.print(prompt + ": ");
            userInput = pipe.next();
            if (userInput.matches(regEx)) {
                return userInput;
            }
        }
    }

    public static void prettyHeader(String messageCenteredHere) {
        for (int i = 0; i < 60; i++) {
            System.out.print("*");
        }
        System.out.println();
        int messageLength = messageCenteredHere.length();
        int padding = (52 - messageLength) / 2;
        System.out.print("*** ");
        for (int i = 0; i < padding; i++) {
            System.out.print(" ");
        }
        System.out.print(messageCenteredHere);
        for (int i = 0; i < 52 - messageLength - padding; i++) {
            System.out.print(" ");
        }
        System.out.println(" ***");
        for (int i = 0; i < 60; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}