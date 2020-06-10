package com.company;

import com.sun.org.apache.xpath.internal.objects.XNumber;

import static java.lang.String.format;

public class SingletonTest {

    public static void main(String[] args) {
        Renban renbanA = Renban.getInstance();
        Renban renbanB = Renban.getInstance();

        System.out.println(renbanA.getNumber());
        System.out.println(renbanB.getNumber());
        System.out.println(renbanB.getNumber());
        System.out.println(renbanA.getNumber());
        System.out.println(renbanB.getNumber());

    }
}
class Renban{
    private static Renban singleton = new Renban();
    private int number;

    private Renban(){
        number = 0000;
    }

    public static Renban getInstance(){
        return singleton;
    }
    public String getNumber(){
        number++;
        String str = String.format("%04d",number);
        return str;
    }
}
