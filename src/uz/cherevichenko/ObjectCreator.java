package uz.cherevichenko;

import java.lang.reflect.Constructor;

public class ObjectCreator {
    public static <T> T createObj(Class<T> tClass) {
        try {
            Constructor<T> constructor = tClass.getDeclaredConstructor();

            T obj = constructor.newInstance();
            RandomDateProcessor.processRandomDate(obj);
            return obj;
        } catch (Exception e) {
            System.err.println("ничего не получилось: " + e.getMessage());
            return null; // throw new IllegalStateException
        }
    }
}
