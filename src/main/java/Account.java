public abstract class Account {

    protected static int balance;

//    public static boolean add(long amount) {
//        return false;
//    }

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
