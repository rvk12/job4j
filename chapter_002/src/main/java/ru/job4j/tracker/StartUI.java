package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;
    /**
     * массив с возможными ключами меню
     */
    private int[] ranges = new int[]{0, 1, 2, 3, 4, 5, 6};
    /**
     * статус программы
     */
    private boolean working = true;

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

        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions(this);
        do {
            menu.show();
            menu.select(input.ask("Select: ", ranges));
        } while (working);

    }

    public void stop() {
        this.working = false;
    }
}