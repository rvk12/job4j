package ru.job4j.tracker;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class SortItemTest {
    @Test
    public void whenSortByNameDescThenListIsSortedByNameDescending() {
        long created = System.currentTimeMillis();
        List<Item> items = Arrays.asList(
                new Item("test2", "testDescription", created),
                new Item("test1", "testDescription", created),
                new Item("test1", "testDescription2", created),
                new Item("atest", "testDescription", created)
        );
        Collections.sort(items, new SortByNameItemDesc());
        assertThat(items.get(0).getName(), is("test2"));
        assertThat(items.get(1).getName(), is("test1"));
        assertThat(items.get(2).getName(), is("test1"));
        assertThat(items.get(3).getName(), is("atest"));
    }

    @Test
    public void whenSortByNameAscThenListIsSortedByNameAscending() {
        long created = System.currentTimeMillis();
        List<Item> items = Arrays.asList(
                new Item("test2", "testDescription", created),
                new Item("test1", "testDescription", created),
                new Item("test1", "testDescription2", created),
                new Item("atest", "testDescription", created)
        );
        Collections.sort(items, new SortByNameItemAsc());
        assertThat(items.get(0).getName(), is("atest"));
        assertThat(items.get(1).getName(), is("test1"));
        assertThat(items.get(2).getName(), is("test1"));
        assertThat(items.get(3).getName(), is("test2"));
    }

}
