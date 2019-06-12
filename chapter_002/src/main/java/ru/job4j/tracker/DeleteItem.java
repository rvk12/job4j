package ru.job4j.tracker;

public class DeleteItem extends BaseAction {

    public DeleteItem(int key, String name) {
        super(key, name);
    }

    /**
     * Метод удаляет заявку по id.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Enter id of request: ");
        boolean success = tracker.delete(id);
        if (!success) {
            System.out.println("There are issues with deleting request.");
        }
    }

}