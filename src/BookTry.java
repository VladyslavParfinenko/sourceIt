

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookTry {
    private final int bookId;
    private final String bookName;
    private final String bookAuthor;
    private final String publishingHouse;
    private final int yearOfPublishing;
    private final int numberOfPages;
    private final String bindingType;
    private int price;


    BookTry(int bookId, String bookName, String bookAuthor, String publishingHouse, int yearOfPublishing, int numberOfPages, int price, String bindingType) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.publishingHouse = publishingHouse;
        this.yearOfPublishing = yearOfPublishing;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.bindingType = bindingType;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBindingType() {
        return bindingType;
    }

    @Override
    public String toString() {
        return "Book: " +
                " BookId = " + bookId +
                " BookName = " + bookName +
                " BookAuthor = " + bookAuthor +
                " PublishingHouse = " + publishingHouse +
                " YearOfPublishing = " + yearOfPublishing +
                " NumberOfPages = " + numberOfPages +
                " Price = " + price +
                " BindingType = " + bindingType;


    }
}

class BookMain {


    public static void main(String[] args) {


        BookTry LOTR = new BookTry(
                001,
                "Властели́н коле́ц",
                " Дж.Р.Р.Толкин",
                "George Allen & Unwin (Великобритания)",
                1954,
                1273,
                560,
                "HARD");

        BookTry SW = new BookTry(
                002,
                "Звёздные во́йны",
                "Джордж Лукас",
                "Xcom",
                1970,
                1021,
                840,
                "HARD");

        BookTry[] books = {LOTR, SW};

        System.out.println("Книги Дж.Р.Р.Толкин: " + LOTR.getBookName());
        System.out.println("Книги Xcom: " + SW.getBookName());
        System.out.println("Книги после 1930: " + LOTR.getBookName() + "," + SW.getBookName());


    }



}
