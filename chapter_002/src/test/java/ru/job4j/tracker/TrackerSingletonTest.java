package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TrackerSingletonTest {
    @Test
    public void whenSingletonEnumOnlyOneInstanceCreated() {
        TrackerSingleEnum trackerFirst = TrackerSingleEnum.INSTANCE;
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        trackerFirst.getTracker().add(item);
        TrackerSingleEnum trackerSecond = TrackerSingleEnum.INSTANCE;
        Item result = trackerSecond.getTracker().findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
        assertTrue(trackerFirst == trackerSecond);
    }

    @Test
    public void whenSingletonStaticOnlyOneInstanceCreated() {
        Tracker trackerFirst = TrackerSingleStatic.getInstance();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        trackerFirst.add(item);
        Tracker trackerSecond = TrackerSingleStatic.getInstance();
        Item result = trackerSecond.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
        assertTrue(trackerFirst == trackerSecond);
    }

    @Test
    public void whenSingletonStaticFinalFieldOnlyOneInstanceCreated() {
        Tracker trackerFirst = TrackerSingleStaticFinalField.getInstance();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        trackerFirst.add(item);
        Tracker trackerSecond = TrackerSingleStaticFinalField.getInstance();
        Item result = trackerSecond.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
        assertTrue(trackerFirst == trackerSecond);
    }

    @Test
    public void whenSingletonStaticFinalClassOnlyOneInstanceCreated() {
        Tracker trackerFirst = TrackerSingleStaticFinalClass.getInstance();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        trackerFirst.add(item);
        Tracker trackerSecond = TrackerSingleStaticFinalClass.getInstance();
        Item result = trackerSecond.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
        assertTrue(trackerFirst == trackerSecond);
    }

}