package com.example;

public class Tavolo {
    private int id;
    private int numCoperti;
    private Ordine ordine;

    public Tavolo() {
        ordine = new Ordine();
    }

    public Tavolo(int id, int numCoperti) {
        this.id = id;
        this.numCoperti = numCoperti;
        ordine = new Ordine();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumCoperti() {
        return numCoperti;
    }

    public void setNumCoperti(int numCoperti) {
        this.numCoperti = numCoperti;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public double getConto() {
        return ordine.calcolaConto();
    }
}
