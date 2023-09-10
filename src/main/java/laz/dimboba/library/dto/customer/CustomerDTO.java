package laz.dimboba.library.dto.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import laz.dimboba.library.entity.Gender;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements Serializable {
    private UUID id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private List<OrderInfo> orders;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static class OrderInfo implements Serializable {
        private UUID id;
        private boolean returned;
        private Timestamp orderTimestamp;
        private Timestamp returnTimestamp;
        private BookInfo book;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static class BookInfo implements Serializable {
        private UUID id;
        private String title;
        private String author;
    }
}
