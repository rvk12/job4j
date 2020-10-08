package ru.job4j.tracker;

import java.util.List;

public class ShowItems extends BaseAction {

    public ShowItems(int key, String name) {
        super(key, name);
    }

    /**
     * Метод печатает все заявки из хранилища.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        List<Item> items = tracker.findAll();
        System.out.println("------------ Found " + items.size() + " requests --------------");
        for (Item item : items) {
            System.out.println("Id: " + item.getId());
            System.out.println("Name: " + item.getName());
            System.out.println("Desc: " + item.getDesc());
            System.out.println("----------------");
        }
    }

}