package de.iconiaone.teamplanbuch;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;

import android.database.sqlite.SQLiteDatabase;

public class LoginScreen extends Activity {

	SQLiteDatabase database;
	
	EditText username;
	EditText password;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_screen);
		
		database = openOrCreateDatabase("TeamPlanBuchDatabase", MODE_PRIVATE, null);
		String createUserTable = 
				"CREATE TABLE IF NOT EXISTS user" +
				" (userId INTEGER PRIMRY KEY, username VARCHAR, password VARCHAR)";
		database.execSQL(createUserTable);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_screen, menu);
		return true;
	}

}
