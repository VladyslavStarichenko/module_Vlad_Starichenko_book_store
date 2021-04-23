package ua.com.alevel.servlet.models;



import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "price")
    private int price;

    @Column(name = "publishDate")
    private Date publishDate;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "reseller")
    private String reseller;

    @Column(name = "pageCount")
    private int pageCount;

    @Column(name = "verticalSize")
    private int verticalSize;

    @Column(name = "horizontalSize")
    private int horizontalSize;

    @Column(name = "weight")
    private int weight;

    @Column(name = "language")
    private String language;

    @Column(name = "isTranslated")
    private boolean isTranslated;


    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    @JoinTable(
            name = "book_address",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private List<Address> addressList = new ArrayList<>();

    public Book(String title, String author, int price, Date publishDate, String publisher, String reseller, int pageCount, int verticalSize, int horizontalSize, int weight, String language, boolean isTranslated) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.publishDate = publishDate;
        this.publisher = publisher;
        this.reseller = reseller;
        this.pageCount = pageCount;
        this.verticalSize = verticalSize;
        this.horizontalSize = horizontalSize;
        this.weight = weight;
        this.language = language;
        this.isTranslated = isTranslated;
    }

    public Book(String title, String author, int price, Date publishDate, String publisher, String reseller, int pageCount, int verticalSize, int horizontalSize, int weight, String language, boolean isTranslated, List<Address> addressList) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.publishDate = publishDate;
        this.publisher = publisher;
        this.reseller = reseller;
        this.pageCount = pageCount;
        this.verticalSize = verticalSize;
        this.horizontalSize = horizontalSize;
        this.weight = weight;
        this.language = language;
        this.isTranslated = isTranslated;
        this.addressList = addressList;
    }

    public void addAddress(Address address) {
        addressList.add(address);
        address.getBooks().add(this);

    }

    public void removeAddress(Address address) {
        addressList.remove(address);
        address.getBooks().remove(this);
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", publishDate=" + publishDate +
                ", publisher='" + publisher + '\'' +
                ", reseller='" + reseller + '\'' +
                ", pageCount=" + pageCount +
                ", verticalSize=" + verticalSize +
                ", horizontalSize=" + horizontalSize +
                ", weight=" + weight +
                ", language='" + language + '\'' +
                ", isTranslated=" + isTranslated +
                ", addressList=" + addressList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getReseller() {
        return reseller;
    }

    public void setReseller(String reseller) {
        this.reseller = reseller;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getVerticalSize() {
        return verticalSize;
    }

    public void setVerticalSize(int verticalSize) {
        this.verticalSize = verticalSize;
    }

    public int getHorizontalSize() {
        return horizontalSize;
    }

    public void setHorizontalSize(int horizontalSize) {
        this.horizontalSize = horizontalSize;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isTranslated() {
        return isTranslated;
    }

    public void setTranslated(boolean translated) {
        isTranslated = translated;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public Book() {
    }
}
