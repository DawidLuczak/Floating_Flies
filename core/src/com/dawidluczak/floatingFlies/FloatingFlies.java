package com.dawidluczak.floatingFlies;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class FloatingFlies extends ApplicationAdapter {
	SpriteBatch batch;
	Texture backgroundImage;
	private static float screenWidth, screenHeight;
  private Game game;
	private final Array<Integer> scores = new Array<>();
	private BitmapFont scoreLabel, startLabel;
  
	@Override
	public void create () {
		batch = new SpriteBatch();
		backgroundImage = new Texture("mount-background.jpg");
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		scoreLabel = initFont(Color.GOLD, 6);
		startLabel = initFont(Color.RED, 2);
		game = new Game();
	}

	@Override
	public void render () {
		batch.begin();
		batch.draw(backgroundImage, 0, 0, screenWidth, screenHeight);
		game.play(this);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		backgroundImage.dispose();
	}
	
	public void startGame(){
		game = new NewGame();
	}
	
	public void stopGame(){
		NewGame lastGame = (NewGame) game;
		scores.add(lastGame.getEnemiesPassed());
		game = new Game();
	}
	
	private BitmapFont initFont(Color color, int scale){
		BitmapFont font = new BitmapFont();
		font.setColor(color);
		font.getData().setScale(scale);
		return font;
	}
	
	void drawLabels(float x){
		startLabel.draw(batch, "Press right mouse button to start...", x, FloatingFlies.getScreenHeight()/2);
		if (scores.size > 0)
			drawScoreLabel("Last score: " + getLastScore());
	}
	
	void drawScoreLabel(String text){
		scoreLabel.draw(batch, text, FloatingFlies.getScreenWidth()/2, FloatingFlies.getScreenHeight() - 30);
	}
	
	public static float getScreenHeight() {
		return screenHeight;
	}
	
	public static float getScreenWidth() {
		return screenWidth;
	}
	
	public int getLastScore(){
		return scores.get(scores.size - 1);
	}
}
