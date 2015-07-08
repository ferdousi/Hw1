package edu.pdx.cs410J.ferdousi;

import edu.pdx.cs410J.AbstractPhoneCall;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by saraferdousi on 6/27/15.
 */
public class PhoneCall extends AbstractPhoneCall {

    private String CallerPhoneNumber;
    private String CalleePhoneNumber;
    private String startTime;
    private String endTime;
    SimpleDateFormat ft = new SimpleDateFormat("mm/dd/yyy hh:mm");


    public PhoneCall(String CallerNumber, String CalleeNumber, String stime, String etime){
        this.CallerPhoneNumber = CallerNumber;
        this.CalleePhoneNumber = CalleeNumber;
        startTime = stime;
        endTime = etime;


    }


    /**
     * Returns the phone number of the person who originated this phone
     * call.
     */
    public String getCaller(){
        return CallerPhoneNumber;
    }

    /**
     * Returns the phone number of the person who received this phone
     * call.
     */
    public String getCallee(){
        return CalleePhoneNumber;
    }

    /**
     * Returns the time that this phone call was originated.
     */
    public String getStartTimeString(){
        return startTime;

    }

    /**
     * Returns the time that this phone call was ended
     */
    public String getEndTimeString(){
        return endTime;
    }





}
