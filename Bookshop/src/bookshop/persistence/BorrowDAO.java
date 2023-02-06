package bookshop.persistence;

import bookshop.entity.Borrow;
import java.util.Collection;

/**
 *
 * @author Exequiel Hordt
 * @version 30 Jan 2023
 */
public class BorrowDAO extends DAO<Borrow> {

    //Save record
    public void save(Borrow borrow) {

        connect();
        super.save(borrow);
        disconnect();

    }

    //Print record
    public Collection<Borrow> print() {

        connect();
        Collection<Borrow> borrows = (Collection<Borrow>) em.createQuery("SELECT b FROM Borrow b").getResultList();
        disconnect();
        return borrows;

    }
    
    //Search by Id
    public Borrow byId(Integer id){
        
        connect();
        Borrow borrow = (Borrow) em.createQuery("SELECT b FROM Borrow b WHERE b.borrowId = :id").setParameter("id", id).getSingleResult();
        disconnect();
        return borrow;
        
    }
    
    //Update borrow
    public void update(Borrow borrow){
        
        super.update(borrow);
        
    }
}
