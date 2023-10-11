import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class AnimalAttackTest {
    private AnimalAttack aa;
    @BeforeEach
    public void setUp(){
        aa = new AnimalAttack("Charge", 5);
    }
    @Test
    public void testConstructorAndGetters(){
        assertEquals("Charge", aa.getAttackType());
        assertEquals(5, aa.getDamage());
    }


}
