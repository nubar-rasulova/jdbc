package org.example.random;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task02 {
    public static void main(String[] args) {
        Random rand = new Random();
        // 50 ədəd təsadüfi ədəd generate edirik, təkləri götürüb String-ə çeviririk və List formasına salırıq
        List<String> tekEdedlerListi = IntStream.generate(() -> rand.nextInt(100)) // 0-99 arasında təsadüfi ədədlər
                .limit(50)                          // Yalnız 50 ədəd alırıq
                .filter(n -> n % 2 != 0)             // Təkləri seçirik
                .mapToObj(String::valueOf)           // String-ə çeviririk
                .toList();       // List formasında toplayırıq

        // List-i çap edirik
        System.out.println("Tək ədədlər Listi: " + tekEdedlerListi);
    }
}


