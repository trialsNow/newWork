package com.entrust.trials;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class PasswordChecker{
	
	  private Pattern pattern;
	  private Matcher matcher;
 
	  private static final String PASSWORD_PATTERN = 
              "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	        
	  public PasswordChecker(){
		  pattern = Pattern.compile(PASSWORD_PATTERN);
	  }
	  
	  /**
	   * Validate password with regular expression
	   * @param password password for validation
	   * @return true valid password, false invalid password
	   */
	  public boolean validate(final String password){
		  
		  matcher = pattern.matcher(password);
		  return matcher.matches();
	    	    
	  }
}