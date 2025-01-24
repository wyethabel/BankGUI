public class UserAccount {
    private String firstName;
    private String lastName;
    private int accountID;
    private double balance;

    public UserAccount() {
        this.firstName = "";
        this.lastName = "";
        this.accountID = 0;
        this.balance = 0.0;
    }

    public UserAccount(String firstName, String lastName, int accountID, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountID = accountID;
        this.balance = balance;
    }

    public String getFirst() {
        return firstName;
    }
    public String getLast() {
        return lastName;
    }
    public int getID() {
        return accountID;
    }
    public double getBalance() {
        return balance;
    }
    public void setFirst(String firstName) {
        this.firstName = firstName;
    }
    public void setLast(String lastName) {
        this.lastName = lastName;
    }
    public void setID(int accountID) {
        this.accountID = accountID;
    }

    //Failed logging is not operational due to it never being reached
    //Logging could be moved into the BankInterface functions.
    public void deposit(double depositAmount) {
        try {
            if (depositAmount > 0) {
                balance = balance + depositAmount;
                System.out.println("Deposit made for accountID " + accountID + " of $" + depositAmount);
            } else {
                System.out.println("Deposit failed for accountID " + accountID);
            }
        } catch (Exception i) {
            System.out.println("Deposit failed due to: " + i.getMessage());
        }
    }

    public void withdrawal(double withdrawalAmount) {
        try {
            if (withdrawalAmount > 0) {
                if (balance >= withdrawalAmount) {
                    balance = balance - withdrawalAmount;
                    System.out.println("Withdrawal made for accountID " + accountID + " of $" + withdrawalAmount);
                } else {
                    System.out.println("Withdrawal failed for accountID " + accountID);
                }
            } else {
                System.out.println("Withdrawal failed for accountID " + accountID);
            }
        } catch (Exception i) {
            System.out.println("Withdrawal failed due to: " + i.getMessage());
        }
    }
}
