import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CreditAccountTest {
    private static long startTimeAll;
    private static long limit;
    private long startTimeTest;


    @BeforeAll
    public static void setUp() {
        startTimeAll = System.nanoTime();
        limit = 100;
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("Testing CreditAccount complete: " +
                ((System.nanoTime() - startTimeAll) / 1000000) +
                " milliseconds");
    }

    @BeforeEach
    public void setUpTest() {
        System.out.println("Starting new test");
        startTimeTest = System.nanoTime();
    }

    @AfterEach
    public void tearDownTest() {
        System.out.println("Test complete: " +
                (System.nanoTime() - startTimeTest) +
                " nanoseconds");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0, true",
            "-1, false",
            "50, true",
            "100, true",
            "110, false"
    })
    public void pay(long money, boolean expected) {
        Assertions.assertEquals(new CreditAccount(limit).pay(money), expected);
    }
    @ParameterizedTest
    @CsvSource(value = {
            "0, 0, true",
            "-1, 0, false",
            "50, 0, false",
            "100, 0, false",
            "110, 0, false",
            "0, 50, true",
            "-1, 50, false",
            "50, 50, true",
            "100, 50, false",
            "110, 50, false",
            "0, 100, true",
            "-1, 100, false",
            "50, 100, true",
            "100, 100, true",
            "110, 100, false"
    })
    public void add(long money, long balance, boolean expected) {
        Account testAcc = new CreditAccount(limit);
        testAcc.pay(balance);

        Assertions.assertEquals(testAcc.add(money), expected);
    }
}