package com.example.tictactoe_game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class GameActivity extends Activity implements OnClickListener {
	static int punkti = 0;
	static TextView score, pazinojums;
	static Button restart;
	static boolean pogaNospiesta = false;
	static ImageButton[] poguArray = new ImageButton[9];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//pilnekrana režīms
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	            WindowManager.LayoutParams.FLAG_FULLSCREEN);
	        
		setContentView(R.layout.gamewindow);
		
		score = (TextView) findViewById(R.id.tvScore);
		pazinojums = (TextView) findViewById(R.id.tvMessage);
		
		restart = (Button) findViewById(R.id.bRestartGame);
		
		poguArray[0]= (ImageButton) findViewById(R.id.imb1);
		poguArray[1]= (ImageButton) findViewById(R.id.imb2);
		poguArray[2]= (ImageButton) findViewById(R.id.imb3);
		poguArray[3]= (ImageButton) findViewById(R.id.imb4);
		poguArray[4]= (ImageButton) findViewById(R.id.imb5);
		poguArray[5]= (ImageButton) findViewById(R.id.imb6);
		poguArray[6]= (ImageButton) findViewById(R.id.imb7);
		poguArray[7]= (ImageButton) findViewById(R.id.imb8);
		poguArray[8]= (ImageButton) findViewById(R.id.imb9);
		
		restart.setOnClickListener(this);
		
		score.setText(""+punkti);
		
		//uzliekam visaam pogaam click listenerus
		for(int i=0; i<poguArray.length; i++)
			poguArray[i].setOnClickListener(this);
		
	}
	
	//pogu nospiesanas listeners
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		switch(arg0.getId()){
		case R.id.bRestartGame:
			finish();
			Intent spelesLogs = new Intent("com.example.tictactoe_game.GameActivity");
			startActivity(spelesLogs);
			
			
			//restartejam parbaudes arraju
			for(int i=0; i<Logika.parbArray.length; i++)
				Logika.parbArray[i]='n';
			break;
			
		case R.id.imb1:
			poguDarbibas(0);
			break;
		case R.id.imb2:
			poguDarbibas(1);
			break;
		case R.id.imb3:
			poguDarbibas(2);
			break;
		case R.id.imb4:
			poguDarbibas(3);
			break;
		case R.id.imb5:
			poguDarbibas(4);
			break;
		case R.id.imb6:
			poguDarbibas(5);
			break;
		case R.id.imb7:
			poguDarbibas(6);
			break;
		case R.id.imb8:
			poguDarbibas(7);
			break;
		case R.id.imb9:
			poguDarbibas(8);
			break;
		}
		
	}
	
	public void poguDarbibas(int i){
		
		//ieliek x pogai atbilstosajaa arraja pozicijaa
		Logika.parbArray[i]='x';
		//pazinojums.setText("Arraja elements "+i+"tika parveidots par : "+Logika.parbArray[i]);
		pogaNospiesta =true;
		//uz nospietas pogas uzzime x
		poguArray[i].setImageResource(R.drawable.cross);
		//padara pogu neaktivu
		poguArray[i].setClickable(false);
		
		//palaiz parbaudes speles cilpu, kura skatisies nospiestas pogas
		Logika.galvenaCilpa();
		
	}

}
