package laz.dimboba.library.dao;

import laz.dimboba.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
    List<Book> findAllByTitleContainingIgnoreCaseAndAuthorContainingIgnoreCase(String title, String author);
}
