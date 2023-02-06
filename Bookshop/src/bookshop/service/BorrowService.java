package bookshop.service;

import bookshop.entity.Book;
import bookshop.entity.Borrow;
import bookshop.entity.Client;
import bookshop.persistence.BorrowDAO;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Exequiel Hordt
 * @version 30 Jan 2023
 */
public class BorrowService {

    private BorrowDAO DAO;

    public BorrowService() {

        this.DAO = new BorrowDAO();

    }

    //Save record
    public void save(Date dateBorrow, Book book, Client client) throws Exception {

        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date todayDate = new Date();
            String todayDateAux = format.format(todayDate);
            String dateBorrowAux = format.format(dateBorrow);
            todayDate = format.parse(todayDateAux);
            dateBorrow = format.parse(dateBorrowAux);
            if (dateBorrow == null || dateBorrow.before(todayDate)) {

                throw new Exception("Debe indicar una fecha valida");

            }
            if (book.isStatus() == false || book == null) {

                throw new Exception("Debe indicar un libro");

            }
            if(isAvalible(book) == false){
            
                throw new Exception("No hay stock");
                
            }
            if (client == null) {

                throw new Exception("Debe indicar un cliente");

            }
            Borrow borrow = new Borrow();
            borrow.setDateBorrow(dateBorrow);
            borrow.setBook(book);
            borrow.setClient(client);
            DAO.save(borrow);

        } catch (Exception e) {

            throw e;

        }

    }

    //Print record
    public void print() throws Exception {

        try {

            Collection<Borrow> borrows = DAO.print();
            if (borrows.isEmpty() || borrows == null) {

                throw new Exception("No existen registros");

            }
            for (Borrow borrow : borrows) {

                System.out.println(borrow);
                System.out.println("");

            }

        } catch (Exception e) {

            throw e;

        }

    }

    //Save returning date
    public void saveReturningDate(Borrow borrow, Date returningDate) throws Exception {

        Date currentDate = new Date();

        try {

            if (returningDate == null) {

                throw new Exception("Debe indicar una fecha de devolucion");

            }
            if (borrow == null) {

                throw new Exception("Debe indicar un prestamo");

            }
            if (currentDate.after(returningDate) || borrow.getDateBorrow().after(returningDate)) {

                throw new Exception("Fecha de devolucion incorrecta");

            }
            borrow.setDateReturning(returningDate);
            borrow.getBook().setRemainingCopies(borrow.getBook().getRemainingCopies() + 1);

        } catch (Exception e) {

            throw e;

        }

    }

    //Search by Id
    public Borrow byId(Integer id) throws Exception {

        try {

            if (id <= 0) {

                throw new Exception("Debe indicar un id");

            }
            Borrow borrow = DAO.byId(id);
            if (borrow == null) {

                throw new Exception("No existe registro");

            }
            return borrow;

        } catch (Exception e) {

            throw e;

        }

    }

    //Validate the numbers of books to borrow
    public boolean isAvalible(Book book) {

        boolean flag = true;
        if (book.getRemainingCopies() == 0) {

            flag = false;

        }
        return flag;
        
    }
    
    //Returning book
    public void update(Borrow borrow, Date dateReturning) throws Exception {
        
        try {
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String dateReturningAux = dateFormat.format(dateReturning);
            dateReturning = dateFormat.parse(dateReturningAux);
            if(borrow == null){
                
                throw new Exception("Debe indicar un prestamo");
                
            }
            
            if(borrow.getDateReturning() != null){
                
                throw new Exception("El libro ya fue devuelto");
                
            }
            
            if(dateReturning == null || dateReturning.before(borrow.getDateBorrow())){
            
                throw new Exception("Debe indicar una fecha valida");
                
            }
            
            borrow.setDateReturning(dateReturning);
            DAO.update(borrow);
            
        } catch (Exception e) {
            
            throw e;
            
        }
        
    }
}
