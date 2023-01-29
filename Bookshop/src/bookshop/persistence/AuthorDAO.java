package bookshop.persistence;

import bookshop.entity.Author;
import java.util.Collection;

/**
 *
 * @author Exequiel Hordt
 * @version 24 Jan 2023
 */
public class AuthorDAO extends DAO<Author> {

    //Save Record
    public void save(Author author) {
        super.save(author);
    }

    //Print Record
    public Collection<Author> print() {
        connect();
        Collection<Author> authors = (Collection<Author>) em.createQuery("SELECT a FROM Author a").getResultList();
        disconnect();
        return authors;

    }

    //Search Record By Name
    public Author byName(String name) {

        connect();
        Author author = (Author) em.createQuery("SELECT a FROM Author a WHERE a.name LIKE :name").setParameter("name", name ).getSingleResult();
        disconnect();
        return author;

    }

}
