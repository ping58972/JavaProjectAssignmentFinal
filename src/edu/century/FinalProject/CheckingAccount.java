package edu.century.FinalProject;
import java.math.BigDecimal;

public class CheckingAccount extends Account{

	private final BigDecimal MIN_BALANCE = new BigDecimal("100.00");
	
	public CheckingAccount(){
	}
	
	public CheckingAccount(String amount, String accountNumber) {
		super(amount, accountNumber);
	}

	public void makeWithdrawal(String amount) throws Exception {
		BigDecimal withdrawalAmount = new BigDecimal(amount);
		int withdrawalStatus = this.getBalance().subtract(withdrawalAmount).compareTo(MIN_BALANCE);
		
		if(withdrawalAmount.doubleValue() <= 0) {
			throw(new InvalidInputException());
		}
		if(withdrawalStatus < 0) {
			throw(new InsufficientFundsException());
		}
		else if(withdrawalStatus == 0 || withdrawalStatus == 1) {
			withdraw(withdrawalAmount);
		}
	}
	
	public void makeDeposit(String amount) throws Exception {
		BigDecimal depositAmount = new BigDecimal(amount);
		
		if(depositAmount.doubleValue() <= 0) {
			throw(new InvalidInputException());
		}else {
			deposit(depositAmount);
		}
	}
	
	public String toString(){
		return super.toString();
	}
}
