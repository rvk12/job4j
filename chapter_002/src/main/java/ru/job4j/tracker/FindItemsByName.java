package ru.job4j.tracker;

public class FindItemsByName implements UserAction {
    @Override
    public String key() {
        return "FIND_BY_NAME";
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

    @Override
    public String info() {
        return "5. Find items by name.";
    }
}