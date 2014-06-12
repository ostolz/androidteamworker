package de.iconiaone.teamplanbuch;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
 
public class SingleItem extends Activity implements OnClickListener{
	
	Button zusageButton;
	Button absageButton;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.single_list_item_view);
        
        zusageButton = (Button) findViewById(R.id.zusageButton);
		zusageButton.setOnClickListener(this);   
		absageButton = (Button) findViewById(R.id.absageButton);
		absageButton.setOnClickListener(this);   
         
        TextView txtProduct = (TextView) findViewById(R.id.product_label);
         
        Intent i = getIntent();
        // getting attached intent data
        String product = i.getStringExtra("product");
        // displaying selected product name
        txtProduct.setText(product);
         
    }

	@Override
	public void onClick(View v) {
		if (v == zusageButton)
		{
			Intent intent = new Intent(this, HomeScreen.class);
		    startActivity(intent);	
			Toast.makeText(getApplicationContext(), "Termin bestätigt", Toast.LENGTH_LONG).show();
		}
		
		if (v == absageButton)
		{
			Intent intent = new Intent(this, HomeScreen.class);
		    startActivity(intent);	
			Toast.makeText(getApplicationContext(), "Termin abgelehnt", Toast.LENGTH_LONG).show();
		}
	}
}