package ru.job4j.tracker;

public class UpdateItem implements UserAction {
    @Override
    public String key() {
        return "EDIT";
    }

    /**
     * Метод редактирует заявку по id.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Editing request --------------");
        String id = input.ask("Enter id of request: ");
        Item edit = tracker.findById(id);
        if (edit != null) {
            String name = input.ask("Enter name of request: ");
            edit.setName(name);
            String desc = input.ask("Enter description of request: ");
            edit.setDesc(desc);
            boolean success = tracker.replace(id, edit);
            if (!success) {
                System.out.println("There are issues with updating request.");
            }
        } else {
            System.out.println("Request with such ID not found.");
        }
    }

    @Override
    public String info() {
        return "2. Edit item.";
    }
}