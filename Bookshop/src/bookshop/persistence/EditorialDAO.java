package bookshop.persistence;

import bookshop.entity.Editorial;
import java.util.Collection;

/**
 *
 * @author Exequiel Hordt
 * @version 25 Jan 2023
 */
public class EditorialDAO extends DAO<Editorial> {

    //Save Record
    public void save(Editorial editorial) {

        super.save(editorial);

    }

    //Print Record
    public Collection<Editorial> print() {

        connect();
        Collection<Editorial> editorials = (Collection<Editorial>) em.createQuery("Select e FROM Editorial e").getResultList();
        disconnect();
        return editorials;

    }

    //Search by Name
    public Editorial byName(String name) {

        connect();
        Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.name LIKE :name").setParameter("name", name).getSingleResult();
        disconnect();
        return editorial;

    }

}
