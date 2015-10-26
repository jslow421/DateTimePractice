/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.lab.Utilities;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//avoid making these methods static
//come back and change this up a bit



/**
 *Utility class for performing various date related functions.
 * 
 * @author John Slowik <jslowik@my.wctc.edu>
 */
public class DateUtilities {
 private final static long MIL_PER_SEC = 1000;
    private final static long SEC_PER_MIN = 60;
    private final static long MIN_PER_HR = 60;
    private final static long HR_PER_DAY = 24;

    /**
     * Method to convert a date to a string
     * @param format
     * @param date
     * @return 
     */
    public static String convertDateToString(String format, Date date) {
	if (format == null || format.isEmpty()) {
	    throw new IllegalArgumentException("Date Format String Missing!");
	}
	if (date == null) {
	    throw new IllegalArgumentException("Date Missing!");
	}

	SimpleDateFormat dateFormat = new SimpleDateFormat(format);

	return (dateFormat.format(date));
    }

    /**
     * Convert calendar (date/time) to a string
     * @param format
     * @param calendar
     * @return 
     */
    public static String convertCalendarToString(String format, Calendar calendar) {
	if (format == null || format.isEmpty()) {
	    throw new IllegalArgumentException("Date Format String Missing!");
	}
	if (calendar == null) {
	    throw new IllegalArgumentException("Date Missing!");
	}

	SimpleDateFormat dateFormat = new SimpleDateFormat(format);

	return (dateFormat.format(calendar.getTime()));
    }

    /**
     * Create a date object from a string
     * @param dateString
     * @param format
     * @return
     * @throws ParseException 
     */
    public static Date convertStringToDate(String dateString, String format) throws ParseException {
	if (dateString == null || dateString.isEmpty()) {
	    throw new IllegalArgumentException("Date String Missing!");
	}
	if (format == null || format.isEmpty()) {
	    throw new IllegalArgumentException("Date Format String Missing!");
	}

	SimpleDateFormat dateFormat = new SimpleDateFormat(format);

	return (dateFormat.parse(dateString));
    }

    /**
     * Convert a string to a calendar (date/time) object
     * @param dateString
     * @param format
     * @return
     * @throws ParseException 
     */
    public static Calendar convertStringToCalendar(String dateString, String format) throws ParseException {
	if (dateString == null || dateString.isEmpty()) {
	    throw new IllegalArgumentException("Date String Missing!");
	}
	if (format == null || format.isEmpty()) {
	    throw new IllegalArgumentException("Date Format String Missing!");
	}

	SimpleDateFormat dateFormat = new SimpleDateFormat(format);

	Calendar calendar = Calendar.getInstance();
	calendar.setTime(dateFormat.parse(dateString));

	return calendar;
    }

    /**
     * Calculate the difference between two strings - utilizes object difference method to perform
     * actual calculation
     * @param format
     * @param endTimeStr
     * @param startTimeStr
     * @return 
     */
    public static String calculateStringDifferenceInHHMM(String format, String endTimeStr, String startTimeStr) {
        
        if (startTimeStr == null || startTimeStr.isEmpty()) {
	    throw new IllegalArgumentException("Start date is missing (string)!");
	}
	if (endTimeStr == null || endTimeStr.isEmpty()) {
	    throw new IllegalArgumentException("End date is issing (string)!");
	}
	
	if (format == null || format.isEmpty()) {
	    throw new IllegalArgumentException("Date format is missing!");
	}
	Calendar startTime;
	Calendar endTime;
	try {
	    startTime = DateUtilities.convertStringToCalendar(startTimeStr, format);
	} catch (ParseException pe) {
	    throw new IllegalArgumentException ("Start Date Parse Exception", pe);
	}
	try {
	    endTime = DateUtilities.convertStringToCalendar(endTimeStr, format);
	} catch (ParseException pe) {
	    throw new IllegalArgumentException ("End Date Parse Exception", pe);
	}
	
	return calculateObjectDifferenceInHHMM(endTime, startTime);
    }

    /**
     * Calculates time difference between two calendar objects. Utilized by string
     * calculate method 
     * @param endTime
     * @param startTime
     * @return 
     */
    public static String calculateObjectDifferenceInHHMM(Calendar endTime, Calendar startTime) {
	if (endTime == null) {
	    throw new IllegalArgumentException("End Date Missing!");
	}
	if (startTime == null) {
	    throw new IllegalArgumentException("Start Date Missing!");
	}

	String dateMessage = "00:00";

	long timeCompare = endTime.compareTo(startTime);
	if (timeCompare < 0) {
	    throw new IllegalArgumentException("Start Date after End Date!");
	} else if (timeCompare == 0) {
	    return dateMessage;
	}

	long diffMs = endTime.getTimeInMillis() - startTime.getTimeInMillis();
	long diffMins = diffMs / MIL_PER_SEC / SEC_PER_MIN;
	long diffHr = diffMins / MIN_PER_HR;
	long diffMn = diffMins % MIN_PER_HR;
        long diffDays = diffHr / HR_PER_DAY;
	dateMessage = Long.toString(diffHr);
	if (diffMn > 9) {
	    dateMessage = dateMessage + ":" + Long.toString(diffMn);
	} else {
	    dateMessage = dateMessage + ":0" + Long.toString(diffMn);
	}

	return dateMessage;
    }
    
    
}