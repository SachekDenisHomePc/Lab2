package com.company;

import java.io.*;
import java.nio.Buffer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class InputOutput
    {
       private DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
       private DateFormat timeFormat = new SimpleDateFormat("HH.mm");

       Experiment[] Read()
       {
           ArrayList<Experiment> tmpList = new ArrayList<>();
           String startString;
           try
           {
               BufferedReader bf = new BufferedReader(new FileReader("resources/1.txt"));
               while((startString = bf.readLine())!=null)
               {
                   String[] parsedInput= startString.split(";");
                   try
                   {
                       tmpList.add(new Experiment(dateFormat.parse(parsedInput[0]),parsedInput[1],timeFormat.parse(parsedInput[2]),timeFormat.parse(parsedInput[3])));
                   } catch (ParseException e)
                   {
                       e.printStackTrace();
                   }

               }
               bf.close();
           }
           catch (IOException e)
           {
               e.printStackTrace();
           }
           return tmpList.toArray(new Experiment[0]);
       }

       void Write(Experiment[] array)
       {
           try
           {
               BufferedWriter bf = new BufferedWriter(new FileWriter("resources/1.txt"));
               for(Experiment experiment:array)
               {
                   bf.write(experiment.FileFormat());
                   bf.newLine();
               }
               bf.close();
           }
           catch (IOException e)
           {
               e.printStackTrace();
           }
       }
    }
