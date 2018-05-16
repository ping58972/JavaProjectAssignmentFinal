package edu.century.FinalProject;

public class InsufficientFundsException extends Exception{
	


		public InsufficientFundsException() {
			super("Insufficient funds to complete transaction!");
		}
		
		public InsufficientFundsException(String message) {
			super(message);
		}

}
