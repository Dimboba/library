package laz.dimboba.library.controller;

import laz.dimboba.library.dto.book.BookDTO;
import laz.dimboba.library.dto.book.BookDTOMapper;
import laz.dimboba.library.entity.Book;
import laz.dimboba.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
