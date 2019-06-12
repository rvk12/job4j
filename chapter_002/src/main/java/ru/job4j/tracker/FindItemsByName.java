package ru.job4j.tracker;

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
        Item[] found = tracker.findByName(name);
        System.out.println("------------ Found " + found.length + " requests --------------");
        for (int i = 0; i < found.length; i++) {
            System.out.println("Id: " + found[i].getId());
            System.out.println("Name: " + found[i].getName());
            System.out.println("Desc: " + found[i].getDesc());
            System.out.println("----------------");
        }
    }

}