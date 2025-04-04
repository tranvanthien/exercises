package bai23;

public class Main {
    public static void main(String[] args) {
        Author author = new Author("John Doe", "john@example.com");
        Book book = new Book("123-456-789", "Java Basics", author, 29.99, 5);

        System.out.println(book);
        System.out.println("Author Name: " + book.getAuthorName());

    }

}
