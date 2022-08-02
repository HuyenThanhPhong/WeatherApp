package com.example.model;

public class ChamCong{
    private String day;
    private String sl;
    private String cn;
    private String sp;

    public ChamCong() {
    }

    public ChamCong(String day, String sl) {
        this.day = day;
        this.sl = sl;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

   
}
