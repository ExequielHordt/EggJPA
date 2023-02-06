package bookshop.persistence;

import bookshop.entity.Book;
import java.util.Collection;

/**
 *
 * @author Exequiel Hordt
 * @version 25 Jan 2023
 */
public class BookDAO extends DAO<Book> {

    //Save Record
    public void save(Book book) {

        super.save(book);

    }

    //Search By ISBN
    public Book byISBN(Long isbn) {

        connect();
        Book book = (Book) em.createQuery("SELECT b FROM Book b WHERE b.isbn = :isbn").setParameter("isbn", isbn).getSingleResult();
        disconnect();
        return book;

    }

    //Print Record
    public Collection<Book> print() {

        connect();
        Collection<Book> books = (Collection<Book>) em.createQuery("SELECT b FROM Book b").getResultList();
        disconnect();
        return books;

    }

    //Search by Author
    public Collection<Book> byAuthor(String name) {

        connect();
        Collection<Book> books = (Collection<Book>) em.createQuery("SELECT b FROM Book b JOIN b.author a WHERE a.name = :name").setParameter("name", name).getResultList();
        disconnect();
        return books;

    }

    //Search by Editorial
    public Collection<Book> byEditorial(String name) {

        connect();
        Collection<Book> books = (Collection<Book>) em.createQuery("SELECT b FROM Book b JOIN b.editorial e WHERE e.name = :name").setParameter("name", name).getResultList();
        disconnect();
        return books;

    }

    //Search by Tittle
    public Book byTittle(String tittle) {

        connect();
        Book book = (Book) em.createQuery("SELECT b FROM Book b WHERE b.tittle = :tittle").setParameter("tittle", tittle).getSingleResult();
        disconnect();
        return book;

    }
    
    //Update book
    public void update (Book book){
        
        super.update(book);
       
        
    }
    
    

}
