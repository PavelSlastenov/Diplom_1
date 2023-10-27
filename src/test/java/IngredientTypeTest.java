import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Тесты для класса /src/main/java/Ingredient
 * /src/main/java/IngredientType.
 */
@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private static IngredientType expectedSauce;
    private static IngredientType expectedFilling;

    private Ingredient ingredient;
    private final String nameBun;
    private final float priceBun;
    private final IngredientType ingredientType;

    public IngredientTypeTest(IngredientType ingredientType, String nameBun, float priceBun) {
        this.nameBun = nameBun;
        this.priceBun = priceBun;
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters(name = "ingredientType: {0}, nameBun: {1}, priceBun: {2}")
    public static Collection<Object[]> getIngredientData() {
        return Arrays.asList(new Object[][]{
                {IngredientType.FILLING, "Тест", 10.50f},
                {IngredientType.SAUCE, "Тест", 0.5f},
                {null, "777", 100},
                {IngredientType.SAUCE, "@#$%", 1525.3999f},
                {IngredientType.FILLING, null, 0},
                {IngredientType.SAUCE, "", 0},
        });
    }

    @BeforeClass
    public static void setUpClass() {
        expectedSauce = IngredientType.valueOf("SAUCE");
        expectedFilling = IngredientType.valueOf("FILLING");
    }

    @Test
    public void getPriceIngredientTest() {
        ingredient = new Ingredient(ingredientType, nameBun, priceBun);
        float actualResult = ingredient.getPrice();
        assertEquals(priceBun, actualResult, 0);
    }

    @Test
    public void getNameIngredientTest() {
        ingredient = new Ingredient(ingredientType, nameBun, priceBun);
        String actualResult = ingredient.getName();
        assertEquals(nameBun, actualResult);
    }

    @Test
    public void getTypeIngredientTest() {
        ingredient = new Ingredient(ingredientType, nameBun, priceBun);
        IngredientType actualResult = ingredient.getType();
        assertEquals(ingredientType, actualResult);
    }

    @Test
    public void valuesSauce() {
        assertEquals("Error valuesSauce", expectedSauce, IngredientType.SAUCE);
    }

    @Test
    public void valueFilling() {
        assertEquals("Error valueFilling", expectedFilling, IngredientType.FILLING);
    }
}