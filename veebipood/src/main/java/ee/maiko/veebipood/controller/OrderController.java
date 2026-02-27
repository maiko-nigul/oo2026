package ee.maiko.veebipood.controller;

import ee.maiko.veebipood.dto.OrderRowDto;
import ee.maiko.veebipood.entitiy.Order;
import ee.maiko.veebipood.entitiy.OrderRow;
import ee.maiko.veebipood.repository.OrderRepository;
import ee.maiko.veebipood.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class OrderController {

    private OrderRepository orderRepository;
    private OrderService orderService;


    //localhost:8080/products
    @GetMapping("orders")
    public List<Order> getOrder(){
        return orderRepository.findAll();
    }

    @DeleteMapping("orders/{id}")
    public List<Order> deleteOrder(@PathVariable Long id){
        orderRepository.deleteById(id); // kustutan
        return orderRepository.findAll(); // uuenenud seis
    }
    //person --> autentimise tokenist. parcelMachine --> Omnivast
    // localhosat:8080/orders/personId=1&parcelMachine=TammsaarePargiPakiautomaat
    @PostMapping("orders")
    public Order addOrder(@RequestParam Long personId,
                                @RequestParam(required = false) String parcelMachine,
                                @RequestBody List<OrderRowDto> orderRows){
        return orderService.saveOrder(personId, parcelMachine, orderRows); // siia salvestab
//        return orderRepository.findAll(); // siia uuenenud seis
    }
}
