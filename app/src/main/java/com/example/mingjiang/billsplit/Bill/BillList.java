package com.example.mingjiang.billsplit.Bill;

/**
 * Created by mingjiang on 8/16/16.
 */

/**
 * Created by mingjiang on 8/10/16.
 */
public class BillList {


    //private variables
    int billId;
    String BillName;
    Float BillAmount;

    // Empty constructor
    public BillList() {

    }

    // constructor
    public BillList(int billId, String BillName,Float BillAmount) {
        this.billId=billId;
        this.BillName=BillName;
        this.BillAmount=BillAmount;
    }

    public int getBillId() {
        return this.billId;
    }

    public void setBillId(int billId) {this.billId = billId;}

    public void setBillName(String BillName){this.BillName=BillName;}

    public String getBillName(){return BillName;}

    public void setBillAmount(Float BillAmount){this.BillAmount=BillAmount;}

    public Float getBillAmount(){return BillAmount;}


}