package com.sheshagroups.satech.demoapp;

public class DataClass1 {

    private String Sname;
    private String Sclass;
    private String Ssection;
    private String Srollno;
    private String Sfname;
    private String Smname;
    private String Smobile;
    private String Sfee;
    private String Simage;
    private String Saddress;

    public String getSname() {
        return Sname;
    }

    public String getSclass() {
        return Sclass;
    }

    public String getSsection() {
        return Ssection;
    }

    public String getSrollno() {
        return Srollno;
    }

    public String getSfname() {
        return Sfname;
    }

    public String getSmname() {
        return Smname;
    }

    public String getSmobile() {
        return Smobile;
    }

    public String getSfee() {
        return Sfee;
    }

    public String getSimage() {
        return Simage;
    }

    public String getSaddress(){
        return Saddress;
    }

    public DataClass1(String sname, String sclass, String ssection, String srollno, String sfname, String smname, String smobile, String sfee, String simage, String saddress) {
        Sname = sname;
        Sclass = sclass;
        Ssection = ssection;
        Srollno = srollno;
        Sfname = sfname;
        Smname = smname;
        Smobile = smobile;
        Sfee = sfee;
        Simage = simage;
        Saddress = saddress;
    }
}
