package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для отображения всех заявок.
     */
    private static final String SHOW_ALL = "1";
    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";
    /**
     * Константа меню для поиска заявки по ID.
     */
    private static final String FIND_BY_ID = "4";
    /**
     * Константа меню для поиска заявок по имени.
     */
    private static final String FIND_BY_NAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final ConsoleInput input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(ConsoleInput input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Select: ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW_ALL.equals(answer)) {
                this.printAllItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FIND_BY_ID.equals(answer)) {
                this.findItemById();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.findItemsByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        this.input.print("------------ Adding new request --------------");
        String name = this.input.ask("Enter name of request: ");
        String desc = this.input.ask("Enter description of request: ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        this.input.print("------------ New request with ID " + item.getId() + " was created.-----------");
    }

    /**
     * Метод печатает все заявки из хранилища.
     */
    private void printAllItems() {
        Item[] items = this.tracker.findAll();
        this.input.print("------------ Found " + items.length + " requests --------------");
        for (int i = 0; i < items.length; i++) {
            this.input.print("Id: " + items[i].getId());
            this.input.print("Name: " + items[i].getName());
            this.input.print("Desc: " + items[i].getDesc());
            this.input.print("----------------");
        }
    }

    /**
     * Метод редактирует заявку по id.
     */
    private void editItem() {
        this.input.print("------------ Editing request --------------");
        String id = this.input.ask("Enter id of request: ");
        Item edit = this.tracker.findById(id);
        if (edit != null) {
            String name = this.input.ask("Enter name of request: ");
            edit.setName(name);
            String desc = this.input.ask("Enter description of request: ");
            edit.setDesc(desc);
            boolean success = this.tracker.replace(id, edit);
            if (!success) {
                this.input.print("There are issues with updating request.");
            }
        } else {
            this.input.print("Request with such ID not found.");
        }
    }

    /**
     * Метод удаляет заявку по id.
     */
    private void deleteItem() {
        String id = this.input.ask("Enter id of request: ");
        boolean success = this.tracker.delete(id);
        if (!success) {
            this.input.print("There are issues with deleting request.");
        }
    }

    /**
     * Метод печатает заявку по id.
     */
    private void findItemById() {
        String id = this.input.ask("Enter id of request: ");
        Item found = this.tracker.findById(id);
        this.input.print("------------ Found request --------------");
        this.input.print("Id: " + found.getId());
        this.input.print("Name: " + found.getName());
        this.input.print("Desc: " + found.getDesc());
        this.input.print("Time: " + found.getTime());
    }

    /**
     * Метод печатает все заявки найденные по имени.
     */
    private void findItemsByName() {
        String name = this.input.ask("Enter name of request: ");
        Item[] found = this.tracker.findByName(name);
        this.input.print("------------ Found " + found.length + " requests --------------");
        for (int i = 0; i < found.length; i++) {
            this.input.print("Id: " + found[i].getId());
            this.input.print("Name: " + found[i].getName());
            this.input.print("Desc: " + found[i].getDesc());
            this.input.print("----------------");
        }
    }

    /**
     * Метод показывающий меню.
     */
    private void showMenu() {
        System.out.print("-------------- Menu. -------------\n"
                + "0. Add new item\n"
                + "1. Show all items\n"
                + "2. Edit item\n"
                + "3. Delete item\n"
                + "4. Find item by ID\n"
                + "5. Find items by name\n"
                + "6. Exit Program\n");
    }
}