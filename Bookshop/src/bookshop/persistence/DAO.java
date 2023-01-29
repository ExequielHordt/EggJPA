package bookshop.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Exequiel Hordt
 * @version 24 Jan 2023
 */
public class DAO<T> {

    protected final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookshopPU");
    protected EntityManager em = emf.createEntityManager();

    //Connect Databases
    protected void connect() {

        if (!em.isOpen()) {
            em = emf.createEntityManager();
        }

    }

    //Disconnect Databases
    protected void disconnect() {

        if (em.isOpen()) {
            em.close();
        }

    }

    //Save Record
    protected void save(Object object) {

        connect();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        disconnect();

    }

    //Update Record
    protected void update(Object object) {

        connect();
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
        disconnect();

    }

}
