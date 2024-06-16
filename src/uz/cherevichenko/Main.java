//package uz.cherevichenko;
//
//import java.io.File;
//import java.lang.reflect.Constructor;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.lang.reflect.Parameter;
//import java.util.ArrayList;
//
//import java.util.Date;
//import static uz.cherevichenko.RandomDateProcessor.processRandomDate;
//
//public class Main {
//    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        String packageName = Main.class.getPackage().getName();
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        String path = packageName.replace('.', '/');
//        File directory = new File(classLoader.getResource(path).getFile());
//        ArrayList<Class<?>> classes = new ArrayList<>();
//        for (File file : directory.listFiles()) {
//            if (file.getName().endsWith(".class")) {
//                String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
//
//                try {
//                    Class<?> clazz = null;
//                    clazz = Class.forName(className);
//                    System.out.println(clazz);
//                    classes.add(clazz);
//                } catch (ClassNotFoundException e) {
//                    throw new RuntimeException(e);
//                }
//
//            }
//
//
//        }
//        Class<?> animalClass = classes.get(0);
//        Constructor<?>[] animalConstructors = animalClass.getDeclaredConstructors();
//        for (Constructor<?> constructor : animalConstructors) {
//            System.out.println("Constructor: " + constructor.getName());
//            System.out.println("Parameter count: " + constructor.getParameterCount());
//        }
//        Parameter [] parameters = animalConstructors[1].getParameters();
//        for (int i = 0; i < parameters.length; i++) {
//            System.out.println(parameters[i]);
//
//        }
//        Object animal = animalConstructors[0].newInstance();
////        Method[] methods = animal.getClass().getDeclaredMethods();
////        for (int i = 0; i < methods.length; i++) {
////            System.out.println(methods[i]);
////        }
//        Method methodGetName = animal.getClass().getMethod("getName");
//        Method methodGetBirthDay = animal.getClass().getMethod("getBirthDay");
//
//        Object result = methodGetName.invoke(animal);
//        Object result2 = methodGetBirthDay.invoke(animal);
//        System.out.println(result + "  " + result2);
//
//        processRandomDate(animal); // Обработка аннотации для установки случайного значения в birthDay
//
//        result = methodGetName.invoke(animal);
//        result2 = methodGetBirthDay.invoke(animal);
//        System.out.println(result + "  " + result2);
//        Object cat = animalConstructors[1].newInstance("Барсик",new Date(2018,11,10));
//        result =  methodGetName.invoke(cat);
//        result2 = methodGetBirthDay.invoke(cat);
//        System.out.println(result + "  " + result2);
//        processRandomDate(cat);
//        result =  methodGetName.invoke(cat);
//        result2 = methodGetBirthDay.invoke(cat);
//        System.out.println(result + "  " + result2);
//
//                Animal animal1 = new Animal();
//                Person person = new Person();
//        System.out.println(animal1);
//        System.out.println(person);
//
//                RandomDateProcessor.processRandomDate(animal1);
//                RandomDateProcessor.processRandomDate(person);
//
//                System.out.println(animal1);
//                System.out.println(person);
//            }
//        }
//
//
package uz.cherevichenko;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Animal animal = ObjectCreator.createObj(Animal.class);
        Person person = ObjectCreator.createObj(Person.class);
        Dog dog = ObjectCreator.createObj(Dog.class);

        if (animal != null) {
            System.out.println("До анотации: " + animal);
            RandomDateProcessor.processRandomDate(animal);
            System.out.println("После анотации: " + animal);
        } else {
            System.err.println("Не удалось создать обьект Animal.");
        }

        if (person != null) {
            System.out.println("До анотации: " + person);
            RandomDateProcessor.processRandomDate(person);
            System.out.println("После анотации: " + person);
        } else {
            System.err.println("Не удалось создать обьект Person.");
        }

        if (dog != null) {
            System.out.println("До анотации: " + dog);
            RandomDateProcessor.processRandomDate(dog);
            System.out.println("После анотации: " + dog);
        } else {
            System.err.println("Не удалось создать обьект Dog.");
        }
    }
}


