package com.ypsc.classes;

import com.example.yourpersonalstoragecontroller.*;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.os.Build;

//YourPersonalStorageController
public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Sets the layout
		setContentView(R.layout.activity_main_layout);
		
		//Go into Add Data button
		Button b = (Button)findViewById(R.id.addnewdata);
		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, AddData.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}//end onClick
		});// end b.setOnClickListener	

	}//end onCreate
	
	
	
}//end MainActivity
