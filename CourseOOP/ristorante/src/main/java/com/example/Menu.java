package com.example;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Piatto> piatti;
    private List<Bevanda> bevande;

    public Menu() {
        this.piatti = new ArrayList<>();
        this.bevande = new ArrayList<>();
    }

    public List<Piatto> getPiatti() {
        return piatti;
    }

    public void setPiatti(List<Piatto> piatti) {
        this.piatti = piatti;
    }

    public List<Bevanda> getBevande() {
        return bevande;
    }

    public void setBevande(List<Bevanda> bevande) {
        this.bevande = bevande;
    }

    public void aggiungiPiatto(Piatto piatto) {
        this.piatti.add(piatto);
    }

    public void aggiungiBevanda(Bevanda bevanda) {
        this.bevande.add(bevanda);
    }
}
