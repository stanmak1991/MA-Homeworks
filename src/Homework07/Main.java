package Homework07;

import Homework07.di.Injector;
import Homework07.handler.ConsoleHandler;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        Injector.injectDependency();
        ConsoleHandler.handle();
    }
}
