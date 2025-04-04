package bai21;

public class Main {
    public static void main(String[] args) {
        Author author = new Author("Nguyen Van A", "a@example.com", 'm');
        Book book = new Book("Java Programming", author, 299.99, 10);

        System.out.println(book);
        book.setPrice(249.99);
        book.setQty(20);
        System.out.println("Updated Book: " + book);
    }
}
