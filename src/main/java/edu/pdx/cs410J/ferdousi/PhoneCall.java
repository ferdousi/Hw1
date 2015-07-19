package edu.pdx.cs410J.ferdousi;

import edu.pdx.cs410J.AbstractPhoneCall;
import java.text.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.DateFormat;
import java.util.logging.SimpleFormatter;
import java.lang.Comparable;


/**
 * Created by saraferdousi on 6/27/15.
 */
public class PhoneCall extends AbstractPhoneCall implements Comparable<PhoneCall>{

    private String CallerPhoneNumber;
    private String CalleePhoneNumber;
    private String startTime;
    private String endTime;
    private Date mydate;
    private Date enddate;
    private PhoneCall obj;
    // SimpleDateFormat ft = new SimpleDateFormat("mm/dd/yyy hh:mm");

    /**
     *
     * @param CallerNumber the number that initiated the call
     * @param CalleeNumber reciever's phone number
     * @param stime starttime of the call
     * @param etime endtime of the call
     */
    public PhoneCall(String CallerNumber, String CalleeNumber, String date1, String stime, String ampm1, String date2, String etime, String ampm2){
        if(CallerNumber !=null) {
            if (!CallerNumber.matches("\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d") && !CalleeNumber.matches("\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d")) {
                System.err.println("Please enter a valid phone number");
                System.exit(1);
            }
        }
        if(date1!=null) {
            if (!date1.matches("\\d\\d/\\d/\\d\\d\\d\\d")) {
                if (!date1.matches("\\d/\\d\\d/\\d\\d\\d\\d")) {
                    if (!date1.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d")) {
                        System.err.println("Wrong date format" + date1);
                        System.exit(1);
                    }
                }
            }
        }

        if(date2!=null) {
            if (!date2.matches("\\d\\d/\\d/\\d\\d\\d\\d")) {
                if (!date2.matches("\\d/\\d\\d/\\d\\d\\d\\d")) {
                    if (!date2.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d")) {
                        System.err.println("Wrong date format" + date2);
                        System.exit(1);
                    }
                }
            }
        }

        if(stime!=null) {
            if (!stime.matches("\\d\\d:\\d\\d")) {
                if (!stime.matches("\\d:\\d\\d")) {
                    if (!stime.matches("\\d\\d:\\d\\d \\S+")) {
                        if (!stime.matches("\\d:\\d\\d \\S+")) {

                            System.err.println("Wrong time format");
                            System.exit(1);
                        }
                    }
                }
            }
        }

        if(etime!=null) {
            if (!etime.matches("\\d\\d:\\d\\d")) {
                if (!etime.matches("\\d:\\d\\d")) {


                    if (!etime.matches("\\d\\d:\\d\\d \\S+")) {
                        if (!etime.matches("\\d:\\d\\d \\S+")) {

                            System.err.println("Wrong time format");
                            System.exit(1);
                        }
                    }
                }
            }
        }


        this.CallerPhoneNumber = CallerNumber;
        this.CalleePhoneNumber = CalleeNumber;
        if(date1==null || date2==null){
            startTime = null;
            endTime = null;
        }else {
            startTime = date1.concat(" " + stime + " "+ampm1);
            endTime = date2.concat(" " + etime + " "+ ampm2);
        }
        mydate = new Date();
        enddate = new Date();

    }

    /*public PhoneCall(AbstractPhoneCall abs){
        this.CallerPhoneNumber = abs.getCaller();
        this.CalleePhoneNumber = abs.getCallee();
        this.mydate = abs.getStartTime();
        this.enddate = abs.getEndTime();



    }*/


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

    @Override
    public Date getStartTime() {
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm a");


        try {

            mydate = formatter.parse(startTime);
            //mydate = date;

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return mydate;

    }

    /**
     * Returns the time that this phone call was originated.
     */
    public String getStartTimeString(){

        Date dat = getStartTime();
        DateFormat ef = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
        String f = ef.format(dat);

        //String df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(dat);

        return f;

    }

    @Override
    public Date getEndTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");


        try {

            enddate = formatter.parse(endTime);

            //enddate = date;

        } catch (ParseException e) {
            e.printStackTrace();
        }



        return enddate;
    }

    /**
     * Returns the time that this phone call was ended
     */
    public String getEndTimeString(){

        Date edate = getEndTime();
        //String ef = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(edate);
        DateFormat ef = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
        String f = ef.format(edate);

        return f;
    }

    @Override
    public int compareTo(PhoneCall obj) {


        Date cdate = ((PhoneCall) obj).getStartTime();
        String cnum = ((PhoneCall)obj).getCaller();

        int callsComp = mydate.compareTo(cdate);

        return ((callsComp != 0) ? callsComp: 0);

    }


   /* @Override
    public int compareTo(AbstractPhoneCall o) {
        Date cdate = ((PhoneCall) obj).getStartTime();
        String cnum = ((PhoneCall)obj).getCaller();

        int callsComp = mydate.compareTo(cdate);

        return ((callsComp != 0) ? callsComp: 0);
    }*/

    public static class numComparator implements Comparator<PhoneCall>
    {
        public int compare(PhoneCall p1, PhoneCall p2)
        {
            String call1 = p1.getCaller();
            String call2 = p2.getCaller();

            if (call1.compareTo(call2)==0)
                return 0;
            else if (call1.compareTo(call2)>=0)
                return 1;
            else
                return -1;
        }
    }




}
