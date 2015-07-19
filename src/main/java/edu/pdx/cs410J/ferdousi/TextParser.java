package edu.pdx.cs410J.ferdousi;

import edu.pdx.cs410J.AbstractPhoneBill;
import edu.pdx.cs410J.AbstractPhoneCall;
import edu.pdx.cs410J.ParserException;
import edu.pdx.cs410J.PhoneBillParser;
import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by saraferdousi on 7/11/15.
 */
public class TextParser implements PhoneBillParser {

    AbstractPhoneBill mybill;
    AbstractPhoneCall newcalls, newcalls1;
    String bill;
    String calls;
    File filename;

    /**
     * Constructor for TextParser
     * @param file passes the filename
     * @param arg passes the arguments
     */

    public TextParser(String file, String []arg){
        bill = null;
        calls = null;
        filename = new File(file);
        newcalls1= new PhoneCall(arg[1], arg[2], arg[3], arg[4], arg[5], arg[6], arg[7], arg[8]);
        mybill = new PhoneBill(arg[0]);

    }

    /**
     * Method to parse from a text file
     * @return a phone bill
     * @throws ParserException handles Parse Exception
     */
    public AbstractPhoneBill parse() throws ParserException{


        try {

            if(!filename.exists()){
                filename.createNewFile();
                mybill.addPhoneCall(newcalls1);
                return mybill;
            }else {

                if (filename.length() != 0) {
                    Scanner input = new Scanner(new FileInputStream(filename));
                    bill = input.nextLine();
                    while (input.hasNextLine()) {
                        calls = input.nextLine();

                    }



                    String[] mycalls = calls.split(",");


                    String[] firstcall = mycalls[0].split(" ");

                    for (int i = 0; i < mycalls.length; ++i) {

                        System.out.println(i);

                        newcalls = new PhoneCall(firstcall[3], firstcall[5], firstcall[7], firstcall[8], firstcall[9], firstcall[11], firstcall[12], firstcall[13]);
                        mybill.addPhoneCall(newcalls);


                    }

                }else{
                    mybill.addPhoneCall(newcalls1);
                    return mybill;

                }
            }


        }catch (IOException e){

        }

        mybill.addPhoneCall(newcalls1);



        return mybill;


    }

}
