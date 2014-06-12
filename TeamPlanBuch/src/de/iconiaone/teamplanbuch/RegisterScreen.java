package de.iconiaone.teamplanbuch;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterScreen extends Activity implements OnClickListener {

	SQLiteDatabase database;
	
	private String array_spinner[];
	
	// GUI Elemente
	EditText username;
	EditText nachname;
	EditText vorname;
	EditText password;
	EditText passwordConfirm;
	EditText email;
	Button submitButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_screen);
		
		// GUI Elemente
		username = (EditText) findViewById(R.id.reg_username);
		nachname = (EditText) findViewById(R.id.nachname);
		vorname = (EditText) findViewById(R.id.vorname);
		password = (EditText) findViewById(R.id.reg_password);
		passwordConfirm = (EditText) findViewById(R.id.password_confirm);
		email = (EditText) findViewById(R.id.mail);
		
		submitButton = (Button) findViewById(R.id.submit);
		
		submitButton.setOnClickListener(this);
		
		array_spinner = new String[4];
        array_spinner[0]="Team 1";
        array_spinner[1]="Team 2";
        array_spinner[2]="Team 3";
        array_spinner[3]="Team 4";
        Spinner s = (Spinner) findViewById(R.id.teamSelection);
        ArrayAdapter adapter = new ArrayAdapter(this,
        android.R.layout.simple_spinner_item, array_spinner);
        s.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register_screen, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.action_settings:
	        	Intent intent = new Intent(this, SettingsScreen.class);
	    	    startActivity(intent);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	@Override
	public void onClick(View v) {
		if(v == submitButton)
		{
			String vUsername, vNachname, vVorname, vPassword, vPasswordConfirm, vEmail;
			
			vUsername = username.getText().toString();
			vNachname = nachname.getText().toString();
			vVorname = vorname.getText().toString();
			vPassword = password.getText().toString();
			vPasswordConfirm = passwordConfirm.getText().toString();
			vEmail = email.getText().toString();
			
			if (vPassword.equals(vPasswordConfirm))
			{
				if(DBOperations.checkUserExist(vUsername))
				{
					Toast.makeText(getApplicationContext(), "Benutzername existiert bereits", Toast.LENGTH_LONG).show();
				}
				else
				{	//Registrieren
					if(DBOperations.registerUser(vUsername, vPassword, vEmail) )
					{
						Toast.makeText(getApplicationContext(), "Registrierung erfolgreich durchgeführt", Toast.LENGTH_LONG).show();
					}
					else
					{
						Toast.makeText(getApplicationContext(), "Registrierung fehlgeschlagen", Toast.LENGTH_LONG).show();
					}
				}
			}
			else Toast.makeText(getApplicationContext(), "Passwörter stimmen nicht überein", Toast.LENGTH_LONG).show();
		}
	}

}
