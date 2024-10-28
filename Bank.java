package ATMInterface;

public class Bank {

	    private double balance;

	    public Bank(double initialBalance) {
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


