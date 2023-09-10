package laz.dimboba.library.dto.book;

import laz.dimboba.library.entity.Gender;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookDTO implements Serializable {
    private UUID id;
    private String title;
    private String author;
    /*
    private List<CustomerInfo> customers;


    @AllArgsConstructor
    @Data
    @NoArgsConstructor
    static class CustomerInfo implements Serializable{
        private UUID id;
        private String firstName;
        private String lastName;
        private Gender gender;
    }

     */
}
