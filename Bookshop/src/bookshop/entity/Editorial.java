package bookshop.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Exequiel Hordt
 * @version 23 Jan 2023
 */
@Entity
@Table(name = "editorial")
public class Editorial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "editorial_id")
    private Integer editorial_id;

    @Basic
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    private boolean status = true;

    public Editorial() {
    }

    public Editorial(Integer editorial_id, String name) {
        this.editorial_id = editorial_id;
        this.name = name;
    }

    public Integer getEditorial_id() {
        return editorial_id;
    }

    public void setEditorial_id(Integer editorial_id) {
        this.editorial_id = editorial_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Editorial{" + "editorial_id=" + editorial_id + ", name=" + name + ", status=" + status + '}';
    }

}
