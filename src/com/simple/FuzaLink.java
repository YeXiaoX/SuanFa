package com.simple;

/**
 * Created by Ivan on 2016/6/22.
 */
public class FuzaLink  implements  Cloneable{
    private FuzaLink sibLink;
    private FuzaLink next;
    private Object object;

    public FuzaLink getSibLink() {
        return sibLink;
    }

    public void setSibLink(FuzaLink sibLink) {
        this.sibLink = sibLink;
    }

    public FuzaLink getNext() {
        return next;
    }

    public void setNext(FuzaLink next) {
        this.next = next;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "FuzaLink{" +
                ", object=" + object +
                '}';
    }
}
