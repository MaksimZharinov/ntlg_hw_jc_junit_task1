import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CreditAccountTest {

    @Test
    void add() {                                          //Если тест запускать отдельно, то проходит.
        long money = 100;                                 //Если запускать всё вместе, то валится.
        boolean expected = false;

        boolean result = CreditAccount.add(money);

        Assertions.assertEquals(expected,result);
    }

    @ParameterizedTest                                     //Если сделать (longs = {0, 100, -100}),
    @ValueSource(longs = {0, -100})                        //то тест валится, при отдельном запуске.
    public void addValue(long money) {                     //Если запускать всё сразу, то отрабатывает.
        Assertions.assertTrue(CreditAccount.add(money));
    }

    @ParameterizedTest                                     //Тест отрабатывает в пределах ожидаемого.
    @CsvSource(value = {
            "0, true",
            "100, false",
            "-100, true"
    })
    public void addCsv(long money, boolean expected) {
        Assertions.assertEquals(expected, CreditAccount.add(money));
    }

    @Test
    void pay() {
    }
}