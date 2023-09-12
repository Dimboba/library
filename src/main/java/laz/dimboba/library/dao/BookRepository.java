package laz.dimboba.library.dao;

import laz.dimboba.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
    List<Book> findAllByTitleContainingIgnoreCaseAndAuthorContainingIgnoreCase(String title, String author);

    @Query("SELECT b from Book b INNER JOIN Order o ON b.id = o.book.id " +
            "WHERE o.orderTimestamp >= :from AND o.returnTimestamp <= :to " +
            "group by b.id order by count(*) desc limit 1")
    Optional<Book> findTheMostPopularBook(Timestamp from, Timestamp to);
}
