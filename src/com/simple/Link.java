package com.simple;

/**
 * Created by Ivan on 2016/6/4.
 */
public class Link {
    private String value;
    private Link next;
    private int intValue;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }
}