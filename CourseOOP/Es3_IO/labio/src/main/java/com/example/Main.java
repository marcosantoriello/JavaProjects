package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        File file = new File("myFile.txt");
        try {
            file.createNewFile();
        } catch(IOException e ) {
            System.err.format("create file error: %s%n", e.getMessage());
        }
        // Operazione di lettura
        InputStream in = null;
        try {
            in = new FileInputStream(file);

            BufferedReader reader = new BufferedReader(
                new InputStreamReader(in));

            String line = null;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch(IOException e ) {
            System.err.println(e);
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}