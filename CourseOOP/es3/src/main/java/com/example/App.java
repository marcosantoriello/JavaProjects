package com.example;

/**
 * Esercizio del laboratorio n.3 (comprende tutti e 6 i punti)
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Rettangolo r1 = new Rettangolo(3, 2);
        Rettangolo r2 = new Rettangolo(5, 7);
        Quadrato q1 = new Quadrato(3);
        Quadrato q2 = new Quadrato(6);

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(q2);
        System.out.println(q1);
        
        System.out.println("Confronto q1 con r1: " + q1.compareTo(r1));
        System.out.println("Confronto q2 con r2: " + q2.compareTo(r2));
        System.out.println("Confronto r1 con r2: " + r1.compareTo(r2));
        System.out.println("Confronto r1 con q2: " + r1.compareTo(q2));

        System.out.println("Stampo gli hash SHA-512 degli oggetti...");
        System.out.println(r1.hashClass());
        System.out.println(r2.hashClass());
        System.out.println(q1.hashClass());
        System.out.println(q2.hashClass());

        System.out.println("Stampo la codifica Base64 degli oggetti...");
        System.out.println(r1.serializza());
        System.out.println(r2.serializza());
        System.out.println(q1.serializza());
        System.out.println(q2.serializza());

    }
}
