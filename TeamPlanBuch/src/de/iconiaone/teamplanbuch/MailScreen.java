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

public class MailScreen extends Activity implements OnClickListener {
	
	Button sendenButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mail_screen);
		
		sendenButton = (Button) findViewById(R.id.sendenButton);
		sendenButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu. mail_screen, menu);
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
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

	@Override
	public void onClick(View v) {
		if (v == sendenButton)
		{
			Intent intent = new Intent(this, HomeScreen.class);
		    startActivity(intent);
		    Toast.makeText(getApplicationContext(), "Nachricht wurde abgeschickt", Toast.LENGTH_LONG).show();
		}
	}
	
}
