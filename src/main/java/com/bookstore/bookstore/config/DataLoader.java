package com.bookstore.bookstore.config;

import com.bookstore.bookstore.book.Book;
import com.bookstore.bookstore.book.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadBooks(BookRepository bookRepository) {
        return args -> {
            List<Book> initialBooks = List.of(
                    Book.builder().title("1984").author("George Orwell").isbn("9780451524935").stock(12).releaseDate(LocalDate.of(1949, 6, 8)).build(),
                    Book.builder().title("To Kill a Mockingbird").author("Harper Lee").isbn("9780061120084").stock(8).releaseDate(LocalDate.of(1960, 7, 11)).build(),
                    Book.builder().title("The Great Gatsby").author("F. Scott Fitzgerald").isbn("9780743273565").stock(15).releaseDate(LocalDate.of(1925, 4, 10)).build(),
                    Book.builder().title("Pride and Prejudice").author("Jane Austen").isbn("9780141439518").stock(10).releaseDate(LocalDate.of(1813, 1, 28)).build(),
                    Book.builder().title("The Catcher in the Rye").author("J.D. Salinger").isbn("9780316769488").stock(9).releaseDate(LocalDate.of(1951, 7, 16)).build(),
                    Book.builder().title("The Hobbit").author("J.R.R. Tolkien").isbn("9780547928227").stock(20).releaseDate(LocalDate.of(1937, 9, 21)).build(),
                    Book.builder().title("Fahrenheit 451").author("Ray Bradbury").isbn("9781451673319").stock(7).releaseDate(LocalDate.of(1953, 10, 19)).build(),
                    Book.builder().title("Moby Dick").author("Herman Melville").isbn("9781503280786").stock(5).releaseDate(LocalDate.of(1851, 11, 14)).build(),
                    Book.builder().title("War and Peace").author("Leo Tolstoy").isbn("9780199232765").stock(6).releaseDate(LocalDate.of(1869, 1, 1)).build(),
                    Book.builder().title("The Odyssey").author("Homer").isbn("9780140268867").stock(14).releaseDate(LocalDate.of(-700, 1, 1)).build(),
                    Book.builder().title("Crime and Punishment").author("Fyodor Dostoevsky").isbn("9780143058144").stock(8).releaseDate(LocalDate.of(1866, 1, 1)).build(),
                    Book.builder().title("The Brothers Karamazov").author("Fyodor Dostoevsky").isbn("9780374528379").stock(6).releaseDate(LocalDate.of(1880, 1, 1)).build(),
                    Book.builder().title("Jane Eyre").author("Charlotte Brontë").isbn("9780141441146").stock(11).releaseDate(LocalDate.of(1847, 10, 16)).build(),
                    Book.builder().title("Brave New World").author("Aldous Huxley").isbn("9780060850524").stock(13).releaseDate(LocalDate.of(1932, 8, 18)).build(),
                    Book.builder().title("The Lord of the Rings").author("J.R.R. Tolkien").isbn("9780618640157").stock(18).releaseDate(LocalDate.of(1954, 7, 29)).build(),
                    Book.builder().title("Harry Potter and the Sorcerer's Stone").author("J.K. Rowling").isbn("9780590353427").stock(25).releaseDate(LocalDate.of(1997, 6, 26)).build(),
                    Book.builder().title("The Alchemist").author("Paulo Coelho").isbn("9780061122415").stock(17).releaseDate(LocalDate.of(1988, 5, 1)).build(),
                    Book.builder().title("The Da Vinci Code").author("Dan Brown").isbn("9780307474278").stock(10).releaseDate(LocalDate.of(2003, 3, 18)).build(),
                    Book.builder().title("The Hunger Games").author("Suzanne Collins").isbn("9780439023528").stock(14).releaseDate(LocalDate.of(2008, 9, 14)).build(),
                    Book.builder().title("A Game of Thrones").author("George R.R. Martin").isbn("9780553593716").stock(12).releaseDate(LocalDate.of(1996, 8, 6)).build()
            );

            bookRepository.saveAll(initialBooks);
        };
    }
}

