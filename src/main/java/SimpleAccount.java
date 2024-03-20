public class SimpleAccount extends Account {

    @Override
    public boolean add(long amount) {
        balance += amount;
        return true;
    }

    @Override
    public boolean pay(long amount) {
        balance -= amount;
        if (balance < 0) {
            balance += amount;
            return false;
        } else {
            return true;
        }
    }
}
