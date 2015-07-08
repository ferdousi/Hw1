package edu.pdx.cs410J.ferdousi;

import edu.pdx.cs410J.AbstractPhoneBill;
import edu.pdx.cs410J.AbstractPhoneCall;

import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 * The main class for the CS410J Phone Bill Project
 */
public class Project1 {

  public static boolean checkphnum(String phonenum){

      if(phonenum.matches("\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d"))
          return true;
      else
          return false;


  }

  public static boolean checkDate(String dates, String times){
      if (dates.matches("\\d\\d/\\d/\\d\\d\\d\\d") || dates.matches("\\d/\\d\\d/\\d\\d\\d\\d")) {
          if (times.matches("\\d\\d:\\d\\d") || times.matches("\\d:\\d\\d"))
              return true;
          else
              return false;

      } else return false;

  }

  public static void main(String[] args) {
    Class c = AbstractPhoneBill.class;  // Refer to one of Dave's classes so that we can be sure it is on the classpath

    int i=0;
    String [] str = new String[args.length];
    for(String arg: args){
      str[i]=arg;
      ++i;
    }

    boolean starttime = checkDate(str[3], str[4]);
    boolean endtime = checkDate(str[5], str[6]);


    String time1 = str[3].concat(" " + str[4]);
    String time2 = str[5].concat(" " + str[6]);



    boolean validity = checkphnum(str[1]);
    boolean validity1 = checkphnum(str[2]);

    if(starttime==true && endtime == true && validity==true && validity1==true) {

        AbstractPhoneCall call = new PhoneCall(args[1], args[2], time1, time2);

        AbstractPhoneBill bill = new PhoneBill(args[0]);
        bill.addPhoneCall(call);

        String r = bill.toString();
        System.out.println(r);

        Collection co = bill.getPhoneCalls();
        System.out.println(co);
    }

    /*System.err.println("Missing command line arguments");
    for (String arg : args) {
      System.out.println(arg);
    }*/
    System.exit(0);
  }

}