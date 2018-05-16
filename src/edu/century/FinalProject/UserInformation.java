package edu.century.FinalProject;
import java.util.Random;

public class UserInformation {
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String ssn;
	private String phoneNumber;
	private String email;
	private String address;
	private String moreInfo;
	private CheckingAccount checkingAccount = new CheckingAccount();
	private SavingsAccount savingsAccount = new SavingsAccount();
	
	
	public CheckingAccount getCheckingAccount() {
		return checkingAccount;
	}
	public void setCheckingAccount(String accountNumber ,String amount) {
		
		checkingAccount.setAccountNumber(accountNumber);
		checkingAccount.setBalance(amount);
		
	}
	public void setCheckingAccount(String amount) {
		
		checkingAccount.createAccountNumber();
		checkingAccount.setBalance(amount);
		
	}

	public SavingsAccount getSavingsAccount() {
		return savingsAccount;
	}
	public void setSavingsAccount(String accountNumber ,String amount) {
		
		savingsAccount.setAccountNumber(accountNumber);
		savingsAccount.setBalance(amount);
	}
	public void setSavingsAccount(String amount) {

		savingsAccount.createAccountNumber();
		savingsAccount.setBalance(amount);
	}

	public UserInformation() {
		
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}
	/*public String getCheckingAccountNumber(){
		return "sgr";
	}*/
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return userName +","+password +","+ firstName
				+","+lastName+","+ssn+","+phoneNumber
				+","+email+","+checkingAccount.toString()+","+savingsAccount.toString()
				+ ",\"" +address + "\""+",\"" + moreInfo + "\"";
	}
}
