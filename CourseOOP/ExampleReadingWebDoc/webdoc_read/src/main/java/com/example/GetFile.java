package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class GetFile {

    URL page;
    public GetFile() {
        try {
            page = new URL("https://www.unisa.it/");
        } catch (MalformedURLException e) {
            System.out.println("Bad URL: " + page);
        }
    }

    public static void main(String[] args) {
        URLConnection conn = null;
        BufferedReader data;
        InputStreamReader in;
        String line;
        StringBuffer buf = new StringBuffer();
        GetFile urlw = new GetFile();

        try {
            conn = urlw.page.openConnection();
            conn.connect();
            System.out.println("Connection opened");
            in = new InputStreamReader(conn.getInputStream());
            data = new BufferedReader(in);
            System.out.println("Reading data...");
            while((line=data.readLine()) != null) {
                buf.append(line + "\n");
            }
            System.out.print(buf.toString());
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}
