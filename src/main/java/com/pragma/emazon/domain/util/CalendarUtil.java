package com.pragma.emazon.domain.util;

import java.util.Calendar;

public class CalendarUtil {

    public static boolean isAdult(Calendar birthDate) {
        Calendar today = Calendar.getInstance();

        Calendar adultThreshold = Calendar.getInstance();
        adultThreshold.setTime(today.getTime());
        adultThreshold.add(Calendar.YEAR, -18);

        return birthDate.before(adultThreshold) || birthDate.equals(adultThreshold);
    }
}
