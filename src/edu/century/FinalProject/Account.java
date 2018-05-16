package edu.century.FinalProject;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Account{

	private String accountNumber;
	private BigDecimal balance;
	private ArrayList<String> transactionHistory = new ArrayList<String>();
	
	public Account(){
		
	}
	
	public Account(String amount, String accountNumber) {
		balance = new BigDecimal(amount);
		this.accountNumber = accountNumber;
	}
	
	public void setBalance(String amount){
		this.balance = new BigDecimal(amount);
	}
	public BigDecimal getBalance() {
		return balance;
	}
	
	public void withdraw(BigDecimal withdrawalAmount) {
		balance = balance.subtract(withdrawalAmount);
		archiveTransaction("withdrawn from account #", withdrawalAmount);
	}
	
	public void deposit(BigDecimal amount) {
		balance = balance.add(amount);
		archiveTransaction("deposited to account #", amount);
	}
	
	public void createAccountNumber(){
		Random randomGenerator = new Random();
		String accountNumber = "";
		
		for(int i = 0; i < 10; i++){
			accountNumber += randomGenerator.nextInt(10);
		}
		this.accountNumber = accountNumber;
	}
	
	public void setAccountNumber(String accountNumber) {

		this.accountNumber = accountNumber;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}


	//getAccountNumber() getBalance().toString()
	public String toString() {
		return getAccountNumber() +","+getBalance().toString();
	}
	
	public void archiveTransaction(String transactionDescription, BigDecimal transactionAmount){
		Date transactionDate = new Date();
		transactionHistory.add(transactionDate + "\n    $" + transactionAmount.toString() + " " + transactionDescription 
				+ accountNumber + "\n    Balance after transaction: $" + this.balance.toString() + "\n");
	}
	
	public String archiveTransactionToString(){
		String historyString = "";
		
		for(int i = transactionHistory.size() - 1; i >= 0; i--){
			historyString += transactionHistory.get(i);
		}
		
		return historyString;
	}

	public ArrayList<String> getTransactionHistory() {
		return transactionHistory;
	}

	public void setTransactionHistory(ArrayList<String> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}
}




/*package edu.century.FinalProject;
//import java.math.BigDecimal;

public class Account{

	private String accountNumber;
	private double balance;
	public Account(){
		
	}
	public Account(String amount, String accountNumber) {
		balance = Double.parseDouble(amount);
		this.accountNumber = accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void withdraw(String withdrawalAmount) {
		balance = balance - Double.parseDouble(withdrawalAmount);
	}
	
	public void deposit(String amount) {
		balance = balance + Double.parseDouble(amount);
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String toString() {
		return getAccountNumber() +","+ getBalance();
	}
}

*/