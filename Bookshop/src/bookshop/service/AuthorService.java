package bookshop.service;

import bookshop.entity.Author;
import bookshop.persistence.AuthorDAO;
import java.util.Collection;

/**
 *
 * @author Exequiel Hordt
 * @version 22 Jan 2023
 */
public class AuthorService {

    private AuthorDAO DAO;

    public AuthorService() {

        this.DAO = new AuthorDAO();

    }

    //Save Record
    public void save(String name) throws Exception {

        try {

            if (name.trim().isEmpty() || name == null) {
                throw new Exception("Debe indicar un nombre");
            }
            isDuplicate(name);
            Author author = new Author();
            author.setName(name);
            DAO.save(author);

        } catch (Exception e) {
            throw e;
        }
    }

    //Validate Duplicate
    public void isDuplicate(String name) throws Exception {

        try {
            if (DAO.print() != null) {
                for (Author author : DAO.print()) {
                    if (author.getName().equalsIgnoreCase(name)) {
                        throw new Exception("El nombre ya se encuentra en la base de datos");
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    //Print Record
    public void print() throws Exception {

        try {
            boolean flag = false;
            Collection<Author> authors = DAO.print();
            if (authors.isEmpty() || authors == null) {
                throw new Exception("No existen registros");
            }
            for (Author author : authors) {

                if (author.isStatus() == true) {

                    flag = true;
                    System.out.println(author);
                    System.out.println("");

                }

            }

            if (flag == false) {

                throw new Exception("No existen registros");

            }

        } catch (Exception e) {
            throw e;
        }

    }

    //Search Record By Name
    public Author byName(String name) throws Exception {

        try {

            Author author = DAO.byName(name);
            if (author == null || author.isStatus() == false) {
                throw new Exception("No existe registro");
            }
            return author;

        } catch (Exception e) {

            throw e;

        }
    }
}
