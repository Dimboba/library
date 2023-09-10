package laz.dimboba.library.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO implements Serializable {
    private UUID id;
    private boolean returned;
    private Timestamp orderTimestamp;
    private Timestamp returnTimeStamp;
    private BookInfo book;
    private CustomerInfo customer;


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static class BookInfo implements Serializable {
        private UUID id;
        private String title;
        private String author;
    }
    @AllArgsConstructor
    @Data
    @NoArgsConstructor
    static class CustomerInfo implements Serializable{
        private UUID id;
        private String firstName;
        private String lastName;
    }
}
