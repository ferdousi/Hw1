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



    public String getCaller(){
        return CallerPhoneNumber;
    }

    public String getCallee(){
        return CalleePhoneNumber;
    }

    public String getStartTimeString(){
        return startTime;

    }

    public String getEndTimeString(){
        return endTime;
    }





}
