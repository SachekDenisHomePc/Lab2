package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Test
{
    public static void Test()
    {
        MenuItem choice;
        Scanner in = new Scanner(System.in);
        ArrayExpriment arrayExpriment = new ArrayExpriment();
        while (true)
        {
            PrintMenu();
            while (!in.hasNextInt())
                in.next();
            choice=MenuItem.values()[in.nextInt()-1];
            switch (choice) {
                case OUTPUT: {
                    arrayExpriment.Output();
                }
                break;
                case SORT: {
                    arrayExpriment.Sort();
                }
                break;
                case DELETE: {
                    while (!in.hasNextInt())
                        in.next();
                    arrayExpriment.DeleteIndex(in.nextInt());
                }
                break;
                case ADDINEND: {
                    arrayExpriment.AddNew();
                }
                break;
                case INSERT: {
                    while (!in.hasNextInt())
                        in.next();
                    arrayExpriment.InsertNew(in.nextInt());
                }
                break;
                case REDACT: {
                    while (!in.hasNextInt())
                        in.next();
                    arrayExpriment.Redact(in.nextInt());
                }
                break;
                case SAVE: {
                    arrayExpriment.WriteToFile();
                }
                in.nextLine();

            }
        }

    }

    private static void PrintMenu()
    {
        System.out.println("1.Вывести список экспериметов");
        System.out.println("2.Отсортировать список экспеиметов");
        System.out.println("3.Удалить по индексу");
        System.out.println("4.Добавить в конец");
        System.out.println("5.Вставить после индекса");
        System.out.println("6.Редактировать");
        System.out.println("7.Сохранить");

    }

    enum MenuItem
    {
        OUTPUT,
        SORT,
        DELETE,
        ADDINEND,
        INSERT,
        REDACT,
        SAVE

    }
}
