package com.dawidluczak.floatingbird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;

public abstract class Fly implements FlyInterface{
	protected static final float WIDTH = FloatingFlies.getScreenWidth()/16;
	protected static final float HEIGHT = FloatingFlies.getScreenHeight()/10;
	protected float x, y;
	protected float velocityY;
	protected Texture image;
	private final Circle objectArea;
	
	Fly(float x, float y){
		this.x = x;
		this.y = y;
		this.velocityY = 0;
		this.objectArea = new Circle(this.x + WIDTH/2, this.y + HEIGHT/2, WIDTH/2);
	}
	
	public void draw(SpriteBatch batch){
		batch.draw(image, x, y, WIDTH, HEIGHT);
	}
	
	protected void updateObjectAreaPosition(){
		objectArea.setPosition(this.x + WIDTH/2, this.y + HEIGHT/2);
	}
	
	public Circle getObjectArea() {
		return objectArea;
	}
	
}
