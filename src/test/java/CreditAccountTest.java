import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CreditAccountTest {

    @Test
    void addAbstract() {
        long money = 100;

        Assertions.assertFalse(CreditAccount.add(money));   //Как правильно протестировать данный метод?
    }


    @Test
    void add() {
        Account testAccZeroLim = new CreditAccount(0);
        long money = 100;
        boolean expected = false;

        boolean result = testAccZeroLim.add(money);

        Assertions.assertEquals(expected,result);
    }

    @ParameterizedTest
    @ValueSource(longs = {0, 100, -100})
    public void addValue(long money) {
        Account testAccZeroLimValue = new CreditAccount(0);

        Assertions.assertTrue(testAccZeroLimValue.add(money));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0, 0, true",
            "100, 0, false",
            "-100, 0, true",
            "0, 100_000, true",
            "100, 100_000, false",
            "-100, 100_000, true",
            "0, -100_000, true",
            "100, -100_000, false",
            "-100, -100_000, true"
    })
    public void addCsv(long money, long lim, boolean expected) {
        Account testAccCsv = new CreditAccount(lim);

        Assertions.assertEquals(expected, testAccCsv.add(money));
    }

    @Test
    void pay() {
    }
}