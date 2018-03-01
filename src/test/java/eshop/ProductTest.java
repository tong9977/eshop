package eshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product product;

    @BeforeEach
    void setup() {
        product = new Product(1, "Spoon", 50, 20);
    }

    //ทดสอบ Create
    @Test
    void testCreateถ้าidเป็นลบต้องเกิดException() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Product(-1, "Fork", 50, 20));
        assertEquals("Product ID must not be negative value", exception.getMessage());
    }

    @Test
    void testCreateถ้าnameเป็นspacesหมดต้องเกิดException() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Product(2, "   ", 50, 20));
        assertEquals("Product name must not be empty", exception.getMessage());
    }

    @Test
    void testCreateถ้าnameเป็นค่าว่างต้องเกิดException() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Product(2, "", 50, 20));
        assertEquals("Product name must not be empty", exception.getMessage());
    }

    @Test
    void testCreateถ้าpriceเป็นลบต้องเกิดException() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Product(2, "Fork", -50, 20));
        assertEquals("Product price must not be negative value", exception.getMessage());
    }

    @Test
    void testCreateถ้าquantityเป็นลบต้องเกิดException() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Product(2, "Fork", 50, -20));
        assertEquals("Product quantity must not be negative value", exception.getMessage());
    }
    //จบ Create

    //ทดสอบ addQuantity
    @Test
    void testAddQuantityถ้าใส่ลบมาต้องเกิดException() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> product.addQuantity(-10));
        assertEquals("Quantity must be greater than zero", exception.getMessage());
    }


    @Test
    void testAddQuantityถ้าใส่0มาต้องเกิดException() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> product.addQuantity(0));
        assertEquals("Quantity must be greater than zero", exception.getMessage());
    }

    @Test
    void testAddQuantityเป็นจำนวนเต็มบวก() {
        product.addQuantity(10);
        assertEquals(30, product.getQuantity());
    }


}