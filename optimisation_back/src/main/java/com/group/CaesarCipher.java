package com.group;

import java.util.concurrent.TimeUnit;

//Caesar Cipher Optimization in Java
public class CaesarCipher {

    public static String encrypt(String text, int shift) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) ((chars[i] + shift) % 256);
        }
        return new String(chars);
        
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 256 - shift);
    }
    public static void main(String[] args) {

        String message = "Hello World";

        long start =  System.nanoTime();
        String encrypted = encrypt(message, 3);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypt(encrypted, 3)); 

        long elapsedTime = System.nanoTime() - start;

        double seconds = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
        double secondDecimalPrecision = (double)elapsedTime / 1000000000.0;
        double ms = TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
        double minutes = TimeUnit.MINUTES.convert(elapsedTime, TimeUnit.NANOSECONDS);

        System.out.printf("\n---------------------\n");
        System.out.printf("Nanoseconds: %d ms\n", elapsedTime );
        System.out.printf("Miliseconds: %f ms\n", ms );
        System.out.printf("Seconds: %f ms\n", seconds);
        System.out.printf("Seconds2: %f ms\n", secondDecimalPrecision);
        System.out.printf("Minutes: %f ms\n", minutes);
    }
}
