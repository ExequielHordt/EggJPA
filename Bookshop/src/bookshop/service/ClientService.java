package bookshop.service;

import bookshop.entity.Client;
import bookshop.persistence.ClientDAO;
import java.util.Collection;

/**
 *
 * @author Exequiel Hordt
 * @version 30 Jan 2023
 */
public class ClientService {

    private ClientDAO DAO;

    public ClientService() {

        this.DAO = new ClientDAO();

    }

    //Save record
    public void save(Long id, String name, String lastName, String phoneNumber) throws Exception {

        try {

            if (id <= 0) {

                throw new Exception("Debe indicar un DNI");

            }
            if (isDuplicate(id)) {

                throw new Exception("id repetido. El cliente ya existe");

            }

            if (name.trim().isEmpty() || name == null || name.length() <= 2) {

                throw new Exception("Debe indicar un nombre");

            }
            if (lastName.trim().isEmpty() || lastName == null || lastName.length() <= 2) {

                throw new Exception("Debe indicar un apellido");

            }
            if (phoneNumber.trim().isEmpty() || phoneNumber == null || phoneNumber.length() != 9) {

                throw new Exception("Debe indicar un numero de telefono");

            }
            Client client = new Client();
            client.setId(id);
            client.setName(name);
            client.setLastname(lastName);
            client.setTelephone(phoneNumber);
            DAO.save(client);

        } catch (Exception e) {

            throw e;

        }

    }

    //Print record
    public void print() throws Exception {

        try {

            Collection<Client> clients = DAO.print();
            if (clients.isEmpty() || clients == null) {

                throw new Exception("No existen registros");

            }
            for (Client client : clients) {

                System.out.println(client);
                System.out.println("");

            }

        } catch (Exception e) {

            throw e;

        }

    }

    //Search Client by ID
    public Client byId(Long id) throws Exception {

        try {

            if (id <= 0) {

                System.out.println("Indique un id valido");

            }
            Client client = DAO.byId(id);
            if (client == null) {

                throw new Exception("No existe registro");

            }
            return client;

        } catch (Exception e) {

            throw e;

        }

    }

    //Validate id 
    public boolean isDuplicate(Long id) {

        boolean flag = false;
        Collection<Client> clients = DAO.print();
        if (clients != null || !clients.isEmpty()) {
            for (Client client : clients) {

                if (client.getId() == id) {

                    flag = true;

                }

            }

        }
        return flag;

    }

}
