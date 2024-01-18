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
        String encrypted = encrypt(message, 1);
        System.out.println(encrypted);
        System.out.println("\n--------\n");
        String decrypted = decrypt(encrypted, 1);
        System.out.println(decrypted);
    }

    public static void main(String[] args) {

        String message = "8756zzzzzzzzzzzzzzzzzddddyyyyyyyyyyyyygggxxxxxxxxxxxxxxbbbbbbbbbbbbbbnnnnnnnnnnnnqqqwwwwwwwwwwrrrrrryyyyyyfffffffffuqqqqqqqqqqmmmmmmmmmmmmmmmmmmmmmmmmsjjjjjjjjjjjjjnnnnnnnqqqqfffffffffffffkkkkkccccbtttttsssssssfffffffffccccccccccccgggggggmmmmmmmmmmhhhhhhhhhhhhzzzzzzzzzwwwwwwwwwwwwwnnnnnnnnnnnnnnngggggggggggggbbbbbbbbbbbqqqttttggwwwaauuuuuuuuuuugggggoooooooooouutttttttttttttgggkkkkkkxxxxwwwwwwwwwwwwuuuuuuueeeeeeeeeeeeennnnnnnnnnnnnmmmmmmmmmxxxccccccrrrrzzzzzzzzqqqqqqqqqqqqqdddddddnnnnnnnnnnnnnoljjjjjjjjjjjkkkkkkkkkcaaajjjjjjjjjjkkkkkkkkktttyyyyyyyyyyyyyyywwwwwwwweeeeeeeeeeexxxxxxxxxxxxxxxffffjjjjjjccccccccccccccrrhhhhhhhhhhhvvvvvvvvvvvvviiiiiiiiiiiiiiggpppppkkkkkkkkkkkkkknnnnwwwwwwwwwwwbbvvvvvvvvvvvvvvydddddaaaeeeeeeeeeeeeeeeeeeyyyyyyyyyyyaammmssssssshhhhhhhhhhhhzzzqqqqqqqqqqqqqqqxxxxxxxxpppppppppppppppxxxxxxxmmmmmmmmkkkkkkkkkkkkkkdddrrrrrrrrddddddddddddddzzzzzzzzzzzzzzaaaaaammmmmmmmmmmmmmmlqqqqqqqqqpppppppppppeeeeeeiiiiiiiiiiiiiiiyyyyyyyyyyyyynnnnnnnnnnkkkkkkkkkkkkkkuuuuuuuuuuuutjjjjjssszzzzzzzzzzzzzzzzzzzddddyyyyyyyyyyyyygggxxxxxxxxxxxxxxbbbbbbbbbbbbbbnnnnnnnnnnnnqqqwwwwwwwwwwrrrrrryyyyyyfffffffffuqqqqqqqqqqmmmmmmmmmmmmmmmmmmmmmmmmsjjjjjjjjjjjjjnnnnnnnqqqqfffffffffffffkkkkkccccbtttttsssssssfffffffffccccccccccccgggggggmmmmmmmmmmhhhhhhhhhhhhzzzzzzzzzww59892wwwwwwwwwwwnnnnnnnnnnnnnnngggggggggggggbbbbbbbbbbbqqqttttggwwwaauuuuuuuuuuugggggoooooooooouutttttttttttttgggkkkkkkxxxxwwwwwwwwwwwwuuuuuuueeeeeeeeeeeeennnnnnnnnnnnnmmmmmmmmmxxxccccccrrrrzzzzzzzzqqqqqqqqqqqqqdddddddnnnnnnnnnnnnnoljjjjjjjjjjjkkkkkkkkkcaaajjjjjjjjjjkkkkkkkkktttyyyyyyyyyyyyyyywwwwwwwweeeeeeeeeeexxxxxxxxxxxxxxxffffjjjjjjccccccccccccccrrhhhhhhhhhhhvvvvvvvvvvvvviiiiiiiiiiiiiiggpppppkkkkkkkkkkkkkknnnnwwwwwwwwwwwbbvvvvvvvvvvvvvvydddddaaaeeeeeeeeeeeeeeeeeeyyyyyyyyyyyaammmssssssshhhhhhhhhhhhzzzqqqqqqqqqqqqqqqxxxxxxxxpppppppppppppppxxxxxxxmmmmmmmmkkkkkkkkkkkkkkdddrrrrrrrrddddddddddddddzzzzzzzzzzzzzzaaaaaammmmmmmmmmmmmmmlqqqqqqqqqpppppppppppeeeeeeiiiiiiiiiiiiiiiyyyyyyyyyyyyynnnnnnnnnnkkkkkkkkkkkkkkuuuuuuuuuuuutjjjjjssszzzzzzzzzzzzzzzzzzzddddyyyyyyyyyyyyygggxxxxxxxxxxxxxxbbbbbbbbbbbbbbnnnnnnnnnnnnqqqwwwwwwwwwwrrrrrryyyyyyfffffffffuqqqqqqqqqqmmmmmmmmmmmmmmmmmmmmmmmmsjjjjjjjjjjjjjnnnnnnnqqqqfffffffffffffkkkkkccccbtttttsssssssfffffffffccccccccccccgggggggmmmmmmmmmmhhhhhhhhhhhhzzzzzzzzzwwwwwwwwwwwwwnnnnnnnnnnnnnnngggggggggggggbbbbbbbbbbbqqqttttggwwwaauuuuuuussssfffffffffccccccccccccgggggggmmmmmmmmmmhhhhhhhhhhhhzzzzzzzzzwwwwwwwwwwwwwnnnnxxxxffffjjjjjjccccccccccccccrrhhhhhhhhhhhvvvvvvvvvvvvviiiiiiiiiiiiiiggpppppkkkkkkkkkkkkkknnnnwwwwwwwwwwwbbvvvvvvvvvvvvvvydddddaaaeeeeeeeeeeeeeeeeeeyyyyyyyyyyyaammmssssssshhhhhhhhhhhhzzzqqqqqqqqqqqqqqqxxxxxxxxpppppppppppppppxxxxxxxmmmmmmmmkkkkkkkkkkkkkkdddrrrrrrrrddddddddddddddzzzzzzzzzzzzzzaaaaaammmmmmmmmmmmmmmlqqqqqqqqqpppppppppppeeeeeeiiiiiiiiiiiiiiiyyyyyyyyyyyyynnnnnnnnnnkkkkkkkkkkkkkkuuuuuuuuuuuutjjjjjssszzzzzzzzzzzzzzzzzzzddddyyyyyyyyyyyyygggxxxxxxxxxxxxxxbbbbbbbbbbbbbbnnnnnnnnnnnnqqqwwwwwwwwwwrrrrrryyyyyyfffffffffuqqqqqqqqqqmmmmmmmmmmmmmmmmmmmmmmmmsjjjjjjjjjjjjjnnnnnnnqqqqfffffffffffffkkkkkccccbtttttsssssssfffffffffccccccccccccgggggggmmmmmmmmmmhhhhhhhhhhhhzzzzzzzzzwwwwwwwwwwwwwnnnnnnnnnnnnnnngggggggggggggbbbbbbbbbbbqqqttttggwwwaauuuuuuuuuuugggggoooooooooouutttttttttttttgggkkkkkkxxxxwwwwwwwwwwwwuuuuuuueeeeeeeeeeeeennnnnnnnnnnnnmmmmmmmmmxxxccccccrrrrzzzzzzzzqqqqqqqqqqqqqdddddddnnnnnnnnnnnnnoljjjjjjjjjjjkkkkkkkkkcaaajjjjjjjjjjkkkkkkkkktttyyyyyyyyyyyyyyywwwwwwwweeeeeeeeeeexxxxxxxxxxxxxxxffffjjjjjjccccccccccccccrrhhhhhhhhhhhvvvvvvvvvvvvviiiiiiiiiiiiiiggpppppkkkkkkkkkkkkkknnnnwwwwwwwwwwwbbvvvvvvvvvvvvvvydddddaaaeeeeeeeeeeeeeeeeebtttttsssssssfffffffffccccccccccccggggggjjjjjjjjjkkkkkkkkktttyyyyyyyyyyyyyyywwwwwwwweeeeeeeeeeexxxxxxxxxxxxxxxffffjjjjjjccccccccccccccrrhhhhhhhhhhhvvvvvvvvvvvvviiiiiiiiiiiiiiggpppppkkkkkkkkkkkkkknnnnwwwwwwwwwwwbbvvvvvvvvvvvvvvydddddaaaeeeeeeeeeeeeeeeeeeyyyyyyyyyyyaammmssssssshhhhhhhhhhhhzzzqqqqqqqqqqqqqqq";

        long start =  System.nanoTime();
        caesarCipherResult(message);
        long elapsedTime = System.nanoTime() - start;

        double ms = (double)elapsedTime / 1000000.0;
        double seconds = (double)elapsedTime / 1000000000.0;

        System.out.printf("\n---------------------\n");
        System.out.printf("Nanoseconds: %d \n", elapsedTime );
        System.out.printf("Miliseconds: %f \n", ms );
        System.out.printf("Seconds: %f \n", seconds);

    } 
}
