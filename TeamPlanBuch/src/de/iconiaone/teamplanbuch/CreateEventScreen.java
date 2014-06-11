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
import android.widget.Toast;

public class CreateEventScreen extends Activity implements OnClickListener {

	Button createEventButton;
	Button backHomeButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_event_screen);
		
		createEventButton = (Button) findViewById(R.id.createEventButton);
		createEventButton.setOnClickListener(this);
		
		backHomeButton = (Button) findViewById(R.id.backHomeButton);
		backHomeButton.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_screen, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.action_settings:
	        	Intent intent1 = new Intent(this, SettingsScreen.class);
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
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

	@Override
	public void onClick(View v) {
	if(v == createEventButton)
	{
		Toast.makeText(getApplicationContext(),	"Termin erfolgreich erstellt", Toast.LENGTH_LONG).show();
	}
	
	if(v == backHomeButton)
	{
		Intent intent = new Intent(this, HomeScreen.class);
	    startActivity(intent);
	}
	}

}
