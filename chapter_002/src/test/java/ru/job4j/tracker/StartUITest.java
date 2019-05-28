package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author r.paskov
 */
public class StartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenItemIsDeletedFromTracker() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name delete", "desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenSearchByIdThenItemWithThatIdIsReturned() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name search", "desc"));
        String id = item.getId();
        Input input = new StubInput(new String[]{"4", id, "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(id).getId(), is(id));
    }

    @Test
    public void whenSearchByNameThenItemWithThatNameIsReturned() {
        Tracker tracker = new Tracker();
        String name = "test name2 search";
        Item[] item = new Item[2];
        item[0] = tracker.add(new Item("test name search", "desc"));
        item[1] = tracker.add(new Item(name, "desc"));
        Input input = new StubInput(new String[]{"5", name, "6"});
        new StartUI(input, tracker).init();
        // 1.
        for(Item found : tracker.findByName(name)) {
            assertThat(found, is(item[1]));
        }
        // 2.
        assertThat(tracker.findByName(name)[0], is(item[1]));
    }

    @Test
    public void whenFindAllThenAllItemsArePrinted() {
        Tracker tracker = new Tracker();
        String name1 = "test name search";
        String name2 = "test name2 search";
        Item[] item = new Item[2];
        item[0] = tracker.add(new Item(name1, "desc"));
        item[1] = tracker.add(new Item(name2, "desc2"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll(), is(item));
    }

}