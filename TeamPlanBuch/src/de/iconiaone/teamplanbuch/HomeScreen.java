package de.iconiaone.teamplanbuch;

<<<<<<< HEAD
import android.R.menu;
import android.os.Bundle;
=======
>>>>>>> 6880adac156cd6bb45f9c8167edf1b7aecb6fac0
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
<<<<<<< HEAD
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class HomeScreen extends Activity {

	//Button eventButton;
	
	//Button exitButton;
=======

public class HomeScreen extends Activity {
>>>>>>> 6880adac156cd6bb45f9c8167edf1b7aecb6fac0
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_screen);
		
		MySQLiteHelper db = new MySQLiteHelper(this);
<<<<<<< HEAD
		 populateListView();
		
		//eventButton = (Button) findViewById(R.id.eventButton);
		//eventButton.setOnClickListener(this);
		
		//exitButton = (Button) findViewById(R.id.exitButton);
		//exitButton.setOnClickListener(this);
=======
>>>>>>> 6880adac156cd6bb45f9c8167edf1b7aecb6fac0
	}
	private void populateListView(){
    	
	    String[] EventItems = {"Russian Bearfight", "Russian Icediving", "Russian Wodkadrinking","asja!"};
	    
	 // Binding resources Array to ListAdapter
	    ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,R.layout.list_item , EventItems);
	      
	     //Calling the view
	     ListView list = (ListView)findViewById(R.id.listView1);
	     list.setAdapter(adapter);
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
	        case R.id.profil:
	        	Intent intent5 = new Intent(this, ProfilScreen.class);
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
