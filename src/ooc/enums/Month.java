/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooc.enums;

/**
 * THIS IS SOME LEGACY CODE THAT IS PART OF THE SYSTEM AND YOU HAVE TO USE IT.
 *
 * @author apont
 */
public enum Month {
    JANUARY(31),
    FEBRUARY(28),
    MARCH(31),
    APRIL(30),
    MAY(31),
    JUNE(30),
    JULY(31),
    AUGUST(31),
    SEPTEMBER(30),
    OCTOBER(31),
    NOVEMBER(30),
    DECEMBER(31);

    private final int numberOfDays;

    Month(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public Month next() {
        switch (this.name()) {
            case "JANUARY":
                return FEBRUARY;
            case "FEBRUARY":
                return MARCH;
            case "MARCH":
                return APRIL;
            case "APRIL":
                return MAY;
            case "MAY":
                return JUNE;
            case "JUNE":
                return JULY;
            case "JULY":
                return AUGUST;
            case "AUGUST":
                return SEPTEMBER;
            case "SEPTEMBER":
                return OCTOBER;
            case "OCTOBER":
                return NOVEMBER;
            case "NOVEMBER":
                return DECEMBER;
            default:
                return JANUARY;

        }
    }

}
