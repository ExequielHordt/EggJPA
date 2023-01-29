package bookshop.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Exequiel Hordt
 * @version 24 Jan 2023
 */
@Entity
@Table(name = "book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "isbn")
    private Long isbn;

    @Basic
    @Column(name = "tittle")
    private String tittle;
    @Column(name = "year")
    private Integer year;
    @Column(name = "copies")
    private Integer copies;
    @Column(name = "borrowCopies")
    private Integer borrowCopies;
    @Column(name = "remainingCopies")
    private Integer remainingCopies;
    @Column(name = "status")
    private boolean status = true;

    @OneToOne
    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    private Author author;

    @OneToOne
    @JoinColumn(name = "editorial_id", referencedColumnName = "editorial_id")
    private Editorial editorial;

    public Book() {
    }

    public Book(Long isbn, String tittle, Integer year, Integer copies, Integer borrowCopies, Integer remainingCopies, Author author, Editorial editorial) {
        this.isbn = isbn;
        this.tittle = tittle;
        this.year = year;
        this.copies = copies;
        this.borrowCopies = borrowCopies;
        this.remainingCopies = remainingCopies;
        this.author = author;
        this.editorial = editorial;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public Integer getBorrowCopies() {
        return borrowCopies;
    }

    public void setBorrowCopies(Integer borrowCopies) {
        this.borrowCopies = borrowCopies;
    }

    public Integer getRemainingCopies() {
        return remainingCopies;
    }

    public void setRemainingCopies(Integer remainingCopies) {
        this.remainingCopies = remainingCopies;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Book{" + "isbn=" + isbn + ", tittle=" + tittle + ", year=" + year + ", copies=" + copies + ", borrowCopies=" + borrowCopies + ", remainingCopies=" + remainingCopies + ", status=" + status + ", author=" + author + ", editorial=" + editorial + '}';
    }

}
