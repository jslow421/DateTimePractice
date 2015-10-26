/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.lab;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import student.lab.Utilities.DateUtilities;

/**
 *
 * @author John Slowik <jslowik@my.wctc.edu>
 */
public class Startup {
    public static void main(String[] args) {
        Calendar startDate = Calendar.getInstance();
	startDate.set(2014, Calendar.JANUARY, 1);
	Calendar endDate = Calendar.getInstance();
	endDate.set(2014, Calendar.JANUARY, 15);
	
	long startMs = startDate.getTimeInMillis();
	long endMs = endDate.getTimeInMillis();
	
	long diffMs = endMs - startMs;
	Calendar diffCal = Calendar.getInstance();
	diffCal.setTimeInMillis(diffMs);
	
	long days = diffMs / 1000 / 60 / 60 / 24;
	
	System.out.println("Days between dates: " + days);
        
        System.out.println(DateUtilities.calculateObjectDifferenceInHHMM(endDate, startDate));
        
        
    }
    
}
