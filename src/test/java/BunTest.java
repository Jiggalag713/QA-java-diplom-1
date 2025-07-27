import org.junit.jupiter.api.Test;
import praktikum.Bun;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BunTest {

    @Test
    public void getName() {
        Bun bun = new Bun("Булочка", 0.75F);
        assertEquals("Булочка", bun.getName());
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun("Булочка", 0.75F);
        assertEquals(0.75F, bun.getPrice());
    }
}
