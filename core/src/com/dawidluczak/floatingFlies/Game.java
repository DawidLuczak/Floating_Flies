package com.dawidluczak.floatingFlies;

import com.badlogic.gdx.Gdx;

public class Game {
	
	protected MyFly fly;
	
	Game(){
		fly = new MyFly(FloatingFlies.getScreenWidth()/5, FloatingFlies.getScreenHeight()/2);
	}
	
	public void play(FloatingFlies floatingFlies){
		fly.draw(floatingFlies.batch);
		floatingFlies.drawLabels(fly.x);
		
		if (Gdx.input.isButtonJustPressed(1)){
			floatingFlies.startGame();
		}
	}
	
}
