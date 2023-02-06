package bookshop.persistence;

import bookshop.entity.Client;
import java.util.Collection;

/**
 *
 * @author Exequiel Hordt
 * @version 30 Jan 2023
 */
public class ClientDAO extends DAO<Client> {

    //Save record
    public void save(Client client) {

        connect();
        super.save(client);
        disconnect();

    }

    //Print record
    public Collection<Client> print() {

        connect();
        Collection<Client> clients = (Collection<Client>) em.createQuery("SELECT c FROM Client c").getResultList();
        disconnect();
        return clients;

    }

    //Search by id
    public Client byId(Long id) {

        connect();
        Client client = (Client) em.createQuery("SELECT c FROM Client c WHERE c.id = :id").setParameter("id", id).getSingleResult();
        disconnect();
        return client;

    }

}
