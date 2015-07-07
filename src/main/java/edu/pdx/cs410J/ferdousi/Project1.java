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

  public static boolean checkphnum(Integer [] num){

        if (num[0] == null || (num[0] < 100 && num[0] > 999)) {
            System.err.println("Wrong phone format");
            return false;
        } else if (num[1] == null || (num[1] < 1000 && num[1] > 9999)) {
            System.out.println("Wrong phone format");
            return false;
        } else if(num[2] == null || (num[2] < 1000 && num[2] > 9999)) {
            System.err.println("Wrong phone format");
            return false;
        } else {
            return true;
        }


  }

  public static void main(String[] args) {
    Class c = AbstractPhoneBill.class;  // Refer to one of Dave's classes so that we can be sure it is on the classpath
    Integer [] num = new Integer[3];
    Integer [] num1 = new Integer[3];
    int i=0;
    String [] str = new String[7];
    for(String arg: args){
      str[i]=arg;
      ++i;
    }

    String time1 = str[3].concat(str[4]);
    System.out.println(time1);
    String time2 = str[5].concat(str[6]);
    System.out.println(time2);

    if(str[1].contains("-") && str[2].contains("-")) {

      String[] tr = str[1].split("-");
      String[] tr1 = str[2].split("-");


      for(int t=0;t<tr.length; ++t){
        num[t] = Integer.parseInt(tr[t]);
        num1[t] = Integer.parseInt(tr1[t]);

      }


    }else{
      System.out.println("Phone number is in Wrong format");
    }

    boolean validity = checkphnum(num);
    boolean validity1 = checkphnum(num1);

    //System.out.println(validity);
    //System.out.println(validity1);

    AbstractPhoneCall call = new PhoneCall(args[1], args[2], time1, time2);

    AbstractPhoneBill bill = new PhoneBill(args[0]);
    bill.addPhoneCall(call);

    String r= bill.toString();
    System.out.println(r);

    Collection co = bill.getPhoneCalls();
    System.out.println(co);
    
    //System.err.println("Missing command line arguments");
    for (String arg : args) {
      System.out.println(arg);
    }
    System.exit(1);
  }

}