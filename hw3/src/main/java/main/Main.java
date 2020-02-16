package main;

import util.Parser;

import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        Parser.loadCompany();

        // Первое задание
//        main.java.groupId.util.Parser.print();

        //Второе задание
        Parser.companiesAfterDate();

        //Третье задание
//        main.java.groupId.util.Parser.isAvalible();

        //Четвертое задание
//        main.java.groupId.util.Parser.money();
    }


}
