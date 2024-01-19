package com.group;

//Caesar Cipher Optimization in Java
public class CaesarCipher {
    public static void main(String[] args) {
        String message = "SECURITYGOGO";

        CaesarCipher caesarCipher = new CaesarCipher();

        long start =  System.nanoTime(); // get the current time in nanoseconds
        caesarCipher.caesarCipherResult(message, true); // encrypt the message
        long elapsedTime = System.nanoTime() - start; // calculate the elapsed time

        System.out.printf("\n---------------------\n");
        System.out.printf("Nanoseconds: %d \n", elapsedTime );
        System.out.printf("Miliseconds: %f \n", (double)elapsedTime / 1000000.0 );
        System.out.printf("Seconds: %f \n", (double)elapsedTime / 1000000000.0);

    }

    // encrypt the given text using a Caesar cipher with the given shift value
    public String encrypt(String text, int shift) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) ((chars[i] + shift) % 256);
        }
        return new String(chars);
    }

    // decrypt the given text using a Caesar cipher with the given shift value
    public String decrypt(String text, int shift) {
        return encrypt(text, 256 - shift);
    }

    public void caesarCipherResult(String message, boolean syso){
        String encrypted = encrypt(message, 1);
        String decrypted = decrypt(encrypted, 1);

        if(syso){
            System.out.println("Encrypt\n"+encrypted);
            System.out.println("\n--------\n");
            System.out.println("Decrypt\n"+decrypted);
        }

    }
}
