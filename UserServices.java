package com.coderscampus.myapp.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

	public User createUser(String email, String password, String name) {
		User user = new User();
		user.setuserEmail(email);
		user.setuserPassword(password);	// User method that uses the parameters Sting email, password, and name
		user.setuserName(name);			// Not sure this is used anymore
		return user;
	}

	String input1 = "exampleEmail,examplePassword,exampleName"; // Not sure what this was for anymore. Doesn't seem to be used
	
	public String[] parseText() { // Creating a String array
		BufferedReader buff = null; // Not sure why they wanted to move this up here or change it to null
		List<String> listOfStrings = new ArrayList<String>();	// Instantiating an Arraylist of type String
		try { // Try block which comes before a catch block for possible errors
			buff = new BufferedReader(new FileReader("data.txt")); // Instantiating BufferedReader with Filereader instead of using two lines pointing to the data.txt file to parse
			User user = new User(); // The idea I get. Not sure I grasp creating unique users without changing the variable name
			
			while (buff != null) { // a while loop that stops when BufferedReader hits an empty line.
				
				String line = buff.readLine();	// Reads a line of text and saves it as variable line
				listOfStrings.add(line);		// Puts line in ArrayList called listOfStrings
				String[] array = line.split(",");	// Spliting the line by the commas to give 0 - 2 Array slots
				String userEmail = (array[0]) ;	// Assigning ListOfStrings [0] as userEmail
				String userPassword = (array[1]); // Assigning ListOfStrings [1] as userPassword
				String userName = (array[2]);	// Assigning ListOfStrings [2] as userName
//				System.out.println(array[0]);		// More
//				System.out.println(userPassword);
//				System.out.println(userName);
//				System.out.println(line);			// Tests
				user.setuserEmail(userEmail);	// Calling the setter to assign String userEmail to user
				user.setuserPassword(userPassword);	// Calling the setter to assign String userPassword to user
				user.setuserName(userName);		// Calling the setter to assign String userName to user
				
//				User user1 = new User (userEmail, userPassword, userName);	// All tests
//				User user2 = new User (userEmail, userPassword, userName);	// All tests
//				User user3 = new User (userEmail, userPassword, userName);	// All tests
//				User user4 = new User (userEmail, userPassword, userName);	// All tests
//				System.out.println(user1);									// All tests
//				System.out.println(user2);									// All tests
//				System.out.println(user3);									// All tests
//				System.out.println(user4);									// All tests
//				System.out.println(user1.getuserName());					// All tests 		
			}
//			String[] array = listOfStrings.toArray(new String[0]);
//			for (String str : array) {
//				System.out.println(str);
//			}

		} catch (IOException e) {	// The Catch block to not have runtime errors and disrupt the program
			System.out.println("Error - " + e.toString());
		} catch (NullPointerException a) {
			System.out.println("Error - " + a.toString());
		} finally {		// It's the thing that runs after the loop finishes
			try {
				buff.close(); // Closes BufferedReader to prevent memory leaks
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return null;	// The method isn't void so it must return something. In this case its returning null

	}
}