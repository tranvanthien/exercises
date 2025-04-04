package bai1;

public class Date {
    private int day;
    private  int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
    public void setDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d",this.day,this.month,this.year);
    }
    public static void main(String[] args) {

        Date d1 = new Date(13, 05, 2006);
        System.out.println(d1);


        d1.setMonth(12);
        d1.setDay(19);
        d1.setYear(2006);
        System.out.println(d1);
        System.out.println("Month: " + d1.getMonth());
        System.out.println("Day: " + d1.getDay());
        System.out.println("Year: " + d1.getYear());
        d1.setDate(30, 6, 2024);
        System.out.println(d1);
    }
}