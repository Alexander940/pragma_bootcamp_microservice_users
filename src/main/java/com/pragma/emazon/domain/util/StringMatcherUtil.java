package com.pragma.emazon.domain.util;

public class StringMatcherUtil {

    private StringMatcherUtil() {
    }

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final String PHONE_NUMBER_REGEX = "^\\+?\\d+$";
    private static final String NUMERIC_REGEX = "^\\d+$";

    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        return email.matches(EMAIL_REGEX);
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            return false;
        }
        return phoneNumber.matches(PHONE_NUMBER_REGEX);
    }

    public static boolean isNumeric(String number) {
        if (number == null) {
            return false;
        }
        return number.matches(NUMERIC_REGEX);
    }
}
