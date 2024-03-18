import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SimpleAccountTest {

    @ParameterizedTest
    @ValueSource(longs = {0, 100, -100})
    public void add(long value) {
        boolean expected = true;

        boolean result = SimpleAccount.add(value);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void pay() {
    }
}