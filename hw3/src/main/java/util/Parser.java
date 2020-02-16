package util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.Main;
import model.Company;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Parser {
    static List<Company> list;

    private static DateFormat REG_DATE = new SimpleDateFormat("dd/MM/YY"); //8
    private static DateFormat DATE_TO_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static DateFormat FORMAT2 = new SimpleDateFormat("dd ММ yyyy");// 10
    private static DateFormat FORMAT3 = new SimpleDateFormat("dd.ММ.yy"); // 8
    private static DateFormat FORMAT4 = new SimpleDateFormat("dd/ММ/yyyy");// 10

    public Parser() throws IOException {
    }

    public static List<Company> loadCompany() throws IOException {
        try {
            InputStream inputStream = Main.class.getResourceAsStream("organization");
            list = new ObjectMapper().readValue(inputStream, new TypeReference<List<Company>>() {
            });
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void print() throws IOException {
        list.forEach(company -> System.out.printf("Краткое название: %s\nДата основания: %s\n========\n", company.getNameShort(), REG_DATE.format(company.getEgrul_date())));
    }

    public static void printSecurities() throws IOException {
        list.forEach(company1 -> System.out.println
                ((company1.getSecurities())));
    }

    public static void companiesAfterDate() throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Insert DATE in format ДД/ММ/ГГ ");
        int[] tmp = {0};
        String data = reader.readLine();
        Date date = FORMAT2.parse(data);
        list.forEach(company -> {
            if (company.getEgrul_date().after(date)) {
                tmp[0]++;
                System.out.printf("\nCOMPANY ID: %s\nCOMPANY NAME: %s\nDATE OF BIRTH: %s\n*******\n", company.getId(), company.getNameFull(), company.getEgrul_date());
            }
        });
        if (tmp[0] > 0) {
            System.err.println("Просрочено - " + tmp[0]);
        }
    }

    public static void isAvalible() throws IOException {
        Date today = new Date();
        list.forEach(company -> company.getSecurities().forEach(security -> {
            if (security.getDateTo().before(today)) {
                System.out.printf("NAME: %s\nDATE OF BIRTH: %s\nWAS AVAILABLE TO DAY: %s\n*****\n", company.getNameFull(), DATE_TO_FORMAT.format(company.getEgrul_date()), DATE_TO_FORMAT.format(security.getDateTo()));
            }
        }));
    }

    public static void money() throws IOException {
        System.out.println("Choose and print type: USD, RUB, EUR");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        list.forEach(company1 -> company1.getSecurities().forEach(security -> {
            if (security.getCurrency().getCode().equals(input)) {
                System.out.printf("ID: %s\nCODE: %s\n======\n", security.getCurrency().getId(), security.getCurrency().getCode());
            }
        }));
    }
}

