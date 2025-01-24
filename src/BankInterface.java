import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class BankInterface {
    private JFrame frame1;
    private JTextField inputField;
    private JLabel balanceLabel;

    public BankInterface(UserAccount account) {

        // Primary Frame
        frame1 = new JFrame("Bank of Wyeth");
        frame1.setSize(400, 300);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Top Panel
        JPanel accountPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        accountPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Account",
                TitledBorder.CENTER, TitledBorder.TOP));
        accountPanel.add(new JLabel("First Name: "));
        accountPanel.add(new JLabel(account.getFirst()));
        accountPanel.add(new JLabel("Last Name: "));
        accountPanel.add(new JLabel(account.getLast()));
        accountPanel.add(new JLabel("Account ID: "));
        accountPanel.add(new JLabel(String.valueOf(account.getID())));
        accountPanel.add(new JLabel("Balance: "));
        balanceLabel = new JLabel("$" + account.getBalance());
        accountPanel.add(balanceLabel);

        //Bottom Panel
        JPanel transactionPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        transactionPanel.setBorder((BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Transactions",
                TitledBorder.CENTER, TitledBorder.TOP)));
        transactionPanel.add(new JLabel("Amount to deposit or withdraw: "));
        inputField = new JTextField(20);
        transactionPanel.add(inputField);

        JButton depositButton = new JButton("Process for Deposit");
        depositButton.addActionListener(_ -> {
                try {
                    double input = Double.parseDouble(inputField.getText());
                    if (input > 0) {
                        account.deposit(input);
                        balanceLabel.setText("$" + account.getBalance());
                        JOptionPane.showMessageDialog(frame1, "Deposit completed successfully, " +
                                "the new balance is: $" + account.getBalance());
                    } else {
                        JOptionPane.showMessageDialog(frame1, "Input number must be positive.");
                    }
                } catch (Exception i) {
                    JOptionPane.showMessageDialog(frame1, "An unexpected error has occurred: " + i.getMessage());
                }
        });

        JButton withdrawalButton = new JButton("Process for Withdrawal");
        withdrawalButton.addActionListener(_ -> {
                try {
                    double input = Double.parseDouble(inputField.getText());
                    if (input > 0) {
                        if (account.getBalance() >= input) {
                            account.withdrawal(input);
                            balanceLabel.setText("$" + account.getBalance());
                            JOptionPane.showMessageDialog(frame1, "Withdrawal completed successfully, " +
                                    "the new balance is: $" + account.getBalance());
                        } else {
                            JOptionPane.showMessageDialog(frame1, "Withdraw amount cannot exceed the current balance.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame1, "Input number must be positive.");
                    }
                } catch (Exception i) {
                    JOptionPane.showMessageDialog(frame1, "An unexpected error has occurred: " + i.getMessage());
                }
        });

        transactionPanel.add(depositButton);
        transactionPanel.add(withdrawalButton);

        // Panel framing
        frame1.setLayout(new BorderLayout(20, 20));
        frame1.add(accountPanel, BorderLayout.NORTH);
        frame1.add(transactionPanel, BorderLayout.CENTER);
        frame1.setVisible(true);
    }
}
