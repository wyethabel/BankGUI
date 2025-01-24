public class Main {
    public static void main(String[] args) {
        UserAccount account1 = new UserAccount("James", "Anders", 1000657, 0.0);

        new BankInterface(account1);
    }
}
