package Homework07.dao;

import Homework07.di.Component;
import Homework07.model.Human;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryHumanDao implements HumanDao {
    private static final List<Human> inMemoryStorage = new ArrayList<>();

    @Override
    public void save(Human human) {
        inMemoryStorage.add(human);
    }

    @Override
    public Human get() {
        return inMemoryStorage.get(0);
    }
}
