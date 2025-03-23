package com.example;

import java.io.InputStream;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App 
{
    public static void main( String[] args )
    {
        Tavolo t1 = new Tavolo(1, 4);
        Tavolo t2 = new Tavolo(2, 4);
        Tavolo t3 = new Tavolo(3, 3);

        // Piatto pasta = new Piatto("pasta", 10.5);
        // Piatto lasagna = new Piatto("lasagna", 15.9);
        // Piatto pizza = new Piatto("pizza", 5.0);

        // Bevanda acquaNaturale = new Bevanda("acqua naturale", 1.5);
        // Bevanda acquaFrizzante = new Bevanda("acqua frizzante", 2.0);
        // Bevanda cocaCola = new Bevanda("coca cola", 3.5);

        Menu menu = new Menu();
        // menu.aggiungiPiatto(pasta);
        // menu.aggiungiPiatto(lasagna);
        // menu.aggiungiPiatto(pizza);
        // menu.aggiungiBevanda(acquaNaturale);
        // menu.aggiungiBevanda(cocaCola);
        // menu.aggiungiBevanda(acquaFrizzante);

        // Es. extra: aggiunta elementi nel menu salvati in "menu.json"
        try {
            InputStream inputStream = App.class.getClassLoader().getResourceAsStream("menu.json");
            if (inputStream != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(inputStream);
                JsonNode menuNode = rootNode.get("menu");
                JsonNode piattiNode = menuNode.get("piatti");
                JsonNode bevandeNode = menuNode.get("bevande");

                // aggiungo piatti al menu
                for (JsonNode piatto : piattiNode) {
                    menu.aggiungiPiatto(
                        new Piatto(piatto.get("nome").asText(), piatto.get("prezzo").asDouble()));
                }

                // aggiungo bevande al menu
                for (JsonNode bevanda : bevandeNode) {
                    menu.aggiungiBevanda(
                        new Bevanda(bevanda.get("nome").asText(), bevanda.get("prezzo").asDouble())
                    );
                }

            } else {
                System.err.println("Errore: file menu.json non trovato!");
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Stampa del menu in corso...\n");
        for (Piatto p : menu.getPiatti()) {
            System.out.println("Nome del piatto: " + p.getNome() + ", Costo: €" + p.getPrezzo());
        }
        for (Bevanda b : menu.getBevande()) {
            System.out.println("Nome della bevanda: " + b.getNome() + ", Costo: €" + b.getPrezzo());
        }
        Ordine ordine1 = new Ordine(1, 3);
        ordine1.ordinaPiatto(menu.getPiatti().get(0));
        ordine1.ordinaPiatto(menu.getPiatti().get(1));
        ordine1.ordinaPiatto(menu.getPiatti().get(2));
        ordine1.ordinaBevanda(menu.getBevande().get(0));
        ordine1.ordinaBevanda(menu.getBevande().get(1));
        ordine1.ordinaBevanda(menu.getBevande().get(2));

        System.out.println(ordine1);

    }
}
