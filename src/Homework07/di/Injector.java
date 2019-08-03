package Homework07.di;

import Homework07.dao.ClientDao;
import Homework07.dao.HumanDao;
import Homework07.dao.FileClientDao;
import Homework07.dao.FileHumanDao;
import Homework07.dao.InMemoryClientDao;
import Homework07.dao.InMemoryHumanDao;
import Homework07.factory.ClientDaoFactory;
import Homework07.factory.HumanDaoFactory;
import Homework07.handler.ConsoleHandler;

import java.lang.reflect.Field;

public class Injector {
    static Class fileClientDaoClass = FileClientDao.class;
    static Class inMemoryClientDao = InMemoryClientDao.class;
    static Class fileHumanDaoClass = FileHumanDao.class;
    static Class inMemoryHumanDao = InMemoryHumanDao.class;

    public static void injectDependency() throws IllegalAccessException {
        Class consoleHandlerClass = ConsoleHandler.class;

        Field[] fields = consoleHandlerClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == ClientDao.class) {
                injectDependencyCient(field);
            }
            if (field.getType() == HumanDao.class) {
                injectDependencyHuman(field);
            }
        }
    }

    public static void injectDependencyCient(Field field) throws IllegalAccessException {
        if (field.isAnnotationPresent(Inject.class)) {
            field.setAccessible(true);
            boolean fileDao = fileClientDaoClass.isAnnotationPresent(Component.class);
            if (fileDao) {
                System.out.println("Работа с файлами разрешена");
            }
            boolean inMemoryDao = inMemoryClientDao.isAnnotationPresent(Component.class);
            if (inMemoryDao) {
                System.out.println("Работа с ОЗУ разрешена");
            }
            ClientDao clientDao = ClientDaoFactory.getClientDao(fileDao, inMemoryDao);
            field.set(null, clientDao);
        }
    }

    public static void injectDependencyHuman(Field field) throws IllegalAccessException {
        if (field.isAnnotationPresent(Inject.class)) {
            field.setAccessible(true);
            boolean fileDao = fileHumanDaoClass.isAnnotationPresent(Component.class);
            if (fileDao) {
                System.out.println("Работа с файлами разрешена");
            }
            boolean inMemoryDao = inMemoryHumanDao.isAnnotationPresent(Component.class);
            if (inMemoryDao) {
                System.out.println("Работа с ОЗУ разрешена");
            }
            HumanDao humanDao = HumanDaoFactory.getHumanDao(fileDao, inMemoryDao);
            field.set(null, humanDao);
        }
    }
}
