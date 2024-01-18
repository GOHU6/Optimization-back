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

    public static void caesarCipherResult(String message){
        String encrypted = encrypt(message, 0);
        System.out.println(encrypted);
        
        String decrypted = decrypt(encrypted, 3);
        System.out.println(decrypted);
    }

    public static void main(String[] args) {

        String message = "Hello World";

        long start =  System.nanoTime();
        caesarCipherResult(message);
        long elapsedTime = System.nanoTime() - start;

        double ms = TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
        double seconds = (double)elapsedTime / 1000000000.0;


        System.out.printf("\n---------------------\n");
        System.out.printf("Nanoseconds: %d ms\n", elapsedTime );
        System.out.printf("Miliseconds: %f ms\n", ms );
        System.out.printf("Seconds: %f ms\n", seconds);

    } 
}
