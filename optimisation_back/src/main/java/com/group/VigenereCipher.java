package com.group;

//RSA Cipher Optimization in Java
public class VigenereCipher {
    public static void main(String[] args) {
        // Define the plaintext and key as strings
        String plainText = "SECURITYGOGO";
        String key = "MAIHY";

        VigenereCipher m = new VigenereCipher();

        long start =  System.nanoTime();
        m.vigenereCipherResult(plainText,key,true);
        long elapsedTime = System.nanoTime() - start;

        System.out.printf("\n---------------------\n");
        System.out.printf("Nanoseconds: %d \n", elapsedTime );
        System.out.printf("Miliseconds: %f \n", (double)elapsedTime / 1000000.0 );
        System.out.printf("Seconds: %f \n", (double)elapsedTime / 1000000000.0);

    }

    // This method expands the key to the same length as the message
    private String keyExpanding(String mess, String key){
        String result = "";
        int i = 0;
        // Repeat the key until it is the same length as the message
        while (i < mess.length()) {
            result += String.valueOf(key.charAt(i % key.length()));
            i++;
        }
        return result;
    }

    public String vigenereCipher(String plaintext, String key, boolean isEncode){
        String result="";
        String keyE = keyExpanding(plaintext, key);
        for (int i = 0; i < plaintext.length(); i++) {
            int encode;
            if (isEncode ){
                encode = keyE.charAt(i);
            }else{
                encode = -keyE.charAt(i) + 26;
            }  
            int x = (plaintext.charAt(i) + (encode)) % 26;
            result += String.valueOf((char)(x + 65));
        }
        return result;
    }
    public void vigenereCipherResult(String plainText, String key, boolean syso){
        VigenereCipher m = new VigenereCipher();
        String ciphertext = m.vigenereCipher(plainText, key, true);
        String decrypt =  m.vigenereCipher(ciphertext, key, false);

        if(syso){
            System.out.println("Maintext: " + plainText);
            System.out.println("Key: " + key);
            System.out.println("Ciphertext: " + ciphertext);
            System.out.println("Decrypted Text: " + decrypt);
        }
    }
}
