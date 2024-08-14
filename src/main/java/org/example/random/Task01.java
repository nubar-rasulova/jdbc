package org.example.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task01 {
    public static void main(String[] args) {
        List<Integer> num = new ArrayList<Integer>();

        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            num.add(rand.nextInt(100));

        }
        System.out.println("Eded siyahisi : " + num);

        // Ən böyük və ən kiçik ədədi tapmaq üçün ilkin dəyərlər təyin edilir
        int max = num.get(0);
        int min = num.get(0);

        // Siyahıda dövr olunur və ən böyük və ən kiçik ədəd tapılır
        for (int i = 1; i < num.size(); i++) {
            if (num.get(i) > max) {
                max = num.get(i);
            }
            if (num.get(i) < min) {
                min = num.get(i);
            }
        }

        // Ən böyük və ən kiçik ədədi ekrana yazdırır
        System.out.println("Ən böyük ədəd: " + max);
        System.out.println("Ən kiçik ədəd: " + min);
    }

}
