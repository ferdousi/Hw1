package edu.pdx.cs410J.ferdousi;

import edu.pdx.cs410J.AbstractPhoneBill;
import edu.pdx.cs410J.AbstractPhoneCall;
import java.util.*;

/**
 * Created by saraferdousi on 6/27/15.
 */
public class PhoneBill extends AbstractPhoneBill {
    private String name;
    private List<AbstractPhoneCall> callList;
    //private Collection calls;

    public PhoneBill(){
        callList = new ArrayList<AbstractPhoneCall>();
    }

    public PhoneBill(String name){
        this();
        this.name = name;
    }

    public String getCustomer(){
        return name;
    }

    public void addPhoneCall(AbstractPhoneCall call){
        callList.add(call);

    }

    public Collection getPhoneCalls(){
        return callList;


    }


}
