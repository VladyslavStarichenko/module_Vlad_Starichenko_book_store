package ua.com.alevel.servlet.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "address")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "address_name")
    private String addressName;

    @ManyToMany(mappedBy = "addressList")
    private List<Book> books = new ArrayList<>();




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", addressName='" + addressName + '\'' +
                '}';
    }

    public Address(String addressName, List<Book> addressList) {
        this.addressName = addressName;
        this.books = addressList;
    }
}
