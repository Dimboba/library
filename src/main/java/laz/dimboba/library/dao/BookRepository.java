package laz.dimboba.library.dao;

import laz.dimboba.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {


    List<Book> findAllByTitleAndAuthor(String title, String author);

}
