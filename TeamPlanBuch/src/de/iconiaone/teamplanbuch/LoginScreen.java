package de.iconiaone.teamplanbuch;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
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
		
		
	}
	
	@Override
	public void onClick(View v) {
		if(v == loginButton)
		{	
			String vUsername, vPassword;
			
			vUsername = username.getText().toString();
			vPassword = password.getText().toString();
			
			if(DBOperations.checkLogin(vUsername, vPassword))
			{
				Intent intent = new Intent(this, HomeScreen.class);
			    startActivity(intent);	
			    Toast.makeText(getApplicationContext(), "Login erfolgreich", Toast.LENGTH_LONG).show();
			}
			else
				Toast.makeText(getApplicationContext(), "Login fehlgeschlagen", Toast.LENGTH_LONG).show();
		}
		
		
		if(v == registerButton)
		{
			Intent intent = new Intent(this, RegisterScreen.class);
		    startActivity(intent);
		    Toast.makeText(getApplicationContext(), "Bitte Daten eintragen", Toast.LENGTH_LONG).show();
		}
	}

}
