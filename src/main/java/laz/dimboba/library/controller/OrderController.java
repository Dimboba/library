package laz.dimboba.library.controller;

import laz.dimboba.library.dto.order.OrderDTO;
import laz.dimboba.library.dto.order.OrderDTOMapper;
import laz.dimboba.library.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController{
    private final OrderService orderService;
    private final OrderDTOMapper orderDTOMapper;

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrder(
            @PathVariable UUID id
    ){
        return ResponseEntity.ok(
                orderDTOMapper.apply(
                    orderService.getOrder(id)
            )
        );
    }

    @PostMapping("/create")
    public ResponseEntity<OrderDTO> createOrder(
            @RequestParam(value = "customerId", required = true) UUID customerId,
            @RequestParam(value = "bookId", required = true) UUID bookId
    ){
        return ResponseEntity.ok(
                orderDTOMapper.apply(
                        orderService.createOrder(customerId, bookId)
                )
        );
    }

    @PostMapping("/return/{id}")
    public ResponseEntity<OrderDTO> returnOrder(
            @PathVariable UUID id
    ){
        return ResponseEntity.ok(
                orderDTOMapper.apply(
                        orderService.returnBook(id)
                )
        );
    }
}
