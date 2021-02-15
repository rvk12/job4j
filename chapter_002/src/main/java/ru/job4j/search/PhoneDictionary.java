package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> p1 = (p -> p.getName().contains(key));
        Predicate<Person> p2 = (p -> p.getSurname().contains(key));
        Predicate<Person> p3 = (p -> p.getPhone().contains(key));
        Predicate<Person> p4 = (p -> p.getAddress().contains(key));
        var combine = p1.or(p2).or(p3).or(p4);
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
