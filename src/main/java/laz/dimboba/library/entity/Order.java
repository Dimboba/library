package laz.dimboba.library.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "returned")
    private boolean returned;

    @Column(name = "order_timestamp")
    private Timestamp orderTimestamp;

    @Column(name = "return_timestamp")
    private Timestamp returnTimestamp;
}
