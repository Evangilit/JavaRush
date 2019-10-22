package Tests;

import java.util.Date;

public class DateTest {

    public static void main(String[] args) {
        Date date1 = new Date();
        int year1 = date1.getYear();
        int month1 = date1.getMonth();
        int day1 = date1.getDate();

        System.out.println(String.format("Year - %d,  Month - %d, DayOfMonth - %d", year1, month1, day1));

        Date date2 = new Date(year1, month1, day1);
        int year2 = date2.getYear();
        int month2 = date2.getMonth();
        int day2 = date2.getDate();

        System.out.println(String.format("Year - %d,  Month - %d, DayOfMonth - %d", year2, month2, day2));
    }
}
