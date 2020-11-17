package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 35));
        users.add(new User("Ivan", 31));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Ivan", 35)));
        assertThat(it.next(), is(new User("Petr", 32)));
    }

    @Test
    public void whenDesc() {
        Set<User> users = new TreeSet<>(Comparator.reverseOrder());
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 35));
        users.add(new User("Ivan", 31));
        users.add(new User("Petr", 40));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Petr", 40)));
        assertThat(it.next(), is(new User("Petr", 32)));
        assertThat(it.next(), is(new User("Ivan", 35)));
        assertThat(it.next(), is(new User("Ivan", 31)));
    }


    @Test
    public void whenComparePertVSIvan() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparePertVSPetr() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Petr", 31)
                );
        assertThat(rsl, greaterThan(0));
    }

}