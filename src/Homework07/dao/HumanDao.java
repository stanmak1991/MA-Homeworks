package Homework07.dao;

import Homework07.model.Human;

public interface HumanDao {
    void save(Human client);

    Human get();
}
