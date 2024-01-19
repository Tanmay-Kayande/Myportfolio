package com.validation;

public class Validation {

	private String result;
	
	
	

	public String validateLoginData(String username, String password) {
		
		int usernameLen = username.length();
		int passwordLen = password.length();
		
		if(usernameLen<5 || usernameLen>30) {
			
			result = "invalid username";
		}
		else if (passwordLen<5 || passwordLen>30) {
			
			result = "invalid password";
		}
		else {
			result = "valid";
		}
		
		return result;
	}




	public String validateMessage(String name, String email, String message) {
		
		int nameLen = name.length();
		int emailLen = email.length();
		int messageLen = message.length();
		
		if(nameLen<2 || nameLen>45) {
			result = "Invalid name";
		}
		else if(emailLen<10 || emailLen>45) {
			result = "Invalid email";
		}
		else if(messageLen<10 || messageLen>1000) {
			result = "Message between 10 to 1000 char";
		}
		else {
			result = "valid";
		}
		return result;
	}
}
