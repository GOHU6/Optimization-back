package com.group;
import org.openjdk.jmh.annotations.*;

public class TestBM {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 1)
    public void init() {
        

        CaesarCipher caesarCipher = new CaesarCipher();
        String encryptedMessage = caesarCipher.encrypt("null", 0);
        String decryptedMessage = caesarCipher.decrypt(encryptedMessage, 3);

        System.out.println("Encrypted: " + encryptedMessage);
        System.out.println("Decrypted: " + decryptedMessage); 

    }
}
