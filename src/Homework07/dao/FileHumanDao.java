package Homework07.dao;

import Homework07.di.Component;
import Homework07.model.Human;

import java.io.*;

@Component
public class FileHumanDao implements HumanDao {

    public void save(Human human) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("humanStorage.dat"))) {
            objectOutputStream.writeObject(human);
        } catch (IOException e) {
            System.out.println("Не удалось записать клиента в базу");
        }
    }

    public Human get() {
        try (ObjectInputStream inputObjectStream = new ObjectInputStream(new FileInputStream("humanStorage.dat"))) {
            return (Human) inputObjectStream.readObject();
        } catch (Exception e) {
            System.out.println("Человек не найден в системе");
            return null;
        }
    }
}
