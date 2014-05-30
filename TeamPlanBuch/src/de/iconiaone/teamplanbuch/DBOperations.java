package de.iconiaone.teamplanbuch;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class DBOperations {
	private static final String URL ="http://192.168.245.3/";
	private static final String DBREGISTER = URL + "DB_Register.php";
	private static final String DBCHECKUSER = URL + "DB_CheckUser.php";
	private static final String DBLOGIN = URL + "DB_Login.php";
	
	
	public static boolean registerUser(String user, String pass, String email, String sur, String last, String teampreferred, String address, String plz, String wohnort)
	{	
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", user));
		params.add(new BasicNameValuePair("password", pass));
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("surname", sur));
		params.add(new BasicNameValuePair("lastname", last));
		params.add(new BasicNameValuePair("teampreferred", teampreferred));
		params.add(new BasicNameValuePair("address", address));
		params.add(new BasicNameValuePair("plz", plz));
		params.add(new BasicNameValuePair("wohnort", wohnort));
		JSONObject response = new JSONObject();
		response = JSONParser.getJSONFromUrl(DBREGISTER, params);
//TODO: RÜCKGABE MIT LOGIK VERSEHEN
		return true;
	}
	
	public static boolean registerUser(String user, String pass, String email)
	{	
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", user));
		params.add(new BasicNameValuePair("password", pass));
		params.add(new BasicNameValuePair("email", email));
		JSONObject response;
		response = JSONParser.getJSONFromUrl(DBREGISTER, params);
//TODO: RÜCKGABE MIT LOGIK VERSEHEN
		return true;
	}
	
	public static boolean checkLogin(String user, String pass) 
	{
		return (checkUserExist(user) && checkUserPassword (user, pass)) ? true : false;
	}
	public static boolean checkUserExist(String user)
	{			
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", user));
		JSONObject response;
		response = JSONParser.getJSONFromUrl(DBCHECKUSER, params);
//TODO: RÜCKGABE MIT LOGIK VERSEHEN
		return false;
	}
	
	public static boolean checkUserPassword(String user, String pass)
	{
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", user));
		params.add(new BasicNameValuePair("password", pass));
		JSONObject response;
		response = JSONParser.getJSONFromUrl(DBLOGIN, params);
//TODO: RÜCKGABE MIT LOGIK VERSEHEN
		return true;
	}
}
