package edu.pdx.cs410J.ferdousi;

import edu.pdx.cs410J.AbstractPhoneBill;
import edu.pdx.cs410J.AbstractPhoneCall;
import edu.pdx.cs410J.PhoneBillDumper;
import edu.pdx.cs410J.ParserException;

import java.text.ParseException;
import java.util.*;
import java.io.*;

/**
 * The main class for the CS410J Phone Bill Project
 */
public class Project1 {

    /**
     * Method to validate phone numbers
     *
     * @param phonenum
     * @return
     */
    public static boolean checkphnum(String phonenum) {

        if (phonenum.matches("\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d"))
            return true;
        else
            return false;


    }

    /**
     * Method to check the date and time formats
     *
     * @param dates
     * @param times
     * @return
     */
    public static boolean checkDate(String dates, String times) {
        if (dates.matches("\\d\\d/\\d/\\d\\d\\d\\d") || dates.matches("\\d/\\d\\d/\\d\\d\\d\\d") || dates.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d")) {
            if (times.matches("\\d\\d:\\d\\d") || times.matches("\\d:\\d\\d"))
                return true;
            else
                return false;

        } else return false;

    }



        /**
         * Method for the README.
         *
         * @param read
         */
        public static void readme(String read) {
            if (read.equalsIgnoreCase("-README") || read.equalsIgnoreCase("-print")) {
                System.out.println("Name: Syeda Sara Ferdousi");
                System.out.println("Project 1: Phone Bill Application");
                System.out.println("***********************");
                System.out.println("usage: java edu.pdx.cs410J.ferdousi.Project1 [-README or -print] <args>\n" +
                        "args are (in this order):\n" +
                        "customer\n" +
                        "callerNumber\n" +
                        "calleeNumber\n" +
                        "startTime\n" +
                        "endTime");
                System.out.println();
                System.exit(0);

            }

        }

        public static void main(String[] args) throws IOException, ParserException {
    Class c = AbstractPhoneBill.class;  // Refer to one of Dave's classes so that we can be sure it is on the classpath
    if(args.length<=0 || args.length>8){
        System.err.println("The input must be in following order:" +
                "-README or -print 'customer name' phone#1 phone#2 date time date time");
    }else {
        int i = 0;
        String[] str = new String[args.length];
        for (String arg : args) {
            str[i] = arg;
            ++i;
        }

        if (str[0].equalsIgnoreCase("-README")) {

            readme(str[0]);
        } else if(str[0].equalsIgnoreCase("-print")) {

            boolean starttime = checkDate(str[4], str[5]);
            boolean endtime = checkDate(str[6], str[7]);


            String time1 = str[4].concat(" " + str[5]);
            String time2 = str[6].concat(" " + str[7]);


            boolean validity = checkphnum(str[2]);
            boolean validity1 = checkphnum(str[3]);

            if (starttime == true && endtime == true && validity == true && validity1 == true) {

                AbstractPhoneCall call = new PhoneCall(args[2], args[3], time1, time2);

                AbstractPhoneBill bill = new PhoneBill(args[1]);
                bill.addPhoneCall(call);

                /*AbstractPhoneCall call2 = new PhoneCall("987-234-3445", "908-234-4567", "12/3/2015 6:40", "14/4/2012 6:70");
                bill.addPhoneCall(call2);

                AbstractPhoneCall call3 = new PhoneCall("917-234-3445", "908-234-5567", "12/3/2015 6:00", "14/4/2012 6:70");
                bill.addPhoneCall(call3);
                TextDumper td = new TextDumper();
                td.dump(bill);

                String r = bill.toString();*/
               // System.out.println(r);

                Collection co = bill.getPhoneCalls();

                System.out.println(co);

            }else {
                System.out.println("***Please enter valid date and time or Phone number***");
                System.out.println("Date format: dd/m/yyyy or d/mm/yyyy\n Phone number format:nnn-nnn-nnnn (n={0-9})");
            }
        }else{

            boolean starttime1 = checkDate(str[3], str[4]);
            boolean endtime1 = checkDate(str[5], str[6]);


            String time1s = str[3].concat(" " + str[4]);
            String time2s = str[5].concat(" " + str[6]);


            boolean validitys = checkphnum(str[1]);
            boolean validity2 = checkphnum(str[2]);

            if (starttime1 == true && endtime1 == true && validitys == true && validity2 == true) {

                AbstractPhoneCall call = new PhoneCall(args[1], args[2], time1s, time2s);

                AbstractPhoneBill bill = new PhoneBill(args[0]);
                bill.addPhoneCall(call);
                String r = bill.toString();
                System.out.println(r);

                Collection co = bill.getPhoneCalls();

                System.out.println(co);

            }
            else {
                System.out.println("***Please enter valid date and time or Phone number***");
                System.out.println("Date format: dd/m/yyyy or d/mm/yyyy\n Phone number format:nnn-nnn-nnnn (n={0-9})");
            }
        }



    }
    /*System.err.println("Missing command line arguments");
    for (String arg : args) {
      System.out.println(arg);
    }*/

            /*TextParser tp = new TextParser();
            AbstractPhoneBill ab = new PhoneBill();
            ab = tp.parse();
            System.out.println(ab.toString());
            System.out.println(ab.getPhoneCalls());
*/

            System.exit(0);


        }



}