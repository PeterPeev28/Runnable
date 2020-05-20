package com.example.runnable;


public class LoginValidator {

    public static String error;

    public static void validatePasswordLenght(String password) {

        if (password.length() <= 0) {
            error = "Please enter a valid password.";
        }

        if (password.length() > 16) {
            error = "Please too long.";
        }
    }

    public static void validatePassword(String password) {

        if (!Character.isDigit(password.charAt(2)) || !Character.isDigit(password.charAt(5))) {
            error = "Please enter a digit at the 3rd or 6th index index";
        }

    }

    public void validatePasswordSymbol(String password) {
        String specialSymbol="!,@,#,$,%,&,*";
        // TODO make the proverka
    }

}
