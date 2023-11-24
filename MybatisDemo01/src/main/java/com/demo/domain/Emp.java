package com.demo.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Emp {
    private int eno;
    private String ename;
    private String sex;
    private Date birthday;


    public int getEno() {
        return eno;
    }

    public void setEno(int eno) {
        this.eno = eno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;

    }

    public Emp() {
    }

    public Emp(int eno, String ename, String sex, Date birthday) {
        this.eno = eno;
        this.ename = ename;
        this.sex = sex;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        var birthinfo = sdf.format(birthday);
        return "Emp{" +
                "eno=" + eno +
                ", ename='" + ename + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthinfo +'\''+
                '}';
    }
}
