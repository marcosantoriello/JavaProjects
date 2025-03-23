package com.example;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * A simple exercise to calculate an MD5 and a SHA256 hash
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String toEncode = "steveslist";
        String md5 = DigestUtils.md5Hex(toEncode);
        System.out.println("MD5 hash of " + toEncode + ": " + md5);

        String sha256 = DigestUtils.sha256Hex(toEncode);
        System.out.println("SHA256 hash of " + toEncode + ": " + sha256);
    }
}
