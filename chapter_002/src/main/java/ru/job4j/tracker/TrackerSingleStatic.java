package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class TrackerSingleStatic {
    private static Tracker instance;

    private TrackerSingleStatic() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }
}