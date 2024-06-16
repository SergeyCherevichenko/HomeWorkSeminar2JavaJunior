package uz.cherevichenko;



import java.time.ZoneId;
import java.util.Date;

public class Dog extends Animal {
    private String name;

    private ZoneId zone;
    @RandomDate(min = 1704067200000L, max = 1735689600000L)
    private Date birthDay;

    public Dog() {
        super();
        this.name = "Buddy";
        this.zone = ZoneId.of("Europe/Moscow");
        this.birthDay = new Date();
    }

    public Dog(String name, Date date, ZoneId zone) {
        super(name, date);
        this.zone = zone;
    }

    @Override
    public String getName() {
        return name;
    }

    public ZoneId getZone() {
        return zone;
    }

    @Override
    public Date getBirthDay() {
        return birthDay;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setZone(ZoneId zone) {
        this.zone = zone;
    }

    @Override
    public void setBirthDay(Date date) {
        this.birthDay = date;
    }

    public void setBirthDay(long timeInMillis) {
        this.birthDay = new Date(timeInMillis);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", zone=" + zone +
                ", birthDay=" + birthDay +
                '}';
    }
}
