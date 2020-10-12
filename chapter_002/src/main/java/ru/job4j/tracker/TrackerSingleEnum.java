package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public enum TrackerSingleEnum {
    INSTANCE;
    private Tracker tracker = new Tracker();

    public Tracker getTracker() {
        return tracker;
    }

}