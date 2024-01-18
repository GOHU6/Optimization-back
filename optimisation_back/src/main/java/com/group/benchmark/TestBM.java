package com.group.benchmark;

import org.openjdk.jmh.annotations.*;

import com.group.CaesarCipher;
import com.group.VigenereCipher;

public class TestBM {
    // Mode.AverageTime | Mode.SampleTime | Mode.SingleShotTime | Mode.Throughput
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 1)
    public void caesarCipherBM() {
        CaesarCipher caesarCipher = new CaesarCipher();
        
        String txt = "&é-è_çà#8756zbhducveijhezibfizhzox";
        caesarCipher.caesarCipherResult(txt, false);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 1)
    public void vigenereCipherBM() {
        VigenereCipher m = new VigenereCipher();
        String plainText = "INFORMATIONSECURITY";
        String key = "MAIHY";

        m.vigenereCipherResult(plainText,key,false);
    }


   
}
