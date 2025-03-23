package com.example;

import java.util.ArrayList;
import java.util.List;

public class Ordine {
    private int id;
    private int idTavolo;
    private double conto;
    private List<Piatto> piattiOrdinati;
    private List<Bevanda> bevandeOrdinate;

    public Ordine() {
        this.piattiOrdinati = new ArrayList<>();
        this.bevandeOrdinate = new ArrayList<>();
    }

    public Ordine(int id, int idTavolo) {
        this.id = id;
        this.idTavolo = idTavolo;
        this.conto = 0;
        this.piattiOrdinati = new ArrayList<>();
        this.bevandeOrdinate = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTavolo() {
        return idTavolo;
    }

    public void setIdTavolo(int idTavolo) {
        this.idTavolo = idTavolo;
    }

    public double getConto() {
        return conto;
    }

    public void setConto(double conto) {
        this.conto = conto;
    }

    public List<Piatto> getPiattiOrdinati() {
        return piattiOrdinati;
    }

    public void setPiattiOrdinati(List<Piatto> piattiOrdinati) {
        this.piattiOrdinati = piattiOrdinati;
    }

    public List<Bevanda> getBevandeOrdinate() {
        return bevandeOrdinate;
    }

    public void setBevandeOrdinate(List<Bevanda> bevandeOrdinate) {
        this.bevandeOrdinate = bevandeOrdinate;
    }

    public double calcolaConto() {
        for (Piatto p : piattiOrdinati) {
            conto += p.getPrezzo();
        }

        for (Bevanda b : bevandeOrdinate) {
            conto += b.getPrezzo();
        }

        return conto;
    }

    public void ordinaPiatto(Piatto piatto) {
        this.piattiOrdinati.add(piatto);
    }

    public void ordinaBevanda(Bevanda bevanda) {
        this.bevandeOrdinate.add(bevanda);
    }

    @Override
    public String toString() {
        return "Ordine #" + id + " Tavolo #" + idTavolo + " Conto: €"+ calcolaConto(); 
    }
}
