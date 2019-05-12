package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteThenReturnTrueAndItemNotFound() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 1234L);
        tracker.add(second);
        Item third = new Item("test3", "testDescription3", 1236L);
        tracker.add(third);
        boolean result = tracker.delete(second.getId());
        assertThat(result, is(true));
        Item[] delete = tracker.findByName("test2");
        for (Item item : delete) {
            Assert.assertNull(item.getName());
        }
    }

    @Test
    public void whenFindByNameThenReturnItemWithName() {
        Tracker tracker = new Tracker();
        Item first = new Item("test", "testDescription", 123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 1234L);
        tracker.add(second);
        Item[] result = tracker.findByName("test2");
        for (Item item : result) {
            assertThat(item.getName(), is("test2"));
        }
    }

    @Test
    public void whenFindAllThenReturnAllItems() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 1234L);
        tracker.add(second);
        Item third = new Item("test3", "testDescription3", 1235L);
        tracker.add(third);
        Item[] result = tracker.findAll();
        assertThat(result[0].getName(), is("test1"));
        assertThat(result[1].getName(), is("test2"));
        assertThat(result[2].getName(), is("test3"));
    }
}