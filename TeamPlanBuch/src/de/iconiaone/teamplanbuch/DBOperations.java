package de.iconiaone.teamplanbuch;

public class DBOperations {
		
	public static void initDb()
	{
		
	}
	
	public static boolean registerUser(String user, String pass, String email, String sur, String last, String teampreferred, String address, String plz, String wohnort)
	{	

//TODO: R�CKGABE MIT LOGIK VERSEHEN
		return true;
	}
	
	public static boolean registerUser(String user, String pass, String email)
	{	

//TODO: R�CKGABE MIT LOGIK VERSEHEN
		return true;
	}
	
	public static boolean checkLogin(String user, String pass) 
	{	boolean s = false;
     	if(checkUserExist(user) && checkUserPassword (user, pass))
     		s = true;
		return s;
	}
	
	public static boolean checkUserExist(String user)
	{			

//TODO: R�CKGABE MIT LOGIK VERSEHEN
		return true;
	}
	
	public static boolean checkUserPassword(String user, String pass)
	{

//TODO: R�CKGABE MIT LOGIK VERSEHEN
		return true;
	}
}
