package laz.dimboba.library.controller;

import laz.dimboba.library.dto.book.BookDTO;
import laz.dimboba.library.dto.book.BookDTOMapper;
import laz.dimboba.library.entity.Book;
import laz.dimboba.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController {
    private final BookDTOMapper bookDTOMapper;
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookDTO> saveBook(
            @RequestBody BookDTO bookDTO
    ){
        return ResponseEntity.ok(
                bookDTOMapper.apply(
                    bookService.saveBook(
                            Book.builder()
                                    .title(bookDTO.getTitle())
                                    .author(bookDTO.getAuthor())
                                    .build()
                    )
                )
        );
    }


    //Time in millis
    @GetMapping("/popular")
    public ResponseEntity<BookDTO> getMostPopularBook(
            @RequestParam(value = "from") Long from,
            @RequestParam(value = "to") Long to
    ){
        return ResponseEntity.ok(
                bookDTOMapper.apply(
                        bookService.getMostPopularBook(
                                Timestamp.from(Instant.ofEpochMilli(from)),
                                Timestamp.from(Instant.ofEpochMilli(to))
                        )
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBook(
            @PathVariable UUID id
    ){
        return ResponseEntity.ok(
                bookDTOMapper.apply(
                        bookService.getBook(id)
                )
        );
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getBooksByName(
        @RequestParam(value = "title", defaultValue = "") String title,
        @RequestParam(value = "author", defaultValue = "") String author
    ){
        return ResponseEntity.ok(
                bookService.getBooksByTitleAndAuthor(title, author)
                        .stream()
                        .map(bookDTOMapper::apply)
                        .toList()
        );
    }


    @PutMapping
    public ResponseEntity<BookDTO> updateBook(
            @RequestBody BookDTO bookDTO
    ) {
        return ResponseEntity.ok(
                bookDTOMapper.apply(
                        bookService.updateBook(
                                Book.builder()
                                        .title(bookDTO.getTitle())
                                        .id(bookDTO.getId())
                                        .author(bookDTO.getAuthor())
                                        .build()
                        )
                )
        );
    }
}
