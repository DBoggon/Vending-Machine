package materials;

import java.io.File;
import java.io.PrintWriter;

public class Funds {
	
	private double balance = 0;
	private double getBalance; 
	private double getDeductBalance;
	
	public double getBalance() {
		return balance;
	}
	public double getDeductBalance() {
		return balance;
	}

	public void setBalance(double amountAdded) {
		this.balance = this.balance + amountAdded;
	}
	
	public void setDeductBalance (double amountSubtracted) {
		
	this.balance = this.balance - amountSubtracted;
	}
	
	public Double changeBack() {
		Double[] change = new Double[] {0.25, 0.10, 0.05};
		  String[] coin = new String[] {"Quarter(s)", "Dime(s)", "Nickle(s)"};
		  for(int i = 0; i < change.length; i++) {
		    	  int counter;
		    	  counter = (int) (balance / change[i]);

		      balance -= (change[i] * counter);
		      System.out.println(counter + " " + coin[i]);
		  }
		return balance;

}
	
	
	
}
