package HW3_JSON.util;

import HW3_JSON.Main;
import HW3_JSON.model.Company;
import HW3_JSON.model.Currency;
import HW3_JSON.model.Security;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Parser {
    public static DateFormat reg_date = new SimpleDateFormat("dd/MM/YY");
    public static DateFormat date_to_format = new SimpleDateFormat("yyyy-MM-dd");
//    public static DateFormat format2 = new SimpleDateFormat("dd.ММ.yyyy");
//    public static DateFormat format3 = new SimpleDateFormat("dd.ММ.yy");
//    public static DateFormat format4 = new SimpleDateFormat("dd/ММ/yyyy");

    public static List<Company> loadCompany() throws IOException {
        InputStream inputStream = Main.class.getResourceAsStream("/organization");
        return new ObjectMapper().readValue(inputStream, new TypeReference<List<Company>>() {
        });
    }

    public static void print() throws IOException {
        loadCompany().forEach(company -> System.out.printf("Краткое название: %s\nДата основания: %s\n========\n", company.getNameShort(), reg_date.format(company.getEgrul_date())));
    }

    public static void printSecurities() throws IOException {
        List<Company> companies = (loadCompany());
        companies.forEach(company1 -> System.out.println
                ((company1.getSecurities())));
    }

    public static void companiesAfterDate() throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Insert DATE in format ДД/ММ/ГГ ");
        int tmp = 0;
        String data = reader.readLine();
        Date date = reg_date.parse(data);
        for (Company company : loadCompany()) {
            if (company.getEgrul_date().after(date)) {
                tmp++;
                System.out.printf("\nCOMPANY ID: %s\nCOMPANY NAME: %s\nDATE OF BIRTH: %s\n*******\n", company.getId(), company.getNameFull(), company.getEgrul_date());
            }
        }
        if (tmp > 0) {
            System.err.println("Просрочено - " + tmp);
        }
    }

    public static void isAvalible() throws IOException {
        Date today = new Date();
        for (Company company : loadCompany()) {
            for (Security security : company.getSecurities()) {
                if (security.getDateTo().before(today)) {
                    System.out.printf("NAME: %s\nDATE OF BIRTH: %s\nWAS AVAILABLE TO DAY: %s\n*****\n", company.getNameFull(), date_to_format.format(company.getEgrul_date()), date_to_format.format(security.getDateTo()));
                }
            }
        }
    }

    public static void money() throws IOException {
        System.out.println("Choose and print type: USD, RUB, EUR");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
//        for (Company company : loadCompany()) {
//            for (Security security : company.getSecurities()) {
//                if (security.getCurrency().getCode().equals(input)) {
//                    System.out.printf("ID: %s\nCODE: %s\n*****\n", security.getCurrency().getId(), security.getCurrency().getCode());
//                }
//                if (!security.getCurrency().getCode().equals(input)) {
//                    System.err.println("Print wright type: USD, RUB, EUR");
//                }
//            }
//        }
        loadCompany().forEach(company1 -> company1.getSecurities().forEach(security -> {
            if (security.getCurrency().getCode().equals(input)) {
                System.out.printf("ID: %s\nCODE: %s\n======\n", security.getCurrency().getId(), security.getCurrency().getCode());
            }
        }));
    }
}

