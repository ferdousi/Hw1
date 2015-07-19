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
public class Project2 {

    /**
     * Method to validate phone numbers
     *
     * @param phonenum phonenumber to validate
     * @return returns a boolean
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
     * @param dates dates to validate
     * @param times times to validate
     * @return returns a boolean
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
         * @param read passed parameter
         */
        public static void readme(String read) {
            if (read.equalsIgnoreCase("-README")) {
                System.out.println("Name: Syeda Sara Ferdousi");
                System.out.println("Project 1: Phone Bill Application");
                System.out.println("***********************");
                System.out.println("usage: java edu.pdx.cs410J.ferdousi.Project2 [-README or -print] <args>\n" +
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

    /**
     * print method to print phonebills
     * @param args passes args
     */

    public static void print(String [] args){
        AbstractPhoneCall call = new PhoneCall(args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8]);
        AbstractPhoneCall call2 = new PhoneCall("921-240-0987", "505-678-0945", "12/03/2015", "11:20", "AM", "12/14/2015", "12:30", "AM");

        AbstractPhoneBill bill = new PhoneBill(args[0]);
        bill.addPhoneCall(call);
        bill.addPhoneCall(call2);

        Collection co = bill.getPhoneCalls();
        //Collections.sort(bill.getPhoneCalls());

        System.out.println(bill.toString());
        System.out.println(co);
        //System.exit(0);


    }

    /**
     * Method to print when only args passed
     * @param args passes the command line arguments
     */

    public static void printArgs(String [] args){
        if(args.length>7){
            System.err.println("Too many args passed");
            System.exit(1);
        }

        AbstractPhoneCall call = new PhoneCall(args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8]);

        AbstractPhoneBill bill = new PhoneBill(args[0]);
        bill.addPhoneCall(call);

        Collection co = bill.getPhoneCalls();

        System.out.println(bill.toString());
        System.out.println(co);
        System.exit(0);


    }




    /**
     * Method to parse and dump text files
     * @param arg the filename
     * @param info the arguments
     * @throws IOException
     * @throws ParserException
     */
    public static  void text(String arg, String []info)throws IOException, ParserException{
        if(arg.isEmpty() ){
            System.err.println("No file name found");
            System.exit(1);
        }

        TextParser tp = new TextParser(arg, info);
        AbstractPhoneBill ab;

        ab = tp.parse();


        TextDumper td = new TextDumper(arg);
        td.dump(ab);


        System.exit(0);


    }

    /**
     *
     * @param args commandline arguments
     * @throws IOException in the TextParser class
     * @throws ParserException in the TextParser class
     */

    public static void main(String[] args) throws IOException, ParserException {
    Class c = AbstractPhoneBill.class;  // Refer to one of Dave's classes so that we can be sure it is on the classpath
        String [] info1 = new String[9];
        if(args.length==0){
            System.err.println("No args passed");
            System.exit(0);
        }

        System.out.println("Args Length" + args.length);
        if(!args[0].startsWith("-")) {
            printArgs(args);

        }
        int i=0;

            while(i<=args.length) {
                if (!args[i].startsWith("-")) {
                    if (i != 0 && !args[i - 1].equalsIgnoreCase("-textFile")) {
                        for(int j=0; j<9; ++j){
                                info1[j] = args[i];
                                //System.out.println(j + " " + i);
                                ++i;
                            }
                        break;

                    } else {
                        ++i;
                    }
                } else {
                    ++i;
                }
            }

        //System.out.println(i);

            if(args.length > i){
                System.err.println("Too many args");
                System.exit(1);
            }


            if (args[0].equalsIgnoreCase("-README")) {
                readme(args[0]);
            } else if (args[0].equalsIgnoreCase("-print")) {
                if(args[1].equalsIgnoreCase("-textFile")){
                   print(info1);
                   text(args[2], info1);
                }else if(args[1].equalsIgnoreCase("-README")){
                    print(info1);
                    readme(args[1]);
                }else {
                    print(info1);
                }
            } else if (args[0].equalsIgnoreCase("-textFile")) {
                text(args[1], info1);

            } else {
                System.err.println("Insert a valid option");
                System.exit(1);
            }


        System.exit(0);



    }
    /*System.err.println("Missing command line arguments");
    for (String arg : args) {
      System.out.println(arg);
    }*/


}