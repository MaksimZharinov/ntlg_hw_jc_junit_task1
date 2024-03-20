public abstract class Account {

    protected int balance;

    public abstract boolean add(long amount);

    public abstract boolean pay(long amount);

//    public boolean transfer(Account account, long amount) {
//        if (account.add(amount)) {
//            if (pay(amount)) {
//                return true;
//            } else {
//                account.pay(amount);
//                return false;
//            }
//        } else {
//            return false;
//        }
//    }

    public long getBalance() {
        return balance;
    }
}
