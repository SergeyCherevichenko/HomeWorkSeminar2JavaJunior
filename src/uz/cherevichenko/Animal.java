package uz.cherevichenko;

import java.time.Instant;
import java.util.Date;

public class Animal {

    private String name;
    @RandomDate(min = 1704067200000L, max = 1735689600000L)
    private Date birthDay;
    @RandomDate(min = 1704067200000L, max = 1735689600000L)
    private Instant birthMoment;

    public Animal() {
        name = "Diamond";
        birthDay = new Date(1715689600000L);
        birthMoment = Instant.ofEpochMilli(1715689600000L);
    }

    public Animal(String name, Date date) {
        this.name = name;
        this.birthDay = date;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public Instant getBirthMoment() {
        return birthMoment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public void setBirthMoment(Instant birthMoment) {
        this.birthMoment = birthMoment;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", birthMoment=" + birthMoment +
                '}';
    }
}
