package OOPS_Concepts;

public class EncapsulationDemo {
	    private double balance;  // Private variable (not directly accessible)

	    // Setter method to modify balance
	    public void setBalance(double balance) {
	        if (balance > 0) // Checking for valid balance
	            this.balance = balance;
	    }

	    // Getter method to access balance
	    public double getBalance() {
	        return balance;
	    }

	    public static void main(String[] args) {
	    	EncapsulationDemo acc = new EncapsulationDemo();
	        acc.setBalance(5000); // Setting balance
	        System.out.println("Account Balance: " + acc.getBalance());
	    }
	}


