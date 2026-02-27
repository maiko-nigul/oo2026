package ee.maiko.veebipood.service;

import ee.maiko.veebipood.dto.OrderRowDto;
import ee.maiko.veebipood.entitiy.Order;
import ee.maiko.veebipood.entitiy.OrderRow;
import ee.maiko.veebipood.entitiy.Person;
import ee.maiko.veebipood.entitiy.Product;
import ee.maiko.veebipood.repository.OrderRepository;
import ee.maiko.veebipood.repository.PersonRepository;
import ee.maiko.veebipood.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class OrderService {
    //@Autowired -- Dependecy Injection
    //@RequiredArgsConstructor -- Dependecy Injection

    // tagataustal tõmmatakse sisse tema mälukohaga
    private OrderRepository orderRepository;
    private PersonRepository personRepository;
    private ProductRepository productRepository;

    public Order saveOrder(Long personId, String parcelMachine, List<OrderRowDto> orderRows){
        Order order = new Order();
        order.setCreated(new Date());
        order.setParcelMachine(parcelMachine);
//        order.setOrderRows(orderRows);
        Person person = personRepository.findById(personId).orElseThrow(); // kui isikut ei leia -- exception
        order.setPerson(person);
        order.setTotal(calculateOrderTotal(orderRows, order));
        return  orderRepository.save(order);
    }

    private double calculateOrderTotal(List<OrderRowDto> orderRows, Order order) {
        double total =0;
        List<OrderRow> orderRowsInOrder = new ArrayList<>();
        for (OrderRowDto orderRow: orderRows){
            Product product = productRepository.findById(orderRow.productId()).orElseThrow();
            total+= product.getPrice()*orderRow.quantity();

            OrderRow orderRowInOrder = new OrderRow();
            orderRowInOrder.setProduct(product);
            orderRowInOrder.setQuantity(orderRow.quantity());
            orderRowsInOrder.add(orderRowInOrder);
        }
        order.setOrderRows(orderRowsInOrder);
        return total;
    }
}
