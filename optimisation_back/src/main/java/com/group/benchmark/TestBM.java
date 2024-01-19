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

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 10, time = 2000, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 20, time = 2000, timeUnit = TimeUnit.MILLISECONDS)
    public void caesarCipherBM() {
        CaesarCipher caesarCipher = new CaesarCipher();
        
        caesarCipher.caesarCipherResult(plaintext, false);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 10, time = 2000, timeUnit = TimeUnit.MILLISECONDS) 
    @Measurement(iterations = 20, time = 2000, timeUnit = TimeUnit.MILLISECONDS)
    public void vigenereCipherBM() {
        VigenereCipher vigenereCipher = new VigenereCipher();
        String key = "MAIHY";

        vigenereCipher.vigenereCipherResult(plaintext,key,false);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 10, time = 2000, timeUnit = TimeUnit.MILLISECONDS) 
    @Measurement(iterations = 20, time = 2000, timeUnit = TimeUnit.MILLISECONDS)
    public void rsaCipherBM() throws Exception {
        RSACipher rsaCipher = new RSACipher();

        rsaCipher.rsaCipherResult(plaintext,false);
    }


   
}
