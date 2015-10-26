/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author jslowik
 */
public class FirstDateTime {
    public static void main(String[] args) {
        Calendar date2 = Calendar.getInstance();//cannot be anything but a static method
        //calendar is a class, not an object (starts with Capital Letter)
        //only way to instantiate a class without an object is if it's a static method
        date2.set(2050, Calendar.SEPTEMBER, 23);//use the constant so you're not thrown by 0 based
        
        date2.add(Calendar.MONTH, -5);
        
        
        Date date1 = date2.getTime();
        System.out.println(date1.toString());//.toString is inherited by all objects (in a sout it is auto called)
        System.out.println(date1); // same as above. sout expects string and auto calls .toString()
        
        Date date3 = new Date();
        
        long diff = Math.abs(date1.getTime() - date3.getTime());//absolute value
        //to get minutes of difference between two dates
        long minutes = diff/1000/60;//diff in mili / to seconds / to minutes
        System.out.println(minutes);
                
                
                
        
        boolean isAfter = date1.after(date3);//there is also a "before" method
        System.out.println("date3 is after date1: " + isAfter);
        
        
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
        String fDate = sdf.format(date1);
        System.out.println(fDate);
        
        
        //convert from string to date
        String date3String = "Jul 11, 1999";
        try{
            date1 = sdf.parse(date3String);//parse method turns string into date
        }catch(ParseException pe){
            System.out.println("Cannot parse date string");
        }
        System.out.println(date1);
    }
}
