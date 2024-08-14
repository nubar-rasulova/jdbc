package org.example.functionalprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        // 2. Adım: ArrayList oluşturun ve Person nesneleri ekleyin
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Ali", 25));
        personList.add(new Person("Ayşe", 30));
        personList.add(new Person("Fatma", 35));

        // 3. Adım: Fonksiyonel arayüz kullanarak ArrayList'teki nesneleri ekrana yazdırın
        // Consumer fonksiyonel arayüzünü kullanıyoruz
        Consumer<Person> printPerson = person -> System.out.println(person);

        // ArrayList'i döngü ile gezip her bir Person nesnesini yazdırıyoruz
        personList.forEach(printPerson);
    }
}
