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

    private static final String MENU = new StringBuilder()
            .append("-------------- Menu. -------------")
            .append(System.lineSeparator())
            .append("0. Add new item")
            .append(System.lineSeparator())
            .append("1. Show all items")
            .append(System.lineSeparator())
            .append("2. Edit item")
            .append(System.lineSeparator())
            .append("3. Delete item")
            .append(System.lineSeparator())
            .append("4. Find item by ID")
            .append(System.lineSeparator())
            .append("5. Find items by name")
            .append(System.lineSeparator())
            .append("6. Exit Program")
            .toString();
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

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
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Запуск программы.
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
        System.out.println("------------ Adding new request --------------");
        String name = this.input.ask("Enter name of request: ");
        String desc = this.input.ask("Enter description of request: ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ New request with ID " + item.getId() + " was created.-----------");
    }

    /**
     * Метод печатает все заявки из хранилища.
     */
    private void printAllItems() {
        Item[] items = this.tracker.findAll();
        System.out.println("------------ Found " + items.length + " requests --------------");
        for (int i = 0; i < items.length; i++) {
            System.out.println("Id: " + items[i].getId());
            System.out.println("Name: " + items[i].getName());
            System.out.println("Desc: " + items[i].getDesc());
            System.out.println("----------------");
        }
    }

    /**
     * Метод редактирует заявку по id.
     */
    private void editItem() {
        System.out.println("------------ Editing request --------------");
        String id = this.input.ask("Enter id of request: ");
        Item edit = this.tracker.findById(id);
        if (edit != null) {
            String name = this.input.ask("Enter name of request: ");
            edit.setName(name);
            String desc = this.input.ask("Enter description of request: ");
            edit.setDesc(desc);
            boolean success = this.tracker.replace(id, edit);
            if (!success) {
                System.out.println("There are issues with updating request.");
            }
        } else {
            System.out.println("Request with such ID not found.");
        }
    }

    /**
     * Метод удаляет заявку по id.
     */
    private void deleteItem() {
        String id = this.input.ask("Enter id of request: ");
        boolean success = this.tracker.delete(id);
        if (!success) {
            System.out.println("There are issues with deleting request.");
        }
    }

    /**
     * Метод печатает заявку по id.
     */
    private void findItemById() {
        String id = this.input.ask("Enter id of request: ");
        Item found = this.tracker.findById(id);
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

    /**
     * Метод печатает все заявки найденные по имени.
     */
    private void findItemsByName() {
        String name = this.input.ask("Enter name of request: ");
        Item[] found = this.tracker.findByName(name);
        System.out.println("------------ Found " + found.length + " requests --------------");
        for (int i = 0; i < found.length; i++) {
            System.out.println("Id: " + found[i].getId());
            System.out.println("Name: " + found[i].getName());
            System.out.println("Desc: " + found[i].getDesc());
            System.out.println("----------------");
        }
    }

    /**
     * Метод показывающий меню.
     */
    private void showMenu() {
        System.out.println(MENU);
    }
}