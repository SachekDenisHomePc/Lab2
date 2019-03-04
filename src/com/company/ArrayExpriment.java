package com.company;

import java.io.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class ArrayExpriment
{
    Experiment[] array;

    public ArrayExpriment()
    {
        InputOutput io = new InputOutput();
        array=io.Read();
    }

    void Sort()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("1.По возрастанию. 2. По убыванию");
        int choice = 0;
        while (!in.hasNextInt())
            in.next();
        choice=in.nextInt();
        if(choice==1)
            Arrays.sort(array);
        if(choice==2)
            Arrays.sort(array, Collections.reverseOrder());
    }

    Experiment[] FindAll(Date date)
    {
        return Arrays.stream(array).filter(q->q.getDate()==date).toArray(Experiment[]::new);
    }

    void Delete(Experiment exp)
    {
        array = Arrays.stream(array).filter(q->q!=exp).toArray(Experiment[]::new);
    }

    void DeleteIndex(int index)
    {
        array = Stream.concat(Arrays.stream(array).limit(index),Arrays.stream(array).skip(index+1)).toArray(Experiment[]::new);
    }

    void Add(Experiment exp)
    {
        array = Stream.concat(Arrays.stream(array),Arrays.stream(new Experiment[]{exp})).toArray(Experiment[]::new);
    }

    void AddNew()
    {

        Add(EnterNewElement());
    }

    void Insert(Experiment exp, int index)
    {
        index++;
        Experiment[] tmpArray = Stream.concat(Arrays.stream(array).limit(index), Arrays.stream(new Experiment[]{exp})).toArray(Experiment[]::new);
        array = Stream.concat(Arrays.stream(tmpArray),Arrays.stream(array).skip(index)).toArray(Experiment[]::new);
    }

    void InsertNew(int index)
    {
        Insert(EnterNewElement(),index);
    }

    void Redact(int index)
    {
        Scanner in = new Scanner(System.in);
        SimpleDateFormat date = new SimpleDateFormat("dd.mm.yyyy");
        SimpleDateFormat time = new SimpleDateFormat("HH.mm");
        try
        {
            System.out.println("Введите дату");
            array[index].setDate(date.parse(in.nextLine()));
            System.out.println("Введите название оборудования");
            array[index].setEquipment(in.nextLine());
            System.out.println("Ввудите время начала экспеимента");
            array[index].setTimeStart(time.parse(in.nextLine()));
            System.out.println("Ввудите время конца экспеимента");
            array[index].setTimeEnd(time.parse(in.nextLine()));

        }
        catch (Exception pe)
        {
            pe.printStackTrace();
        }
    }

    private Experiment EnterNewElement()
    {
        Scanner in = new Scanner(System.in);
        SimpleDateFormat date = new SimpleDateFormat("dd.mm.yyyy");
        SimpleDateFormat time = new SimpleDateFormat("HH.mm");
        Experiment tmp = new Experiment();
        try
        {
            System.out.println("Введите дату");
            tmp.setDate(date.parse(in.nextLine()));
            System.out.println("Введите название оборудования");
            tmp.setEquipment(in.nextLine());
            System.out.println("Ввудите время начала экспеимента");
            tmp.setTimeStart(time.parse(in.nextLine()));
            System.out.println("Ввудите время конца экспеимента");
            tmp.setTimeEnd(time.parse(in.nextLine()));
            return tmp;

        }
        catch (Exception pe)
        {
            pe.printStackTrace();
        }
        return null;
    }

    void WriteToFile()
    {
        InputOutput io = new InputOutput();
        io.Write(array);
    }

    void Output()
    {
        for(Experiment experiment:array)
        {
            experiment.ConsolePrint();
        }
    }




}
