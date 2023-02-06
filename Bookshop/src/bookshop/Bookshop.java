package bookshop;

import bookshop.entity.Author;
import bookshop.entity.Book;
import bookshop.entity.Borrow;
import bookshop.entity.Client;
import bookshop.entity.Editorial;
import bookshop.service.AuthorService;
import bookshop.service.BookService;
import bookshop.service.BorrowService;
import bookshop.service.ClientService;
import bookshop.service.EditorialService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Exequiel Hordt
 * @version 22 Jan 2023
 */
public class Bookshop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {

            Scanner read = new Scanner(System.in).useDelimiter("\n");
            String option;
            BookService bookService = new BookService();
            AuthorService authorService = new AuthorService();
            EditorialService editorialService = new EditorialService();
            BorrowService borrowService = new BorrowService();
            ClientService clientService = new ClientService();

            do {

                System.out.println("Libreria - Menu");
                System.out.println("***************");
                System.out.println("Elija una opcion");
                System.out.println("1)Libro");
                System.out.println("2)Autor");
                System.out.println("3)Editorial");
                System.out.println("4)Prestamo");
                System.out.println("5)Cliente");
                System.out.println("6)Salir");
                System.out.print("Opcion: ");
                option = read.next();

                switch (option) {
                    case "1":

                        System.out.println("Seccion - Libro");
                        System.out.println("***************");
                        System.out.println("Elija una opcion");
                        System.out.println("1)Alta");
                        System.out.println("2)Buscar libro por titulo");
                        System.out.println("3)Buscar libro por nombre de autor");
                        System.out.println("4)Buscar libro por nombre de editorial");
                        System.out.println("5)Buscar libro por ISBN");
                        System.out.println("6)Volver al menu");
                        System.out.print("Opcion: ");
                        option = read.next();
                        if (option.equalsIgnoreCase("1")) {
                            String tittle, authorName, editorialName;
                            Integer year, copies, borrowCopies, remainingCopies;
                            Author author;
                            Editorial editorial;
                            System.out.println("DB - Libro");
                            System.out.println("**********");
                            System.out.print("Titulo: ");
                            tittle = read.next();
                            System.out.print("Año: ");
                            year = read.nextInt();
                            System.out.print("Copias: ");
                            copies = read.nextInt();
                            System.out.print("Copias prestadas: ");
                            borrowCopies = read.nextInt();
                            remainingCopies = copies - borrowCopies;
                            System.out.println("Copias restantes: " + remainingCopies);
                            System.out.print("Autor: ");
                            authorName = read.next();
                            author = authorService.byName(authorName);
                            System.out.print("Editorial: ");
                            editorialName = read.next();
                            editorial = editorialService.byName(editorialName);
                            bookService.save(tittle, year, copies, borrowCopies, remainingCopies, author, editorial);
                            System.out.println("");
                            System.out.println("Base de Datos - Libros");
                            System.out.println("**********************");
                            bookService.print();
                        }
                        if (option.equalsIgnoreCase("2")) {

                            String tittle;
                            System.out.println("DB - Libro");
                            System.out.println("**********");
                            System.out.print("Titulo: ");
                            tittle = read.next();
                            System.out.println("Resultado");
                            System.out.println("*********");
                            bookService.byTittle(tittle);

                        }
                        if (option.equalsIgnoreCase("3")) {

                            String name;
                            System.out.println("DB - Libro");
                            System.out.println("**********");
                            System.out.print("Autor: ");
                            name = read.next();
                            System.out.println("Resultado");
                            System.out.println("*********");
                            bookService.byAuthor(name);

                        }
                        if (option.equalsIgnoreCase("4")) {

                            String name;
                            System.out.println("DB - Libro");
                            System.out.println("**********");
                            System.out.print("Editorial: ");
                            name = read.next();
                            System.out.println("Resultado");
                            System.out.println("*********");
                            bookService.byEditorial(name);

                        }
                        if (option.equalsIgnoreCase("5")) {

                            Long isbn;
                            System.out.println("DB - Libro");
                            System.out.println("**********");
                            System.out.print("ISBN: ");
                            isbn = read.nextLong();
                            System.out.println("Resultado");
                            System.out.println("*********");
                            System.out.println(bookService.byISBN(isbn));
                            System.out.println("");

                        }
                        if (option.equalsIgnoreCase("6")) {
                            System.out.println("Volviendo al menu principal...");
                            System.out.println("");
                            option = "menu";

                        }
                        break;

                    case "2":

                        System.out.println("Seccion - Autor");
                        System.out.println("***************");
                        System.out.println("Elija una opcion");
                        System.out.println("1)Alta");
                        System.out.println("2)Buscar Autor por nombre");
                        System.out.println("3)Volver al Menu");
                        System.out.print("Opcion: ");
                        option = read.next();
                        if (option.equalsIgnoreCase("1")) {

                            String name;
                            System.out.print("Nombre: ");
                            name = read.next();
                            authorService.save(name);
                            System.out.println("Base de datos - Autor");
                            System.out.println("**********");
                            authorService.print();
                        }
                        if (option.equalsIgnoreCase("2")) {

                            String name;
                            System.out.print("Autor: ");
                            name = read.next();
                            System.out.println("Resultado");
                            System.out.println("*********");
                            System.out.println(authorService.byName(name));
                        }
                        if (option.equalsIgnoreCase("3")) {
                            System.out.println("Volviendo al menu principal...");
                            System.out.println("");
                            option = "menu";
                        }

                        break;

                    case "3":

                        System.out.println("Seccion - Editorial");
                        System.out.println("***************");
                        System.out.println("Elija una opcion");
                        System.out.println("1)Alta");
                        System.out.println("2)Volver al menu");
                        System.out.print("Opcion: ");
                        option = read.next();
                        if (option.equalsIgnoreCase("1")) {

                            String name = " ";
                            System.out.print("Nombre: ");
                            name = read.next();
                            editorialService.save(name);
                            System.out.println("DB - Editorial");
                            System.out.println("**************");
                            editorialService.print();

                        }

                        if (option.equalsIgnoreCase("2")) {
                            System.out.println("Volviendo al menu principal...");
                            System.out.println("");
                            option = "menu";

                        }
                        break;

                    case "4":

                        System.out.println("Seccion-Prestamo");
                        System.out.println("****************");
                        System.out.println("Elija una opcion");
                        System.out.println("****************");
                        System.out.println("1)Registrar Prestamo (Alta)");
                        System.out.println("2)Registrar Fecha Devolucion Libro");
                        System.out.println("3)Volver al menu");
                        System.out.print("Opcion: ");
                        option = read.next();
                        if (option.equalsIgnoreCase("1")) {
                            
                            Long isbn, id;
                            int day, month, year;
                            System.out.println("Fecha");
                            System.out.println("*****");
                            System.out.print("Dia: ");
                            day = read.nextInt();
                            System.out.print("Mes: ");
                            month = read.nextInt();
                            System.out.print("Año: ");
                            year = read.nextInt();
                            Date dateBorrow = new Date(year - 1900, month - 1, day);
                            System.out.print("ISBN: ");
                            isbn = read.nextLong();
                            Book book = bookService.byISBN(isbn);
                            System.out.print("DNI: ");
                            id = read.nextLong();
                            Client client = clientService.byId(id);
                            book.setRemainingCopies(book.getRemainingCopies() - 1);
                            book.setBorrowCopies(book.getBorrowCopies() + 1);
                            bookService.update(book);
                            borrowService.save(dateBorrow, book, client);
                            System.out.println("Base de datos - Prestamo");
                            System.out.println("**********");
                            borrowService.print();
                        }
                        if (option.equalsIgnoreCase("2")) {

                            
                            Integer borrowId;
                            Borrow borrow;
                            int day, month, year;
                            System.out.print("Prestamo id: ");
                            borrowId = read.nextInt();
                            borrow = borrowService.byId(borrowId);
                            System.out.println("Fecha");
                            System.out.println("***");
                            System.out.print("Dia: ");
                            day = read.nextInt();
                            System.out.print("Mes: ");
                            month = read.nextInt();
                            System.out.print("Año: ");
                            year = read.nextInt();
                            Date dateReturning = new Date(year - 1900, month - 1 , day);
                            borrow.getBook().setRemainingCopies(borrow.getBook().getRemainingCopies() + 1);
                            borrow.getBook().setBorrowCopies(borrow.getBook().getBorrowCopies() - 1);
                            bookService.update(borrow.getBook());
                            borrowService.update(borrow, dateReturning);
                            System.out.println("Resultado");
                            System.out.println("*********");
                            borrowService.print();
                            
                        }
                        if (option.equalsIgnoreCase("3")) {
                            System.out.println("Volviendo al menu principal...");
                            System.out.println("");
                            option = "menu";
                        }
                        break;

                    case "5":

                        System.out.println("Seccion-Cliente");
                        System.out.println("***************");
                        System.out.println("1)Registrar Cliente (Alta)");
                        System.out.println("2)Volver al menu");
                        System.out.print("Opcion: ");
                        option = read.next();
                        if (option.equalsIgnoreCase("1")) {

                            String name, lastName, phoneNumber;
                            Long id;
                            System.out.print("Nombre: ");
                            name = read.next();
                            System.out.print("Apellido: ");
                            lastName = read.next();
                            System.out.print("DNI: ");
                            id = read.nextLong();
                            System.out.print("Telefono: ");
                            phoneNumber = read.next();
                            clientService.save(id, name, lastName, phoneNumber);
                            System.out.println("DB - Cliente");
                            System.out.println("**************");
                            clientService.print();

                        }

                        if (option.equalsIgnoreCase("2")) {
                            System.out.println("Volviendo al menu principal...");
                            System.out.println("");
                            option = "menu";

                        }
                        break;

                    case "6":

                        System.out.println("Saliendo del programa...");

                        break;

                    default:

                        System.out.println("La opcion ingresada no es correcta. Volviendo al menu principal...");

                        break;
                }
            } while (!option.equalsIgnoreCase("6"));
            System.out.println("Fin del programa");

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("Error de sistema " + e.getMessage());

        }
    }

}
