package edu.pdx.cs410J.ferdousi;

import edu.pdx.cs410J.AbstractPhoneBill;
import edu.pdx.cs410J.PhoneBillDumper;

import java.io.IOException;
import java.io.*;

/**
 * Created by saraferdousi on 7/11/15.
 */
public class TextDumper implements PhoneBillDumper {
    File file;

    /**
     *
     * @param filename passes the filename to be dumped
     */
    public TextDumper(String filename){
        file = new File(filename);


    }

    /**
     * Method to write a phonebill to a file
     * @param bill passes the bill to be written in the file
     * @throws IOException
     */
    public void dump(AbstractPhoneBill bill) throws IOException{

        if(!file.exists()){
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        FileReader fr = new FileReader(file);
        BufferedWriter bw = new BufferedWriter(fw);
        BufferedReader br = new BufferedReader(fr);
        //bw.write(String.valueOf(bill.getPhoneCalls()));

        if(br.readLine()==null) {
            bw.write(bill.toString());
            bw.write("\n");
            bw.write(String.valueOf(bill.getPhoneCalls()));
        }else{
            bw.write(",");
            bw.write(String.valueOf(bill.getPhoneCalls()));

        }

        bw.close();




    }
}
