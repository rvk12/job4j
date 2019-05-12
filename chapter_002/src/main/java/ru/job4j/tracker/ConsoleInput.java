package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput {

    public String ask(String question) {
        System.out.print(question);
        return new Scanner(System.in).nextLine();
    }

    public void print(String data) {
        System.out.println(data);
    }


}