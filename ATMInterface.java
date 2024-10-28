package ATMInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATMInterface extends JFrame implements ActionListener {
    private Bank account; 
    private JLabel balanceLabel;
    private JTextField amountField;
    private JButton withdrawButton, depositButton, checkBalanceButton;
    private JTextArea messageArea;

    public ATMInterface(Bank account) {
        this.account = account; 

        setTitle("ATM Machine");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        Font font = new Font("Arial", Font.BOLD, 16);

        balanceLabel = new JLabel("Enter amount:");
        balanceLabel.setFont(font); 
        
        amountField = new JTextField(10);
        amountField.setFont(font); 

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setFont(font); 

        depositButton = new JButton("Deposit");
        depositButton.setFont(font); 

        checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setFont(font); 

        messageArea = new JTextArea(5, 30);
        messageArea.setFont(new Font("Arial", Font.PLAIN, 14));
       
        add(balanceLabel);
        add(amountField);
        add(withdrawButton);
        add(depositButton);
        add(checkBalanceButton);
        add(new JScrollPane(messageArea));

  
        withdrawButton.addActionListener(this);
        depositButton.addActionListener(this);
        checkBalanceButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        double amount = 0;
        
        try {
            amount = Double.parseDouble(amountField.getText());
        } catch (NumberFormatException ex) {
            messageArea.setText("Please enter a valid amount.");
            return;
        }

        if (action.equals("Withdraw")) {
            if (account.withdraw(amount)) {
                messageArea.setText("Withdrawal successful. New balance: $" + account.getBalance());
            } else {
                messageArea.setText("Insufficient balance or invalid amount.");
            }

 
        } else if (action.equals("Deposit")) {
            account.deposit(amount);
            messageArea.setText("Deposit successful. New balance: $" + account.getBalance());


        } else if (action.equals("Check Balance")) {
            messageArea.setText("Current balance: $" + account.getBalance());
        }
    }

    public static void main(String[] args) {
        Bank account = new Bank(5000.00); 
        ATMInterface atm = new ATMInterface(account);
        atm.setVisible(true);
    }
}

class Bank1 {
    private double balance;

    public Bank1(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

   
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true; 
        } else {
            return false; 
        }
    }

    public double getBalance() {
        return balance;
    }
}
