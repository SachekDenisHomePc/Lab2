package com.company;

import java.util.Date;
import java.util.Scanner;

public class Experiment implements Comparable<Experiment>
{
    private Date date;
    private String equipment;
    private Date timeStart;
    private Date timeEnd;

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
        System.out.println(date+" "+equipment+" "+timeStart+" "+timeEnd);
    }

    @Override
    public int compareTo(Experiment o)
    {
        return equipment.compareTo(o.equipment);
    }
}
