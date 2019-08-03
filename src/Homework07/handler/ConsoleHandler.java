package Homework07.handler;

import Homework07.dao.ClientDao;
import Homework07.dao.HumanDao;
import Homework07.di.Inject;
import Homework07.model.Client;
import Homework07.model.Human;

import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private static ClientDao clientDao;
    @Inject
    private static HumanDao humanDao;

    static public void handle() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1 - если вносите клиента");
            System.out.println("2 - если получаете клиента");
            System.out.println("3 - если вносите человека");
            System.out.println("4 - если получаете человека");
            System.out.println("5 - выход");
            int consoleChoice = scanner.nextInt();
            switch (consoleChoice) {
                case 1:
                    addClientInfo(scanner);
                    break;
                case 2:
                    System.out.println(clientDao.get());
                    break;
                case 3:
                    addHumanInfo(scanner);
                    break;
                case 4:
                    System.out.println(humanDao.get());
                    break;
                case 5:
                    return;
            }
        }
    }

    private static void addClientInfo(Scanner scanner) {
        System.out.println("Введите информацию о клиенте");
        System.out.println("Введите имя");
        String name = scanner.next();
        System.out.println("Введите телефон");
        String phone = scanner.next();
        Client client = new Client(name, phone);
        clientDao.save(client);
    }

    private static void addHumanInfo(Scanner scanner) {
        System.out.println("Введите информацию о человеке");
        System.out.println("Введите имя");
        String name = scanner.next();
        System.out.println("Введите фамилию");
        String surname = scanner.next();
        System.out.println("Введите возраст");
        int age = scanner.nextInt();
        Human human = new Human(name, surname, age);
        humanDao.save(human);
    }
}
