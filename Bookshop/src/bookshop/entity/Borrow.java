package bookshop.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Exequiel Hordt
 * @version 30 Jan 2023
 */
@Entity
@Table(name = "borrow")
public class Borrow implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id")            
    Integer borrowId;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "date_borrow")
    Date dateBorrow;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_returning")
    Date dateReturning = null;

    @OneToOne
    @JoinColumn(name = "isbn", referencedColumnName = "isbn")
    Book book;

    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    Client client;

    public Borrow() {
    }

    public Borrow(Integer borrowId, Date dateBorrow, Book book, Client client) {
        this.borrowId = borrowId;
        this.dateBorrow = dateBorrow;
        this.book = book;
        this.client = client;
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public Date getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(Date dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public Date getDateReturning() {
        return dateReturning;
    }

    public void setDateReturning(Date dateReturning) {
        this.dateReturning = dateReturning;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Borrow{" + "borrowId=" + borrowId + ", dateBorrow=" + dateBorrow + ", dateReturning=" + dateReturning + ", book=" + book + ", client=" + client + '}';
    }

}
