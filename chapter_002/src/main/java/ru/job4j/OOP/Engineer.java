package ru.job4j.OOP;

/**
 * @author rvk12
 * @version $Id$
 * @since 0.1
 */
public abstract class Engineer extends Profession{

    public Product create(Object object) {
        return new Product();
    }

}