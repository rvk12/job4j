package ru.job4j.tracker;

import java.util.List;

public class FindItemsByName extends BaseAction {

    public FindItemsByName(int key, String name) {
        super(key, name);
    }

    /**
     * Метод печатает все заявки найденные по имени.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Enter name of request: ");
        List<Item> found = tracker.findByName(name);
        System.out.println("------------ Found " + found.size() + " requests --------------");
        for (Item item : found) {
            System.out.println("Id: " + item.getId());
            System.out.println("Name: " + item.getName());
            System.out.println("Desc: " + item.getDesc());
            System.out.println("----------------");
        }
    }

}