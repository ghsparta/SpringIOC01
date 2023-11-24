package com.demo.domain;

public class Department {
    private int dno;
    private String dname;

    private String telno;

    private Emp head;

    public int getDno() {
        return dno;
    }

    public void setDno(int dno) {
        this.dno = dno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public Emp getHead() {
        return head;
    }

    public void setHead(Emp head) {
        this.head = head;
    }

    public Department() {
    }

    public Department(int dno, String dname, String telno, Emp head) {
        this.dno = dno;
        this.dname = dname;
        this.telno = telno;
        this.head = head;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dno=" + dno +
                ", dname='" + dname + '\'' +
                ", telno='" + telno + '\'' +
                ", head=" + head +
                '}';
    }
}
