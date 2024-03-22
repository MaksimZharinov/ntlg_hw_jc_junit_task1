public class CreditAccount extends Account {
    private final long LIMIT;

    public CreditAccount(long limit) {
        if (limit < 0) {
            LIMIT = limit;
        } else {
            LIMIT = -limit;
        }
    }

    @Override
    public boolean add(long amount) {
        if (amount < 0) return false;
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
        if (amount < 0) return false;
        balance -= amount;
        if (balance < LIMIT) {
            balance += amount;
            return false;
        } else {
            return true;
        }
    }
}
