import org.junit.Test;
import static org.junit.Assert.*;
public class AssertionTest {
    SimpleCalc s = new SimpleCalc();
    @Test
    public void testAssertions() {

        // Assert Equals
        assertEquals(10, s.add(5, 5));

        // Assert True
        assertTrue(s.add(2, 3) > 4);

        // Assert False
        assertFalse(s.subtract(5, 3) > 5);

        // Assert Null
        String str = null;
        assertNull(str);

        // Assert Not Null
        assertNotNull(s);
    }
}