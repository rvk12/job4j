package ru.job4j.OOP;

/**
 * @author rvk12
 * @version $Id$
 * @since 0.1
 */
public class Dentist extends Doctor{
    private String teeth[] = new String[32];

    public void setToothHealth(int num, String description) {
        teeth[num] = description;
    }
}