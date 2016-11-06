package com.example.tictactoe_game;

import java.util.Random;

import android.graphics.Color;

public class Logika {
	//Arrays parbArray satures n ja nav ne o ne x , x ja speletajs nospiez x un o ja dators tur ieliek o. Šo arraju parbaudis speles logika 
	// un noteiks nakamo gajienu
	static char[] parbArray = {'n','n','n','n','n','n','n','n','n'};
	
	static GameActivity game = new GameActivity();
	
	static Random rand = new Random();
	
	static boolean uzvareja = false;
	
	static void galvenaCilpa(){
			
		if(GameActivity.pogaNospiesta){
			uzvareja = false;
			//sakumaa parbaudam vai kurs nav vinnejis
			uzvarasParbaudeX();
			datoraGajiens();
			datoraUzvarasParbaude();
			if(brivaVieta() == false){
				if(uzvareja ==false)
					GameActivity.pazinojums.setText("No more Moves, restart game");
			}
			GameActivity.pogaNospiesta=false;
				
		}
			
		
	}
	
	

	//datora logika sava gajiena parbaude
	private static void datoraGajiens() {
		// TODO Auto-generated method stub
		
		//dators parbauda vai ir iespeja uzvareet
		//pirmas rindas visu iespeju parbaude
		
		if(datorsLiekO(0,1,2));
		else if(datorsLiekO(0,2,1));
		else if(datorsLiekO(1,2,0));
		
		//otraas rindas parbaude
		else if(datorsLiekO(3,4,5));
		else if(datorsLiekO(5,4,3));
		else if(datorsLiekO(3,5,4));
		
		//tresas rindas parbaude
		else if(datorsLiekO(6,7,8));
		else if(datorsLiekO(6,8,7));
		else if(datorsLiekO(7,8,6));
		
		//pirmaa stabina parbaude
		else if(datorsLiekO(0,3,6));
		else if(datorsLiekO(3,6,0));
		else if(datorsLiekO(0,6,3));
		
		//otraa stabina parbaude
		else if(datorsLiekO(1,4,7));
		else if(datorsLiekO(7,1,4));
		else if(datorsLiekO(7,4,1));
		
		//tresaa stabina parbaude
		else if(datorsLiekO(2,5,8));
		else if(datorsLiekO(8,2,5));
		else if(datorsLiekO(5,8,2));
		
		//diagonale no augseja stura parbaude
		else if(datorsLiekO(0,4,8));
		else if(datorsLiekO(8,4,0));
		else if(datorsLiekO(0,8,4));
		
		//diagonale no apakseja stura parbaude
		else if(datorsLiekO(6,4,2));
		else if(datorsLiekO(6,2,4));
		else if(datorsLiekO(2,4,6));
		
		//tagad blokeesanas logika 
		//tas pasas parbaudes tikai metodee datorsBlokee
		
		else if(datorsBlokee(0,1,2));
		else if(datorsBlokee(0,2,1));
		else if(datorsBlokee(1,2,0));
		
		//otraas rindas parbaude
		else if(datorsBlokee(3,4,5));
		else if(datorsBlokee(5,4,3));
		else if(datorsBlokee(3,5,4));
		
		//tresas rindas parbaude
		else if(datorsBlokee(6,7,8));
		else if(datorsBlokee(6,8,7));
		else if(datorsBlokee(7,8,6));
		
		//pirmaa stabina parbaude
		else if(datorsBlokee(0,3,6));
		else if(datorsBlokee(3,6,0));
		else if(datorsBlokee(0,6,3));
		
		//otraa stabina parbaude
		else if(datorsBlokee(1,4,7));
		else if(datorsBlokee(7,1,4));
		else if(datorsBlokee(7,4,1));
		
		//tresaa stabina parbaude
		else if(datorsBlokee(2,5,8));
		else if(datorsBlokee(8,2,5));
		else if(datorsBlokee(5,8,2));
		
		//diagonale no augseja stura parbaude
		else if(datorsBlokee(0,4,8));
		else if(datorsBlokee(8,4,0));
		else if(datorsBlokee(0,8,4));
		
		//diagonale no apakseja stura parbaude
		else if(datorsBlokee(6,4,2));
		else if(datorsBlokee(6,2,4));
		else if(datorsBlokee(2,4,6));
		//ja neizpildas iespeja uzvareet tad ieliek vienu no random pozicijaam
		else {
			while(brivaVieta()){
				
				int randomPozicija = rand.nextInt(9);
				if(parbArray[randomPozicija] == 'n'){
					parbArray[randomPozicija] = 'o';
					GameActivity.poguArray[randomPozicija].setImageResource(R.drawable.round);
					GameActivity.poguArray[randomPozicija].setClickable(false);
					break;
				}
			}
		}
		
	}
	
