package uz.cherevichenko;

import java.lang.reflect.Field;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

public class RandomDateProcessor {
    public static void processRandomDate(Object obj) {
        Random random = new Random();
        Class<?> objClass = obj.getClass();

        for (Field field : objClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(RandomDate.class)) {
                RandomDate annotation = field.getAnnotation(RandomDate.class);
                long min = annotation.min();
                long max = annotation.max();
                ZoneId zoneId = ZoneId.of(annotation.zone());

                if (min >= max) {
                    throw new IllegalArgumentException("The 'min' value must be less than the 'max' value");
                }

                try {
                    field.setAccessible(true);
                    long randomTime = min + (long) (random.nextDouble() * (max - min));
                    if (field.getType().equals(Date.class)) {
                        Date randomDate = new Date(randomTime);
                        field.set(obj, randomDate);
                    } else if (field.getType().equals(LocalDate.class)) {
                        LocalDate randomLocalDate = Instant.ofEpochMilli(randomTime).atZone(zoneId).toLocalDate();
                        field.set(obj, randomLocalDate);
                    } else if (field.getType().equals(LocalDateTime.class)) {
                        LocalDateTime randomLocalDateTime = Instant.ofEpochMilli(randomTime).atZone(zoneId).toLocalDateTime();
                        field.set(obj, randomLocalDateTime);
                    } else if (field.getType().equals(Instant.class)) {
                        Instant randomInstant = Instant.ofEpochMilli(randomTime);
                        field.set(obj, randomInstant);
                    } else {
                        throw new IllegalArgumentException("The field " + field.getName() + " must be of type java.util.Date, LocalDate, LocalDateTime, or Instant to be annotated with @RandomDate");
                    }
                } catch (IllegalAccessException e) {
                    System.err.println("Failed to set value to field: " + e.getMessage());
                }
            }
        }
    }
}
