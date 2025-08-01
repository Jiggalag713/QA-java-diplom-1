import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient firstIngredient;

    @Mock
    Ingredient secondIngredient;

    @Test
    public void setBun() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(firstIngredient);
        assertEquals(firstIngredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        assertEquals(firstIngredient, burger.ingredients.get(1));
    }

    @Test
    public void getPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.getPrice();
        Mockito.verify(bun, Mockito.times(1)).getPrice();
        Mockito.verify(firstIngredient, Mockito.times(1)).getPrice();
    }

    @Test
    public void getReceipt() {
        Burger burger = new Burger();
        when(bun.getName()).thenReturn("Test Bun");
        when(bun.getPrice()).thenReturn(2.5f);

        when(firstIngredient.getName()).thenReturn("1000 island");
        when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        when(firstIngredient.getPrice()).thenReturn(1.99f);

        when(secondIngredient.getName()).thenReturn("Bacon");
        when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        when(secondIngredient.getPrice()).thenReturn(4.99f);

        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        String expectedReceipt = "(==== Test Bun ====)\n= sauce 1000 island =\n= filling Bacon =\n(==== Test Bun ====)\n\nPrice: 11.980000\n";
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
