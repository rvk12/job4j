package ru.job4j.tracker;

public class ShowItems extends BaseAction {

    public ShowItems(int key, String name) {
        super(key, name);
    }

    /**
     * Метод печатает все заявки из хранилища.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        System.out.println("------------ Found " + items.length + " requests --------------");
        for (int i = 0; i < items.length; i++) {
            System.out.println("Id: " + items[i].getId());
            System.out.println("Name: " + items[i].getName());
            System.out.println("Desc: " + items[i].getDesc());
            System.out.println("----------------");
        }
    }

}