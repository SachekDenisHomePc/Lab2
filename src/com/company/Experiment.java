package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Experiment implements Comparable<Experiment>
{
    private Date date;
    private String equipment;
    private Date timeStart;
    private Date timeEnd;
    private DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
    private DateFormat timeFormat = new SimpleDateFormat("hh.mm.ss");

    Experiment(Date date, String equipment, Date timeStart, Date timeEnd)
    {
        this.date=date;
        this.equipment=equipment;
        this.timeStart=timeStart;
        this.timeEnd=timeEnd;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public  void ConsolePrint()
    {
        System.out.println(dateFormat.format(date)+" "+equipment+" "+timeFormat.format(timeStart)+" "+timeFormat.format(timeEnd));
    }

    String FileFormat()
    {
        return dateFormat.format(date)+";"+equipment+";"+timeFormat.format(timeStart)+";"+timeFormat.format(timeEnd);
    }

    @Override
    public int compareTo(Experiment o)
    {
        return equipment.compareTo(o.equipment);
    }
}
