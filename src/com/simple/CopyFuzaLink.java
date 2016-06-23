package com.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ivan on 2016/6/22.
 * 复制复杂链表
 * 考察分解复杂问题的能力
 */
public class CopyFuzaLink {
    public static FuzaLink copyLink(FuzaLink head) {
        FuzaLink result = null;
        try {
            result = (FuzaLink) head.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        Map<FuzaLink, FuzaLink> results = copyNextLink(head);
        copySlibLink(head, result, results);
        return result;

    }

    public static Map<FuzaLink, FuzaLink> copyNextLink(FuzaLink head) {
        Map<FuzaLink, FuzaLink> result = new HashMap<>();
        while (head != null) {
            FuzaLink temp = null;
            try {
                temp = (FuzaLink) head.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            result.put(head, temp);
            head = head.getNext();
        }
        return result;
    }

    public static void copySlibLink(FuzaLink head, FuzaLink result, Map<FuzaLink, FuzaLink> links) {
        while (head != null) {
            FuzaLink next = head.getNext();
            FuzaLink sib = head.getSibLink();
            FuzaLink tempNext = links.get(next);
            FuzaLink tempSib = links.get(sib);
            result.setNext(tempNext);
            result.setSibLink(tempSib);
            result = result.getNext();
            head = head.getNext();
        }
    }

    public static void printLink(FuzaLink head, FuzaLink link) {
        while (link != null) {
            System.out.println(head == link);
            System.out.println(link);
            link = link.getNext();
            head = head.getNext();
        }
    }

    public static void main(String args[]) {
        FuzaLink a = new FuzaLink();
        a.setObject("a");
        FuzaLink b = new FuzaLink();
        b.setObject("b");
        FuzaLink c = new FuzaLink();
        c.setObject("c");
        FuzaLink d = new FuzaLink();
        d.setObject("d");
        FuzaLink e = new FuzaLink();
        e.setObject("e");
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(null);
        a.setSibLink(c);
        b.setSibLink(e);
        d.setSibLink(b);
        FuzaLink result = copyLink(a);
        printLink(a, result);

    }

}
