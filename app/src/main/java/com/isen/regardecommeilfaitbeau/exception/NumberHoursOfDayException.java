package com.isen.regardecommeilfaitbeau.exception;

public class NumberHoursOfDayException extends Exception{

    public NumberHoursOfDayException(){
        super("number of hours per day must be equals to 24");
    }

}
