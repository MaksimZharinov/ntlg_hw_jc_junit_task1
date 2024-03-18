public class CreditAccount extends Account {
    private final long LIMIT;

    public CreditAccount(long limit) {
        LIMIT = -limit;
    }


    public static boolean add(long amount) {
        balance += amount;
        if (balance > 0) {
            balance -= amount;
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean pay(long amount) {
        balance -= amount;
        if (balance < LIMIT) {
            balance += amount;
            return false;
        } else {
            return true;
        }
    }
}
