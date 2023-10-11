import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class AnimalTest {
    private Animal a;
    @BeforeEach
    public void setUp(){
        a = new Animal();
    }
    @Test
    public void testDefaultConstructor(){
        Animal a = new Animal();
        assertEquals("", a.getType());
        assertEquals(1, a.getStrength());
        assertEquals(10, a.getHealth());
    }
    @Test
    public void testPerameterizedConstructor(){
        Animal a = new Animal("Dog", 5, 15);
        assertEquals("Dog", a.getType());
        assertEquals(5, a.getStrength());
        assertEquals(15, a.getHealth());
        Animal a2 = new Animal("Dog", 5, -5);
        assertEquals("Dog", a2.getType());
        assertEquals(5, a2.getStrength());
        assertEquals(0, a2.getHealth());
    }
    @Test
    public void testSetType(){
        a.setType("horse");
        assertEquals("horse", a.getType());
    }
    @Test
    public void testSetStrength(){
        a.setStrength(10);
        assertEquals(10, a.getStrength());
        a.setStrength(-5);
        assertEquals(0, a.getStrength());
    }
    @Test
    public void testSetHealth(){
        a.setHealth(10);
        assertEquals(10, a.getHealth());
        a.setHealth(-5);
        assertEquals(0, a.getHealth());
    }
    @Test
    public void testAttack(){
        int attackVal = a.attack();
        assertTrue(a.getStrength() >= attackVal && 0 <= attackVal);
    }
    @Test
    public void testDetailedAttack(){
        assertNotNull(a.detailedAttack());
    }
}
