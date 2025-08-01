import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import praktikum.IngredientType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTypeTest {
    @ParameterizedTest
    @CsvSource({
            "SAUCE, SAUCE",
            "FILLING, FILLING"
    })
    public void type(String input, IngredientType output) {
        assertEquals(output, IngredientType.valueOf(input));
    }
}
