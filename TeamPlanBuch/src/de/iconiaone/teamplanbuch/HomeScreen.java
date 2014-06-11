package de.iconiaone.teamplanbuch;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class HomeScreen extends Activity {

	//Button eventButton;
	//Button exitButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_screen);
		
		MySQLiteHelper db = new MySQLiteHelper(this);
		
		//eventButton = (Button) findViewById(R.id.eventButton);
		//eventButton.setOnClickListener(this);
		
		//exitButton = (Button) findViewById(R.id.exitButton);
		//exitButton.setOnClickListener(this);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.event:
	        	Intent intent1 = new Intent(this, CreateEventScreen.class);
	    	    startActivity(intent1);
	            return true;
	        case R.id.logout:
	        	Intent intent2 = new Intent(this, LoginScreen.class);
	    	    startActivity(intent2);
	            return true;
	        case R.id.contact:
	        	Intent intent3 = new Intent(this, MailScreen.class);
	        	startActivity(intent3);
	        	return true;
	        case R.id.action_settings:
	        	Intent intent4 = new Intent(this, SettingsScreen.class);
	        	startActivity(intent4);
	        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_screen, menu);
		return true;
	}

	/*@Override
	public void onClick(View v) {
	if(v == eventButton)
	{
		Intent intent = new Intent(this, CreateEventScreen.class);
	    startActivity(intent);
	}
	
	if(v == exitButton)
	{
		Intent intent = new Intent(this, LoginScreen.class);
	    startActivity(intent);
	}
	}*/

}
