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
            if (bookRepository.count() == 0){
                List<Book> initialBooks = List.of(
                        Book.builder().title("1984").author("George Orwell").isbn("9780451524935").stock(12).releaseDate(LocalDate.of(1949, 6, 8)).price(10.99f).build(),
                        Book.builder().title("To Kill a Mockingbird").author("Harper Lee").isbn("9780061120084").stock(8).releaseDate(LocalDate.of(1960, 7, 11)).price(17.99f).build(),
                        Book.builder().title("The Great Gatsby").author("F. Scott Fitzgerald").isbn("9780743273565").stock(15).releaseDate(LocalDate.of(1925, 4, 10)).price(17.99f).build(),
                        Book.builder().title("Pride and Prejudice").author("Jane Austen").isbn("9780141439518").stock(10).releaseDate(LocalDate.of(1813, 1, 28)).price(12.99f).build(),
                        Book.builder().title("The Catcher in the Rye").author("J.D. Salinger").isbn("9780316769488").stock(9).releaseDate(LocalDate.of(1951, 7, 16)).price(8.99f).build(),
                        Book.builder().title("The Hobbit").author("J.R.R. Tolkien").isbn("9780547928227").stock(20).releaseDate(LocalDate.of(1937, 9, 21)).price(13.99f).build(),
                        Book.builder().title("Fahrenheit 451").author("Ray Bradbury").isbn("9781451673319").stock(7).releaseDate(LocalDate.of(1953, 10, 19)).price(14.99f).build(),
                        Book.builder().title("Moby Dick").author("Herman Melville").isbn("9781503280786").stock(5).releaseDate(LocalDate.of(1851, 11, 14)).price(15.99f).build(),
                        Book.builder().title("War and Peace").author("Leo Tolstoy").isbn("9780199232765").stock(6).releaseDate(LocalDate.of(1869, 1, 1)).price(16.99f).build(),
                        Book.builder().title("The Odyssey").author("Homer").isbn("9780140268867").stock(14).releaseDate(LocalDate.of(-700, 1, 1)).price(9.99f).build(),
                        Book.builder().title("Crime and Punishment").author("Fyodor Dostoevsky").isbn("9780143058144").stock(8).releaseDate(LocalDate.of(1866, 1, 1)).price(13.99f).build(),
                        Book.builder().title("The Brothers Karamazov").author("Fyodor Dostoevsky").isbn("9780374528379").stock(6).releaseDate(LocalDate.of(1880, 1, 1)).price(13.99f).build(),
                        Book.builder().title("Jane Eyre").author("Charlotte Brontë").isbn("9780141441146").stock(11).releaseDate(LocalDate.of(1847, 10, 16)).price(17.99f).build(),
                        Book.builder().title("Brave New World").author("Aldous Huxley").isbn("9780060850524").stock(13).releaseDate(LocalDate.of(1932, 8, 18)).price(15.99f).build(),
                        Book.builder().title("The Lord of the Rings").author("J.R.R. Tolkien").isbn("9780618640157").stock(18).releaseDate(LocalDate.of(1954, 7, 29)).price(10.99f).build(),
                        Book.builder().title("Harry Potter and the Sorcerer's Stone").author("J.K. Rowling").isbn("9780590353427").stock(25).releaseDate(LocalDate.of(1997, 6, 26)).price(18.99f).build(),
                        Book.builder().title("The Alchemist").author("Paulo Coelho").isbn("9780061122415").stock(17).releaseDate(LocalDate.of(1988, 5, 1)).price(16.99f).build(),
                        Book.builder().title("The Da Vinci Code").author("Dan Brown").isbn("9780307474278").stock(10).releaseDate(LocalDate.of(2003, 3, 18)).price(15.99f).build(),
                        Book.builder().title("The Hunger Games").author("Suzanne Collins").isbn("9780439023528").stock(14).releaseDate(LocalDate.of(2008, 9, 14)).price(12.99f).build(),
                        Book.builder().title("A Game of Thrones").author("George R.R. Martin").isbn("9780553593716").stock(12).releaseDate(LocalDate.of(1996, 8, 6)).price(20.00f).build(),
                        Book.builder().title("Οιδίπους Τύραννος").author("Σοφοκλής").isbn("9789604351234").stock(8).releaseDate(LocalDate.of(-429, 1, 1)).price(14.99f).build(),
                        Book.builder().title("Ο Αλέξης Ζορμπάς").author("Νίκος Καζαντζάκης").isbn("9789602213016").stock(15).releaseDate(LocalDate.of(1946, 1, 1)).price(18.50f).build(),
                        Book.builder().title("Το Τρίτο Στεφάνι").author("Πηνελόπη Δέλτα").isbn("9789602213023").stock(10).releaseDate(LocalDate.of(1932, 1, 1)).price(12.99f).build(),
                        Book.builder().title("Η Κραυγή του Γλάρου").author("Μένης Κουμανταρέας").isbn("9789602213030").stock(7).releaseDate(LocalDate.of(1982, 1, 1)).price(16.75f).build(),
                        Book.builder().title("Το Αξιον Εστί").author("Οδυσσέας Ελύτης").isbn("9789602213047").stock(5).releaseDate(LocalDate.of(1959, 1, 1)).price(13.25f).build(),
                        Book.builder().title("The Shining").author("Stephen King").isbn("9780307743657").stock(20).releaseDate(LocalDate.of(1977, 1, 28)).price(19.99f).build(),
                        Book.builder().title("The Girl on the Train").author("Paula Hawkins").isbn("9781594634024").stock(14).releaseDate(LocalDate.of(2015, 1, 13)).price(15.50f).build(),
                        Book.builder().title("The Martian").author("Andy Weir").isbn("9780553418026").stock(18).releaseDate(LocalDate.of(2014, 2, 11)).price(17.99f).build(),
                        Book.builder().title("Educated").author("Tara Westover").isbn("9780399590504").stock(12).releaseDate(LocalDate.of(2018, 2, 20)).price(16.25f).build(),
                        Book.builder().title("The Silent Patient").author("Alex Michaelides").isbn("9781250301697").stock(9).releaseDate(LocalDate.of(2019, 2, 5)).price(14.99f).build(),
                        Book.builder().title("Ομήρου Οδύσσεια").author("Όμηρος").isbn("9789602213054").stock(10).releaseDate(LocalDate.of(-800, 1, 1)).price(11.99f).build(),
                        Book.builder().title("Ιλιάδα").author("Όμηρος").isbn("9789602213061").stock(10).releaseDate(LocalDate.of(-800, 1, 1)).price(11.99f).build(),
                        Book.builder().title("Οι Αθάνατοι").author("Αντώνης Σαμαράκης").isbn("9789602213078").stock(6).releaseDate(LocalDate.of(1965, 1, 1)).price(13.75f).build(),
                        Book.builder().title("Normal People").author("Sally Rooney").isbn("9781984822185").stock(15).releaseDate(LocalDate.of(2018, 8, 28)).price(16.99f).build(),
                        Book.builder().title("Where the Crawdads Sing").author("Delia Owens").isbn("9780735219090").stock(22).releaseDate(LocalDate.of(2018, 8, 14)).price(18.50f).build(),
                        Book.builder().title("Το Νησί").author("Βικτόρια Χίσλοπ").isbn("9789604539321").stock(12).releaseDate(LocalDate.of(2005, 5, 1)).price(15.99f).build(),
                        Book.builder().title("Η Ζωή εν Τάφω").author("Στράτης Μυριβήλης").isbn("9789602104064").stock(7).releaseDate(LocalDate.of(1930, 1, 1)).price(13.99f).build(),
                        Book.builder().title("Το Τρίτο Στεφάνι").author("Κώστας Ταχτσής").isbn("9789602104071").stock(10).releaseDate(LocalDate.of(1962, 1, 1)).price(14.99f).build(),
                        Book.builder().title("Η Μικρά Αγγλία").author("Ιωάννα Καρυστιάνη").isbn("9789600332346").stock(8).releaseDate(LocalDate.of(1997, 1, 1)).price(16.99f).build(),
                        Book.builder().title("Το ποτάμι των χιλίων τυφλών").author("Πάνος Δημάκης").isbn("9789606536953").stock(6).releaseDate(LocalDate.of(2022, 2, 10)).price(17.70f).build(),
                        Book.builder().title("Λιτανεία του Χρόνου").author("Γιάννης Καλπούζος").isbn("9789605635725").stock(9).releaseDate(LocalDate.of(2021, 10, 10)).price(12.99f).build(),
                        Book.builder().title("Η αδελφότητα του Κθούλου").author("Τάσος Θεοφίλου").isbn("9789602213061").stock(8).releaseDate(LocalDate.of(2013, 1, 1)).price(11.90f).build(),
                        Book.builder().title("Το θερινό ηλιοστάσιο").author("Χρυσηίδα Δημουλίδου").isbn("9789602213054").stock(10).releaseDate(LocalDate.of(2015, 6, 21)).price(9.10f).build(),
                        Book.builder().title("Το μωρό της Λιούμπα").author("Λένα Μαντά").isbn("9786180123456").stock(11).releaseDate(LocalDate.of(2020, 3, 3)).price(14.98f).build(),
                        Book.builder().title("Γυναίκα χωρίς όνομα").author("Μαρία Τζιρίτα").isbn("9786180101010").stock(7).releaseDate(LocalDate.of(2018, 5, 15)).price(13.90f).build(),
                        Book.builder().title("The Kite Runner").author("Khaled Hosseini").isbn("9781594631931").stock(15).releaseDate(LocalDate.of(2003, 5, 29)).price(16.99f).build(),
                        Book.builder().title("Gone Girl").author("Gillian Flynn").isbn("9780307588371").stock(12).releaseDate(LocalDate.of(2012, 6, 5)).price(15.99f).build(),
                        Book.builder().title("The Road").author("Cormac McCarthy").isbn("9780307387899").stock(10).releaseDate(LocalDate.of(2006, 9, 26)).price(14.99f).build(),
                        Book.builder().title("Life of Pi").author("Yann Martel").isbn("9780156027328").stock(14).releaseDate(LocalDate.of(2001, 9, 11)).price(13.99f).build(),
                        Book.builder().title("The Book Thief").author("Markus Zusak").isbn("9780375842207").stock(13).releaseDate(LocalDate.of(2005, 3, 14)).price(15.99f).build(),
                        Book.builder().title("Norwegian Wood").author("Haruki Murakami").isbn("9780375704024").stock(8).releaseDate(LocalDate.of(1987, 9, 4)).price(12.99f).build(),
                        Book.builder().title("The Shadow of the Wind").author("Carlos Ruiz Zafón").isbn("9780143034902").stock(10).releaseDate(LocalDate.of(2001, 4, 6)).price(17.99f).build(),
                        Book.builder().title("The Goldfinch").author("Donna Tartt").isbn("9780316055444").stock(9).releaseDate(LocalDate.of(2013, 10, 22)).price(18.99f).build(),
                        Book.builder().title("Atonement").author("Ian McEwan").isbn("9780385721790").stock(7).releaseDate(LocalDate.of(2001, 9, 21)).price(14.50f).build(),
                        Book.builder().title("The Secret History").author("Donna Tartt").isbn("9781400031702").stock(11).releaseDate(LocalDate.of(1992, 9, 5)).price(16.50f).build()
                );
                bookRepository.saveAll(initialBooks);
            }

        };
    }
}

