package eshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemTest {

    private double defaultProductPrice = 50;
    private int defaultOrderItemQuantity = 10;
    private Product product;
    private OrderItem orderItem;

    @BeforeEach
    void setup() {
        product = new Product(1, "Spoon", defaultProductPrice, 20);
        orderItem = new OrderItem(product, defaultOrderItemQuantity);
    }
    @Test
    void testCreate() {
        OrderItem orderItem = new OrderItem(product, 1);
        assertEquals(50,orderItem.getSubtotal());
    }
    @Test
    void testCreateใส่quantityเลขจำนวนเต็ม() {
        OrderItem orderItem = new OrderItem(product, 100);
        assertEquals(50*100,orderItem.getSubtotal());
    }

    @Test
    void testCreateใส่quantityเป็น0ต้องเกิดException() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new OrderItem(product, 0));
        assertEquals("Order item quantity must be greater than zero", exception.getMessage());
    }

    @Test
    void testCreateใส่quantityเป็นลบต้องเกิดException() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new OrderItem(product, -10));
        assertEquals("Order item quantity must be greater than zero", exception.getMessage());
    }


    @Test
    void testGetSubtotal() {
        assertEquals(defaultProductPrice * defaultOrderItemQuantity, orderItem.getSubtotal());
    }
}