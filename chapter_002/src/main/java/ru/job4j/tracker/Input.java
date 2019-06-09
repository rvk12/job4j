package ru.job4j.tracker;

/**
 * @author r.paskov
 */
public interface Input {

    String ask(String question);

    int ask(String question, int[] range);
}