package ua.com.alevel.servlet;
import java.awt.*;
import java.sql.Date;

import ua.com.alevel.servlet.dao.AddressDao;
import ua.com.alevel.servlet.dao.BookDao;
import ua.com.alevel.servlet.models.Address;
import ua.com.alevel.servlet.models.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


public class App {
    public static void main(String[] args) {

//        Book book = new Book();
//        book.setAuthor("Test2");
//        book.setHorizontalSize(15);
//        book.setPublisher("PublisherTest2");
//        book.setLanguage("English");
//        book.setPageCount(150);
//        book.setPrice(122);
//        book.setReseller("ResellerTest2");
//        LocalDate date = LocalDate.now();
//        book.setPublishDate(Date.valueOf(date));
//        book.setTitle("TitleTest2");
//        book.setVerticalSize(15);
//        book.setTranslated(true);
//
//
//
//        Address address = new Address();
//        address.setAddressName("Sharikova str. 57");
//        book.addAddress(address);
//        book.setAddressList(book.getAddressList());
////
//        BookDao.createBook(book.getTitle(),book.getAuthor(),book.getPublisher(),book,address);
//        Integer integer = BookDao.getBooKIdToDelete("Sharikova str. 57","TitleTest2","Test2" );
//        System.out.println(integer);
//        BookDao.deleteBook(BookDao.getBooKId("Sharikova str. 57","TitleTest2","Test2" ));

//        List<String> addresses = AddressDao.getAddressNameForCertainBook("TitleTest2","Test2");
//
//        System.out.println(addresses);
//        List<Address> addressList = AddressDao.getAllAddresses();
//        System.out.println(addressList);
//        for(Address a : addressList){
//            System.out.println(a.getBooks());
//        }


//        BookDao.update(BookDao.getBooKId("Pobedy str. 119","TitleTest2", "Test2"),125);
//        List<Address> addressList = AddressDao.getAddressNameForCertainBook("TitleTest2","Test2");
//
//        System.out.println(addressList);
//       List<Book> bookList=  BookDao.getAllBooks();
//       for(Book book: bookList){
//           System.out.println(book.getAddressList());
//       }
//        Integer oldBookId = BookDao.getBooKId("Mohnatska str. 193","SuccessTest111","SuccessTest111");
//        Book oldBook =  BookDao.getBook(oldBookId);
//        System.out.println(oldBook);

       Integer id = BookDao.getBooKId("SuccessTest2", "Vlad");
        System.out.println(id);
    }
}
