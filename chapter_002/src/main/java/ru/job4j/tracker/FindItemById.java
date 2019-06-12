package ru.job4j.tracker;

public class FindItemById extends BaseAction {

    public FindItemById(int key, String name) {
        super(key, name);
    }

    /**
     * Метод печатает заявку по id.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Enter id of request: ");
        Item found = tracker.findById(id);
        System.out.println("------------ Found request --------------");
        if (found != null) {
            System.out.println("Id: " + found.getId());
            System.out.println("Name: " + found.getName());
            System.out.println("Desc: " + found.getDesc());
            System.out.println("Time: " + found.getTime());
        } else {
            System.out.println("No results found.");
        }
    }

}