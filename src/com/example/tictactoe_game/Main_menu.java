package com.example.tictactoe_game;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Main_menu extends Activity implements OnClickListener {
	Button startButton, exitButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Uzliek logu pilnekrāna režīmā
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	            WindowManager.LayoutParams.FLAG_FULLSCREEN);
	        
	        
		setContentView(R.layout.activity_main_menu);
		
		startButton = (Button) findViewById(R.id.bStartGame);
		exitButton = (Button) findViewById(R.id.bExit);
		
		startButton.setOnClickListener(this);
		exitButton.setOnClickListener(this);
		
		
	}
	
	
	@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch(arg0.getId()){
			
				case R.id.bStartGame:
					Intent spelesLogs = new Intent("com.example.tictactoe_game.GameActivity");
					startActivity(spelesLogs);
					
					//parrakstam parbaudes arraju lai to restartetu ja speletajs nospiez back
					//pogu uz ierices citadi gljuki
					for(int i=0; i<Logika.parbArray.length; i++)
						Logika.parbArray[i]='n';
					
					break;
				case R.id.bExit:
					System.exit(0);
					break;
			}
			
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_menu, menu);
		return true;
	}

	
}
