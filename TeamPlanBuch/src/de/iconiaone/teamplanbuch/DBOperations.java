package de.iconiaone.teamplanbuch;

public class DBOperations {
	public static boolean checkUserExist(String user)
	{
		return true;
	}
	
	public static boolean checkUserPassword(String user, String pass)
	{
		return true;
	}
	
	public static boolean registerUser(String user, String pass, String email, String sur, String last, String teampreferred, String address, String plz, String wohnort)
	{	
		
		return true;
	}
	
	public static boolean registerUser(String user, String pass, String email)
	{	
		
		return true;
	}
	
	public static boolean checkLogin(String user, String pass) 
	{
		return (checkUserExist(user) && checkUserPassword (user, pass)) ? true : false;
	}
}
