package com.company;

import java.util.Arrays;
import java.util.Date;

public class ArrayExpriment
{
    Experiment[] array;

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
