package eshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order;

    @BeforeEach
    void setup() {
        order = new Order(1, LocalDateTime.now());
    }
    //ทดสอบ Create
    @Test
    void testCreate() {
        Order order  = new Order(2, LocalDateTime.now());
        assertEquals(2, order.getId());
    }

    void testCreateใส่idเป็นลบต้องเกิดException() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Order(-1, LocalDateTime.now()));
        assertEquals("Order ID must not be negative value", exception.getMessage());
    }
    //จบ Create

    @Test
    void testGetTotalเป็นศูนย์() {
        assertEquals(0, order.getTotal());
    }

    @Test
    void testGetTotalใส่1Item() {
        Product product = new Product(1, "Spoon", 50, 20);
        order.addItem(product, 10);
        assertEquals(product.getPrice() * 10, order.getTotal());
    }

    @Test
    void testGetTotalใส่2Item() {
        Product product1 = new Product(1, "Spoon", 50, 20);
        Product product2 = new Product(3, "Knife", 80, 20);
        order.addItem(product1, 10);
        order.addItem(product2, 5);
        assertEquals((product1.getPrice() * 10) + (product2.getPrice() * 5), order.getTotal());
    }
}