	//parbauda vai speletajs uzvareja
	public static void uzvarasParbaudeX(){
		
		//veicam parbaudi pa rindam krustiniem
		if(parbArray[0] == 'x' && parbArray[1] == 'x' && parbArray[2] == 'x'){
			
			uzvaraX(0,1,2);
		}
		
		if(parbArray[3] == 'x' && parbArray[4] == 'x' && parbArray[5] == 'x'){
			
			uzvaraX(3,4,5);
		}
		
		if(parbArray[6] == 'x' && parbArray[7] == 'x' && parbArray[8] == 'x'){
			
			uzvaraX(6,7,8);
		}
		
		if(parbArray[0] == 'x' && parbArray[3] == 'x' && parbArray[6] == 'x'){
			
			uzvaraX(0,3,6);
		}
		
		if(parbArray[1] == 'x' && parbArray[4] == 'x' && parbArray[7] == 'x'){
			
			uzvaraX(1,4,7);
		}
		
		if(parbArray[2] == 'x' && parbArray[5] == 'x' && parbArray[8] == 'x'){
			
			uzvaraX(2,5,8);
		}
		//diagonalu parbaude
		if(parbArray[0] == 'x' && parbArray[4] == 'x' && parbArray[8] == 'x'){
			
			uzvaraX(0,4,8);
		}
		
		if(parbArray[6] == 'x' && parbArray[4] == 'x' && parbArray[2] == 'x'){
			
			uzvaraX(6,4,2);
		}
	}
	
	public static void uzvaraX(int i1, int i2, int i3){
		
		uzvareja =true;
		GameActivity.pazinojums.setText("Gratz You Win!!!");
			GameActivity.punkti ++;
			GameActivity.score.setText(""+GameActivity.punkti);
			GameActivity.poguArray[i1].setColorFilter(Color.GREEN);
			GameActivity.poguArray[i2].setColorFilter(Color.GREEN);
			GameActivity.poguArray[i3].setColorFilter(Color.GREEN);
			
			//padara visas pogas nespiezamas pec uzvaras
			for(int i=0; i<GameActivity.poguArray.length; i++){
				GameActivity.poguArray[i].setClickable(false);
			}
		
	}
	
	//dators parbauda vai ir uzvarejis
	private static void datoraUzvarasParbaude() {
		// TODO Auto-generated method stub
		
		//veicam parbaudi pa rindam krustiniem
				if(parbArray[0] == 'o' && parbArray[1] == 'o' && parbArray[2] == 'o'){
					
					uzvarao(0,1,2);
				}
				
				if(parbArray[3] == 'o' && parbArray[4] == 'o' && parbArray[5] == 'o'){
					
					uzvarao(3,4,5);
				}
				
				if(parbArray[6] == 'o' && parbArray[7] == 'o' && parbArray[8] == 'o'){
					
					uzvarao(6,7,8);
				}
				
				if(parbArray[0] == 'o' && parbArray[3] == 'o' && parbArray[6] == 'o'){
					
					uzvarao(0,3,6);
				}
				
				if(parbArray[1] == 'o' && parbArray[4] == 'o' && parbArray[7] == 'o'){
					
					uzvarao(1,4,7);
				}
				
				if(parbArray[2] == 'o' && parbArray[5] == 'o' && parbArray[8] == 'o'){
					
					uzvarao(2,5,8);
				}
				//diagonalu parbaude
				if(parbArray[0] == 'o' && parbArray[4] == 'o' && parbArray[8] == 'o'){
					
					uzvarao(0,4,8);
				}
				
				if(parbArray[6] == 'o' && parbArray[4] == 'o' && parbArray[2] == 'o'){
					
					uzvarao(6,4,2);
				}
			}
			
			public static void uzvarao(int i1, int i2, int i3){
					
					uzvareja=true;
					GameActivity.pazinojums.setText("Sorry Android Beat You !!!");
					GameActivity.punkti --;
					GameActivity.score.setText(""+GameActivity.punkti);
					GameActivity.poguArray[i1].setColorFilter(Color.YELLOW);
					GameActivity.poguArray[i2].setColorFilter(Color.YELLOW);
					GameActivity.poguArray[i3].setColorFilter(Color.YELLOW);
					
					//padara visas pogas nespiezamas pec uzvaras
					for(int i=0; i<GameActivity.poguArray.length; i++){
						GameActivity.poguArray[i].setClickable(false);
					}
				
			}
		
	//funkcija parbaudis vai datoram ir vieta kur likt nakamo o
	// ja ir tad atgriez true
	public static boolean brivaVieta(){
		
		for(char a : parbArray){
			if(a=='n')
				return true;
		}
		return false;
	}
	
	public static boolean datorsLiekO(int i1, int i2, int iUzv){
		if(parbArray[i1] == 'o' && parbArray[i2] == 'o' && parbArray[iUzv] =='n' ){
			//izsaucam metodi kas ieliek o
			GameActivity.poguArray[iUzv].setImageResource(R.drawable.round);
			parbArray[iUzv] = 'o';
			GameActivity.poguArray[iUzv].setClickable(false);
			return true;
		}
		return false;
	}
	
	public static boolean datorsBlokee(int i1, int i2, int iUzv){
		if(parbArray[i1] == 'x' && parbArray[i2] == 'x' && parbArray[iUzv] =='n' ){
			//izsaucam metodi kas ieliek o
			GameActivity.poguArray[iUzv].setImageResource(R.drawable.round);
			parbArray[iUzv] = 'o';
			GameActivity.poguArray[iUzv].setClickable(false);
			return true;
		}
		return false;
	}

}
