package ru.job4j.tracker;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author r.paskov
 */
public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private static final String MENU = new StringBuilder()
            .append("0. Add new item.")
            .append(System.lineSeparator())
            .append("1. Show all items.")
            .append(System.lineSeparator())
            .append("2. Edit item.")
            .append(System.lineSeparator())
            .append("3. Delete item.")
            .append(System.lineSeparator())
            .append("4. Find item by ID.")
            .append(System.lineSeparator())
            .append("5. Find items by name.")
            .append(System.lineSeparator())
            .append("6. Exit program.")
            .append(System.lineSeparator())
            .toString();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
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
        String id = item[1].getId();
        Input input = new StubInput(new String[]{"5", name, "6"});
        new StartUI(input, tracker).init();
        Assert.assertThat(
                this.out.toString(),
                is(new StringBuilder()
                        .append(MENU)
                        .append("------------ Found 1 requests --------------")
                        .append(System.lineSeparator())
                        .append("Id: ")
                        .append(id)
                        .append(System.lineSeparator())
                        .append("Name: test name2 search")
                        .append(System.lineSeparator())
                        .append("Desc: desc")
                        .append(System.lineSeparator())
                        .append("----------------")
                        .append(System.lineSeparator())
                        .append(MENU)
                        .append("Program is being closed.")
                        .append(System.lineSeparator())
                        .toString())
        );
    }

    @Test
    public void whenFindAllThenAllItemsArePrinted() {
        Tracker tracker = new Tracker();
        String name1 = "test name search";
        String name2 = "test name2 search";
        Item[] item = new Item[2];
        item[0] = tracker.add(new Item(name1, "desc"));
        item[1] = tracker.add(new Item(name2, "desc2"));
        String id1 = item[0].getId();
        String id2 = item[1].getId();
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        Assert.assertThat(
                this.out.toString(),
                is(new StringBuilder()
                        .append(MENU)
                        .append("------------ Found 2 requests --------------")
                        .append(System.lineSeparator())
                        .append("Id: ")
                        .append(id1)
                        .append(System.lineSeparator())
                        .append("Name: test name search")
                        .append(System.lineSeparator())
                        .append("Desc: desc")
                        .append(System.lineSeparator())
                        .append("----------------")
                        .append(System.lineSeparator())
                        .append("Id: ")
                        .append(id2)
                        .append(System.lineSeparator())
                        .append("Name: test name2 search")
                        .append(System.lineSeparator())
                        .append("Desc: desc2")
                        .append(System.lineSeparator())
                        .append("----------------")
                        .append(System.lineSeparator())
                        .append(MENU)
                        .append("Program is being closed.")
                        .append(System.lineSeparator())
                        .toString())
        );
    }
}