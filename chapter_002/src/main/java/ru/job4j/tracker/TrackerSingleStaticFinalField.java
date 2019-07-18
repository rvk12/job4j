package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class TrackerSingleStaticFinalField {
    private static final Tracker INSTANCE = new Tracker();

    private TrackerSingleStaticFinalField() {
    }

    public static Tracker getInstance() {
        return INSTANCE;
    }

}