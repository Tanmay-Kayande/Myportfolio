package com.validation;

import java.util.ArrayList;

import javax.servlet.http.Part;

public class Validation {

	private String result;
	private static final long max_size = 20 * 1024 * 1024;

	public String validateLoginData(String username, String password) {

		int usernameLen = username.length();
		int passwordLen = password.length();

		if (usernameLen < 5 || usernameLen > 30) {

			result = "invalid username";
		} else if (passwordLen < 5 || passwordLen > 30) {

			result = "invalid password";
		} else {
			result = "valid";
		}

		return result;
	}

	public String validateMessage(String name, String email, String message) {

		int nameLen = name.length();
		int emailLen = email.length();
		int messageLen = message.length();

		if (nameLen < 2 || nameLen > 45) {
			result = "Invalid name";
		} else if (emailLen < 10 || emailLen > 45) {
			result = "Invalid email";
		} else if (messageLen < 10 || messageLen > 1000) {
			result = "Message between 10 to 1000 char";
		} else {
			result = "valid";
		}
		return result;
	}

	public String validateproject(ArrayList<Object> al) {

		String name = (String) al.get(0);
		Part part = (Part) al.get(1);
		long size = part.getSize();

		if (!name.endsWith(".jpg")) {

			result = "invalid";
		} else if (size > max_size) {

			result = "invalid";
		} else {

			result = "valid";
		}

		return result;

	}

	public String validateUpdateProject(ArrayList<Object> all) {

		Part part = (Part) all.get(1);
		long size = part.getSize();
		String name = (String) all.get(3);

		if (!name.endsWith(".jpg")) {
			result = "invalid";
		} else if (size > max_size) {
			result = "invalid";
		} else {
			result = "valid";
		}
		return result;
	}

	public String validateEdu(ArrayList<Object> al) {
		String institution = (String) al.get(1);
		String degree = (String) al.get(2);
		String desc = (String) al.get(4);

		if (institution.length() > 200 || institution.length() <= 0) {
			result = "invalid";
		} else if (degree.length() > 100 || degree.length() <= 0) {
			result = "invalid";
		} else if (desc.length() > 1000 || desc.length() < 10) {
			result = "invalid";
		} else {
			result = "valid";
		}

		return result;
	}
	public String validateCer(ArrayList<Object> al) {
	String certificate = (String) al.get(0);
	String institution = (String) al.get(1);
	String desc = (String) al.get(3);

	if(certificate.length()>200||certificate.length()<=0)
	{
		result = "invalid";
	}else if(institution.length()>100||institution.length()<=0)
	{
		result = "invalid";
	}else if(desc.length()>1000||desc.length()<10)
	{
		result = "invalid";
	}else
	{
		result = "valid";
	}

	return result;
}

}
