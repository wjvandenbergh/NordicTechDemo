package com.example.mantistechdemo;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener
{
	// random number instance
	Random r = new Random();
	
	// handles to UI elements
	Button rollButton;
	TextView generatedNumber;
	Spinner diceChoice;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// grab handle to text view
		generatedNumber = (TextView) findViewById(R.id.generatedNumber);

	
		// set up dice choices
		diceChoice = (Spinner) findViewById(R.id.diceChoice);
		
		// Array of dice choices
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.dice_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		diceChoice.setAdapter(adapter);
		
		// set roll button click listener
		rollButton = (Button) findViewById(R.id.rollButton);
		rollButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	
	// listen for clicks
	@Override
	public void onClick(View v)
	{
		if (v == rollButton)
		{
			
			// get selected dice type
			String selectedDice = (String) diceChoice.getSelectedItem();
			
			// generate random number 
			int randomNumber = r.nextInt(Integer.parseInt(selectedDice)) + 1;
			
			// display number
			generatedNumber.setText(String.valueOf(randomNumber));
		}		
		
	}
}
