package com.budget.receipt.model.expense;

public class Date {
    private int day;
    private int month;
    private int year;
    private final String monthArr[] = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "November", "December"};

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return monthArr[this.month - 1] + " " + this.day + ", " + this.year;
    }

    public boolean isValidDate() {
        if(this.year > 1990 && this.year < 2050){
            if(this.month > 0 && this.month < 13)
                return isValidDay();
            else return false;
        }
        else return false;
    }

    public boolean isValidDay() {
        int numDays = 0;
        switch(this.month){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    numDays = 31;
                    break;
            case 4: case 6: case 9: case 11:
                    numDays = 30;
                    break;
            case 2:
                    if (((this.year % 4 == 0) &&
                            !(this.year % 100 == 0))
                            || (this.year % 400 == 0))
                        numDays = 29;
                    else
                        numDays = 28;
                    break;
                default:
                    System.out.println("Invalid month.");
                    break;

        }
        return (this.day > 0 && this.day <= numDays);
    }
}
