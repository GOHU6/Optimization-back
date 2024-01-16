package com.group;

public class Main {

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
        System.out.println("test");
        String message = "Hello World";

        String encrypted = encrypt(message, 3);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypt(encrypted, 3)); 
    }
}
