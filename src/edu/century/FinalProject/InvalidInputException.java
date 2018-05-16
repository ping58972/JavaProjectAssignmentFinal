package edu.century.FinalProject;

public class InvalidInputException extends Exception{


		public InvalidInputException() {
			super("Missing fields! Ensure all fields are complete!");
		}
		
		public InvalidInputException(String message) {
			super(message);
		}

}
