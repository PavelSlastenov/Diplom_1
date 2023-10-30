import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

/**
 * Тесты для класса /src/main/java/Bun.
 */
@RunWith(Parameterized.class)
public class BunTest {

    private final Bun bun;

    public BunTest(String nameBun, float priceBun) {
        bun = new Bun(nameBun, priceBun);
    }

    @Parameterized.Parameters(name = "nameBun: {0}; priceBun: {1}")
    public static Object[][] getBun() {
        return new Object[][]{
                {"Тест", 50.0f},
                {"@#$%", -100.5f},
                {"ТестТест", 0},
                {"777", 0},
                {"", 0.25f},
                {null, 50}

        };
    }

    @Test
    public void getNameExpectedEqualsActual() {
        assertEquals(bun.name, bun.getName());
    }

    @Test
    public void getPriceExpectedEqualsActual() {
        assertEquals("Error getPrice", bun.price, bun.getPrice(), 0);
    }
}