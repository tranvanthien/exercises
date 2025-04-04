package bai35;

import java.util.Date;
public class MyDate {
    // Attributes
    private int year;
    private int month;
    private int day;

    private static final String[] MONTHS = {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    private static final int[] DAYS_IN_MONTHS = {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    // Constructor
    public MyDate(int year, int month, int day) {
        if (isValidDate(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        } else {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    // Check if the year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Validate the date
    public static boolean isValidDate(int year, int month, int day) {
        if (month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
        }
        if (month == 2) {
            if (isLeapYear(year)) {
                return day <= 29;
            }
            return day <= 28;
        }
        return day <= DAYS_IN_MONTHS[month - 1];
    }

    // Get the day of the week
    public int getDayOfWeek() {
        int totalDays = calculateTotalDays();
        return (totalDays % 7); // 0 = Sunday, 1 = Monday, ..., 6 = Saturday
    }

    private int calculateTotalDays() {
        int totalDays = 0;
        for (int i = 1; i < year; i++) {
            totalDays += isLeapYear(i) ? 366 : 365;
        }
        for (int i = 1; i < month; i++) {
            totalDays += DAYS_IN_MONTHS[i - 1];
            if (i == 2 && isLeapYear(year)) {
                totalDays++; // Add the extra day for February in leap years
            }
        }
        totalDays += day;
        return totalDays;
    }

    // Getters
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    // Setters
    public void setDate(int year, int month, int day) {
        if (isValidDate(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        } else {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    public void setYear(int year) {
        if (isValidDate(year, this.month, this.day)) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    public void setMonth(int month) {
        if (isValidDate(this.year, month, this.day)) {
            this.month = month;
        } else {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    public void setDay(int day) {
        if (isValidDate(this.year, this.month, day)) {
            this.day = day;
        } else {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    // To string method
    @Override
    public String toString() {
        return String.format("%s %d %s %d",
                getDayOfWeekName(), day, MONTHS[month - 1], year);
    }

    private String getDayOfWeekName() {
        switch (getDayOfWeek()) {
            case 0: return "Sunday";
            case 1: return "Monday";
            case 2: return "Tuesday";
            case 3: return "Wednesday";
            case 4: return "Thursday";
            case 5: return "Friday";
            case 6: return "Saturday";
            default: return "";
        }
    }

    // Next day method
    public MyDate nextDay() {
        int newDay = day + 1;
        int newMonth = month;
        int newYear = year;

        if (newDay > DAYS_IN_MONTHS[month - 1] || (month == 2 && newDay == 29 && !isLeapYear(year))) {
            newDay = 1;
            newMonth += 1;
            if (newMonth > 12) {
                newMonth = 1;
                newYear += 1;
            }
        }

        return new MyDate(newYear, newMonth, newDay);
    }
}