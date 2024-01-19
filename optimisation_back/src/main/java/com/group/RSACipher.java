package com.group;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

public class RSACipher {
    public static void main(String[] args) throws Exception {
        String plainText = "INFORMATIONSECURITY";

        RSACipher r = new RSACipher();

        long start =  System.nanoTime();
        r.rsaCipherResult(plainText, true);
        long elapsedTime = System.nanoTime() - start;

        System.out.printf("\n---------------------\n");
        System.out.printf("Nanoseconds: %d \n", elapsedTime );
        System.out.printf("Miliseconds: %f \n", (double)elapsedTime / 1000000.0 );
        System.out.printf("Seconds: %f \n", (double)elapsedTime / 1000000000.0);
        
    }

    // Fonction pour générer une paire de clés
    private KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        return keyGen.generateKeyPair();
    }

    // Fonction pour chiffrer
    private byte[] encrypt(Cipher cipher, String input) throws Exception {
        return cipher.doFinal(input.getBytes());
    }

    // Fonction pour déchiffrer
    private byte[] decrypt(Cipher cipher, byte[] cipherText) throws Exception {
        return cipher.doFinal(cipherText);
    }

    public void rsaCipherResult(String plainText, boolean syso) throws Exception{
        RSACipher rsaCipher = new RSACipher();
        // Étape 1 : Générer une paire de clés
        KeyPair keyPair = rsaCipher.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        // Étape 2 : Chiffrer
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] cipherText = rsaCipher.encrypt(encryptCipher, plainText);

        // Étape 3 : Déchiffrer
        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] decryptedText = rsaCipher.decrypt(decryptCipher, cipherText);
        
        if (syso) {
            System.out.println("Plaintext: " + new String(plainText) + "\n");
            System.out.println( new String(cipherText)+ "\n");
            System.out.println("Decrypted Text: " + new String(decryptedText)+ "\n");
        }
        
    }

}
