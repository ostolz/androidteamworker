package de.iconiaone.teamplanbuch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class HomeScreen extends Activity {
	
	// DATENBANK-AKTIONEN //
	
	// keine, dient zur Übersicht und Navigation
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_screen);
		
		MySQLiteHelper db = new MySQLiteHelper(this);
		
		
				
		//Listenobjekte definieren
	String[] myItems = { "EVENT1","EVENT2","EVENT3", "EVENT4"};
	
		
		// ListView Adapter
	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, myItems);
	
		// Liste aufrufen
	ListView list = (ListView) findViewById(R.id.listViewHome);
	list.setAdapter(adapter);
	
	//Listener
	list.setOnItemClickListener(new OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view,
            int position, long id){
        	
        	// selected item 
            String product = ((TextView) view).getText().toString();
             
            // Launching new Activity on selecting single List Item
            Intent i = new Intent(getApplicationContext(), SingleItem.class);
            // sending data to new activity
            i.putExtra("product", product);
            startActivity(i);
           
        }
        });
	
	
	
	}
	
	

	
		
	
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.action_settings:
	        	Intent intent1 = new Intent(this, SettingsScreen.class);
	    	    startActivity(intent1);
	            return true;
	        case R.id.event:
	        	Intent intent2 = new Intent(this, CreateEventScreen.class);
	    	    startActivity(intent2);
	            return true;
	        case R.id.profil:
	        	Intent intent3 = new Intent(this, ProfilScreen.class);
	        	startActivity(intent3);
	        	return true;
	        case R.id.contact:
	        	Intent intent4 = new Intent(this, MailScreen.class);
	        	startActivity(intent4);
	        	return true;
	        case R.id.logout:
	        	Intent intent5 = new Intent(this, LoginScreen.class);
	        	startActivity(intent5);
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

}
