import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;
public class SimpleCalcTest {

    private SimpleCalc s;

    @BeforeEach
    void setUp() {
        s = new SimpleCalc();
        System.out.println("Setup completed");
    }

    @AfterEach
    void tearDown() {
        s = null;
        System.out.println("Teardown completed");
    }

    @Test
    void testAdd() {

        // Arrange
        int num1 = 5;
        int num2 = 5;

        // Act
        int result = s.add(num1, num2);

        // Assert
        assertEquals(10, result);
    }
}