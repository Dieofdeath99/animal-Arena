import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MammalTest {
    private Mammal a;

    @BeforeEach
    public void setUp(){
        a = new Mammal("Dog", 5, 10);
    }
    @Test
    public void testConstructor(){
        Mammal a = new Mammal("Dog", 5, -5);
        assertEquals("Dog", a.getType());
        assertEquals(5, a.getStrength());
        assertEquals(0, a.getHealth());
        Mammal a2 = new Mammal("Dog", 5, 10);
        assertEquals("Dog", a2.getType());
        assertEquals(5, a2.getStrength());
        assertEquals(10, a2.getHealth());
    }

    @Test
    public void testAttack(){
        assertTrue(a.attack() >= 1);
    }

    @Test
    public void testDetailedAttack(){
        assertNotNull(a.detailedAttack());
    }

}