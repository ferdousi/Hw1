package edu.pdx.cs410J.ferdousi;

import edu.pdx.cs410J.AbstractPhoneBill;
import edu.pdx.cs410J.AbstractPhoneCall;
import java.util.*;

/**
 * Created by saraferdousi on 6/27/15.
 */

/**
 * PhoneBill class
 */

public class PhoneBill extends AbstractPhoneBill {
    private String name;
    private List<AbstractPhoneCall> callList;


    public PhoneBill(){
        callList = new ArrayList<AbstractPhoneCall>();
    }

    /**
     *
     * @param name This is the name of customer
     */

    public PhoneBill(String name){
        this();
        this.name = name;
    }

    /**
     *
     * @return returns the customer name
     */

    public String getCustomer(){
        return name;
    }

    /**
     * Adds a phone call to this phone bill
     */
    public void addPhoneCall(AbstractPhoneCall call){
        callList.add(call);

    }

    /**
     * Returns all of the phone calls (as instances of {@link
     * AbstractPhoneCall}) in this phone bill
     */
    public Collection getPhoneCalls(){
        return callList;


    }


}
