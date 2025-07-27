import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class IngredientTest {

    @Mock
    IngredientType type;

    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(type, "Булочка", 0.75F);
        assertEquals(0.75F, ingredient.getPrice());
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(type, "Булочка", 0.75F);
        assertEquals("Булочка", ingredient.getName());
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(type, "Булочка", 0.75F);
        assertEquals(type, ingredient.getType());
    }
}
