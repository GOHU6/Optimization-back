package com.group.benchmark;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.*;

import com.group.CaesarCipher;
import com.group.RSACipher;
import com.group.VigenereCipher;



public class TestBM {
    // Mode.AverageTime | Mode.Throughput | Mode.SingleShotTime | Mode.SampleTime 
    // temps moyen d’exécution | vitesse moyenne d’exécution | @Measurement time et @Warmup ignoré | temps moyens sur des échantillons d’invocations

    private static String plaintext = "SECURITYGOGO";

    // Fork value to specify the number of forks to run
    // Warmup annotation to warm up the JVM before starting the benchmark
    // Measurement annotation to specify the number of iterations and the time to measure

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 10, time = 2000, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 20, time = 2000, timeUnit = TimeUnit.MILLISECONDS)
    public void caesarCipherBM() {
        // Create a new instance of CaesarCipher
        CaesarCipher caesarCipher = new CaesarCipher();
        
        caesarCipher.caesarCipherResult(plaintext, false);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 10, time = 2000, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 20, time = 2000, timeUnit = TimeUnit.MILLISECONDS) 
    public void vigenereCipherBM() {
        // Create a new instance of VigenereCipher
        VigenereCipher vigenereCipher = new VigenereCipher();
        // Define the key
        String key = "MAIHY";

        vigenereCipher.vigenereCipherResult(plaintext,key,false);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 10, time = 2000, timeUnit = TimeUnit.MILLISECONDS) 
    @Measurement(iterations = 20, time = 2000, timeUnit = TimeUnit.MILLISECONDS)
    public void rsaCipherBM() throws Exception {
        // Create a new instance of RSACipher
        RSACipher rsaCipher = new RSACipher();

        rsaCipher.rsaCipherResult(plaintext,false);
    }


   
}
