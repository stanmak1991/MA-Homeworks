package Homework07.dao;

import Homework07.model.Client;

public interface ClientDao {
    void save(Client client);

    Client get();
}
