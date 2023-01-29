/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop.service;

import bookshop.entity.Author;
import bookshop.entity.Book;
import bookshop.entity.Editorial;
import bookshop.persistence.BookDAO;
import java.util.Collection;

/**
 *
 * @author Exequiel Hordt
 * @version 22 Jan 2023
 */
public class BookService {

    private BookDAO DAO;

    public BookService() {

        this.DAO = new BookDAO();

    }

    //Save Record
    public void save(String tittle, Integer year, Integer copies, Integer borrowCopies, Integer remainingCopies, Author author, Editorial editorial) throws Exception {

        try {

            if (tittle.trim().isEmpty() || tittle == null) {

                throw new Exception("Debe indicar un titulo");

            }

            if (year < 1900 || year > 2024) {

                throw new Exception("Debe indicar un año valido");

            }

            if (copies < 0) {

                throw new Exception("Debe indicar una cantidad de copias validas");

            }

            if (borrowCopies < 0) {

                throw new Exception("Debe indicar una cantidad de copias prestadas validas");

            }

            if (remainingCopies < 0) {

                throw new Exception("Debe indicar una cantidad de copias restantes validas");

            }

            if (author == null) {

                throw new Exception("Debe indicar un autor valido");

            }

            if (editorial == null) {

                throw new Exception("Debe indicar una editorial valida");

            }

            Book book = new Book();
            book.setTittle(tittle);
            book.setYear(year);
            book.setCopies(copies);
            book.setBorrowCopies(borrowCopies);
            book.setRemainingCopies(remainingCopies);
            book.setAuthor(author);
            book.setEditorial(editorial);
            DAO.save(book);

        } catch (Exception e) {

            throw e;

        }

    }

    //Search by ISBN
    public void byISBN(Long isbn) throws Exception {

        try {

            if (isbn <= 0) {
                throw new Exception("Debe indicar el codigo ISBN");
            }

            Book book = DAO.byISBN(isbn);

            if (book == null || book.isStatus() == false) {
                throw new Exception("No existe registro");
            }

            System.out.println(book);
            System.out.println("");

        } catch (Exception e) {

            throw e;

        }

    }

    //Print Record
    public void print() throws Exception {

        try {

            boolean flag = false;
            Collection<Book> books = DAO.print();
            if (books == null || books.isEmpty()) {
                throw new Exception("No existen registros");
            }

            for (Book book : books) {

                if (book.isStatus() != false) {

                    flag = true;
                    System.out.println(book);
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

    //Search by Author
    public void byAuthor(String name) throws Exception {

        try {

            if (name.trim().isEmpty() || name == null) {

                throw new Exception("Debe indicar un nombre");

            }
            Collection<Book> books = DAO.byAuthor(name);
            if (books.isEmpty() || books == null) {

                throw new Exception("No existen registros");

            }
            for (Book book : books) {

                if (book.isStatus() != false) {

                    System.out.println(book);
                    System.out.println("");

                }

            }

        } catch (Exception e) {

            throw e;

        }

    }

    //Search by Editorial
    public void byEditorial(String name) throws Exception {

        try {

            boolean flag = false;
            if (name.trim().isEmpty() || name == null) {

                throw new Exception();

            }

            Collection<Book> books = DAO.byEditorial(name);
            if (books.isEmpty() || books == null) {

                throw new Exception("No existen registros");

            }
            for (Book book : books) {

                if (book.isStatus() == true) {
                    flag = true;
                    System.out.println(book);
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

    //Search by Tittle
    public void byTittle(String tittle) throws Exception {

        try {

            if (tittle.trim().isEmpty() || tittle == null) {

                throw new Exception("Debe indicar un titulo");

            }
            Book book = DAO.byTittle(tittle);
            if (book == null || book.isStatus() == false) {

                throw new Exception("No existe registro");

            }
            System.out.println(book);
            System.out.println("");

        } catch (Exception e) {

            throw e;

        }

    }

}
