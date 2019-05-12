package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод обновляющий ячейку в массиве новым объектом
     *
     * @param id поиск объекта для замены по атрибуту id объекта
     * @param item объект на который будет заменен старый объект
     * @return возвращает true, если замена произошла
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i != position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                this.items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод удаляющий ячейку в массиве по атрибуту id объекта
     *
     * @param id поиск объекта для замены по id
     * @return возвращает true, если объект удален из ячейки
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i != position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, this.items.length - i - 1);
                this.position--;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * @return возвращает список всех элементов массива
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, position);
    }

    /**
     * @param key атрибут name объектов по которому выбираются элементы
     * @return возвращает список всех элементов массива по key
     */
    public Item[] findByName(String key) {
        Item[] found = new Item[position + 1];
        int index = 0;
        for (Item item : this.items) {
            if (item != null && item.getName().equals(key)) {
                found[index] = item;
                index++;
            }
        }
        return Arrays.copyOf(found, index);
    }

    /**
     * @param id атрибут id объектов по которому выбираются элементы
     * @return элемент у которого совпадает id
     * */
    public Item findById(String id) {
        Item found = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                found = item;
                break;
            }
        }
        return found;
    }
}