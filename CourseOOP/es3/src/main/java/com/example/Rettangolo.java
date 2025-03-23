package com.example;

public class Rettangolo extends RettangoloBase implements Comparable<RettangoloBase> {

    public Rettangolo(double base, double altezza) {
        super(base, altezza);
    }

    @Override
    public int compareTo(RettangoloBase o) {
        return (int) this.calcolaArea() - (int) o.calcolaArea();
    }
}
