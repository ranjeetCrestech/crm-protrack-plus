package com.protrack.web.selenium.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeUtil {
    public static String getcurrentDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
        Calendar cal = Calendar.getInstance();
        return(dateFormat.format(cal.getTime()));
    }
    public static String getcurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
        Calendar cal = Calendar.getInstance();
        return(dateFormat.format(cal.getTime()));
    }


    public static int getCurrentDay() {
        Calendar cal = Calendar.getInstance();
        return(cal.get(Calendar.DAY_OF_MONTH));
    }

}
