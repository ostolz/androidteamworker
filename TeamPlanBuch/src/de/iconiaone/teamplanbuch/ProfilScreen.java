package de.iconiaone.teamplanbuch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ProfilScreen extends Activity implements OnClickListener {
	
	// DATENBANK-AKTIONEN //
	
	// die Datenfelder werden mit den Daten aus der DB vorausgef�llt
	// sobald etwas ge�ndert wurde und der Update-Button bet�tigt wird --> Meldung und zur�ck zu Home
	
	Button updateButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profil_screen);
		
		updateButton = (Button) findViewById(R.id.updateButton);
		updateButton.setOnClickListener(this);
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
		getMenuInflater().inflate(R.menu.profil_screen, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		if (v == updateButton)
		{
			Intent intent = new Intent(this, HomeScreen.class);
		    startActivity(intent);
		    Toast.makeText(getApplicationContext(), "Profil wurde ge�ndert", Toast.LENGTH_LONG).show();
		}
	}

}
