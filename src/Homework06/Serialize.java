package Homework06;

import java.io.*;

public class Serialize {
    public static byte[] serializeAnimalArray(Animal[] animalArray) {
        byte[] result = null;
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream stream = new ObjectOutputStream(outputStream);
            stream.writeInt(animalArray.length);
            for (int counter = 0; counter < animalArray.length; counter++) {
                stream.writeObject(animalArray[counter]);
            }
            result = outputStream.toByteArray();
            stream.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] result;
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
            ObjectInputStream stream = new ObjectInputStream(inputStream);
            result = new Animal[stream.readInt()];
            for (int counter = 0; counter < result.length; counter++) {
                result[counter] = (Animal) stream.readObject();
            }
            stream.close();
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
        return result;
    }
}
