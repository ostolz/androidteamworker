package de.iconiaone.teamplanbuch;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

public class LoginScreen extends Activity implements OnClickListener {

	SQLiteDatabase database;
	
	// GUI Objekte
	EditText username;
	EditText password;
	Button loginButton;
	Button registerButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_screen);
		
		username = (EditText) findViewById(R.id.log_username);
		password = (EditText) findViewById(R.id.log_password);
		loginButton = (Button) findViewById(R.id.loginButton);
		registerButton = (Button) findViewById(R.id.registerButton);
		
		loginButton.setOnClickListener(this);
		registerButton.setOnClickListener(this);
		
		// Datenbank wird angelegt (falls nicht vorhanden) und geöffnet
		database = openOrCreateDatabase("TeamPlanBuchDatabase", MODE_PRIVATE, null);
		String createUserTable = 
				"CREATE TABLE IF NOT EXISTS user" +
				" (userId INTEGER PRIMRY KEY, username VARCHAR, nachname VARCHAR, vorname VARCHAR password VARCHAR)";
		database.execSQL(createUserTable);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_screen, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		if(v == loginButton)
		{
			Intent intent = new Intent(this, HomeScreen.class);
		    startActivity(intent);		}
		
		if(v == registerButton)
		{
			Intent intent = new Intent(this, RegisterScreen.class);
		    startActivity(intent);
		}
	}

}
