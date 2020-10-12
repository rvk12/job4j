package ru.job4j.oop;

/**
 * @author rvk12
 * @version $Id$
 * @since 0.1
 */
public class Doctor extends Profession {
    private String hospital;

    public Diagnose heal(Pacient pacient) {
        return new Diagnose();
    }

    public String getHospital() {
        return this.hospital;
    }

}