package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Список для хранение заявок.
     */
    private List<Item> items = new ArrayList<>();

    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
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
     * Метод обновляющий ячейку в списке новым объектом
     *
     * @param id поиск объекта для замены по атрибуту id объекта
     * @param item объект на который будет заменен старый объект
     * @return возвращает true, если замена произошла
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        int position = this.items.size();
        for (int i = 0; i != position; i++)
            if (this.items.get(i) != null && this.items.get(i).getId().equals(id)) {
                this.items.set(i, item);
                result = true;
                break;
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
        for (Item item : this.items){
            if(item != null && item.getId().equals(id)){
                this.items.remove(item);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * @return возвращает список всех элементов массива
     */
    public List<Item> findAll() {
        return this.items;
    }

    /**
     * @param key атрибут name объектов по которому выбираются элементы
     * @return возвращает список всех элементов массива по key
     */
    public List<Item> findByName(String key) {
        List<Item> found = new ArrayList<>();
        for (Item item : this.items){
            if (item != null && item.getName().equals(key)){
                found.add(item);
            }
        }
        return found;
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