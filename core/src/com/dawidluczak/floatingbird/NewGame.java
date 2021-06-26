package com.dawidluczak.floatingbird;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.utils.Array;

public class NewGame extends Game {
	
	private int enemiesPassed;
	private int minEnemiesCount;
	protected final Array<AngryFly> enemies;
	
	NewGame(){
		super();
		enemies = new Array<>();
		minEnemiesCount = 1;
		enemiesPassed = 0;
		addEnemies();
	}
	
	@Override
	public void play(FloatingFlies floatingFlies) {
		flyingEnemies(floatingFlies);
		fly.flying(floatingFlies);
		floatingFlies.drawScoreLabel(String.valueOf(enemiesPassed));
	}
	
	private void flyingEnemies(FloatingFlies floatingFlies){
		for (AngryFly enemy : enemies) {
			enemy.flying(floatingFlies);
			ifEnemyPassedAddNewRandomAngryFly(enemy);
			
			if (Intersector.overlaps(fly.getObjectArea(), enemy.getObjectArea())) {
				floatingFlies.stopGame();
			}
		}
	}
	
	private void ifEnemyPassedAddNewRandomAngryFly(AngryFly fly){
		if (fly.isOutOfScreen()){
			enemiesPassed++;
			fly.reloadPassedFlyWithRandoms();
			
			if (enemiesPassed % minEnemiesCount == 0){
				minEnemiesCount++;
				enemies.add(AngryFly.randomFly());
			}
		}
	}
	
	protected void addEnemies(){
		int numberOfEnemies = (minEnemiesCount + (int)(Math.random() * 1));
		for (int i = 0; i < numberOfEnemies; i++){
			enemies.add(AngryFly.randomFly());
		}
	}
	
	public int getEnemiesPassed() {
		return enemiesPassed;
	}
}
