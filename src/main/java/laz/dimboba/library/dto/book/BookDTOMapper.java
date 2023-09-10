package laz.dimboba.library.dto.book;

import laz.dimboba.library.entity.Book;
import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Service;

@Service
public class BookDTOMapper implements Function<Book, BookDTO> {
    @Override
    public BookDTO apply(Book key) {
        return new BookDTO(
                key.getId(),
                key.getTitle(),
                key.getAuthor()
        );
    }
}
