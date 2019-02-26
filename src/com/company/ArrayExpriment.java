package com.company;

import java.util.Arrays;
import java.util.Date;

class ArrayExpriment
{
    private Experiment[] array;
    private InputOutput IO = new InputOutput();
    void ReadFromFile()
    {
        array = IO.Read();
    }

    void WriteToFile()
    {
        IO.Write(array);
    }

    Experiment find(Date field)
    {
        for (Experiment obj:array)
        {
            if(obj.getDate()==field)
                return obj;

        }
        return null;
    }



    void sort()
    {
        Arrays.sort(array);
    }
}
