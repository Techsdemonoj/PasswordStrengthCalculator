

package com.myapp.passwordstrengthcalculator;


import java.util.Scanner;

public class PasswordStrengthCalculator {
    public static void main(String[] args) {
        //taking input from user and strore it in a score variabale
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        int score = calculatePasswordStrength(password);
        String strength = getPasswordStrength(score);

        System.out.println("Password strength: " + strength);
    }

    private static int calculatePasswordStrength(String password) {
        int score = 0;

        // Length check
        if (password.length() >= 8) {
            score++;
        }

        // Contains lowercase letters
        if (password.matches(".*[a-z].*")) {
            score++;
        }

        // Contains uppercase letters
        if (password.matches(".*[A-Z].*")) {
            score++;
        }

        // Contains digits
        if (password.matches(".*\\d.*")) {
            score++;
        }

        // Contains special characters
        if (password.matches(".*[^a-zA-Z0-9].*")) {
            score++;
        }

        return score;
    }

    private static String getPasswordStrength(int score) {
        
        //using case checking  condition to print as per password configuration
        switch (score) {
            case 0:
                return " Your Password is Very Weak, Please modify it";
            case 1:
                return "Your Password is Weak";
            case 2:
                return " Your Password is Moderate";
            case 3:
                return " Your Password is Strong";
            case 4:
                return " Your Password is Very Strong";
            default:
                return " Sorry, Your Password is Invalid";
        }
    }
}

