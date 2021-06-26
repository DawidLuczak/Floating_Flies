package com.dawidluczak.floatingFlies;

import com.badlogic.gdx.Gdx;

public class MyFly extends Fly{
	
	private final float gravity;
	
	MyFly(float x, float y) {
		super(x, y);
		this.gravity = 0.1f;
		image = FlyFactory.getMyFlyTexture1();
	}
	
	private void gravityForce(){
		velocityY += gravity;
		y -= velocityY;
	}
	
	private void validFlyPosition(FloatingFlies floatingFlies){
		if (y < HEIGHT){
			y = FloatingFlies.getScreenHeight()/2;
			floatingFlies.stopGame();
		} else if (y > FloatingFlies.getScreenHeight() - 30){
			y = FloatingFlies.getScreenHeight() - 30;
			velocityY = 0;
		} else {
			gravityForce();
		}
	}
	
	@Override
	public void flying(FloatingFlies floatingFlies){
		draw(floatingFlies.batch);
		fly();
		validFlyPosition(floatingFlies);
		updateObjectAreaPosition();
	}
	
	private void fly(){
		if (Gdx.input.isButtonJustPressed(1)){
			velocityY = -5f;
			changeTexture();
		}
	}
	
	private void changeTexture(){
		switch (image.toString()){
			default:
			case "fly1.png":
				image = FlyFactory.getMyFlyTexture2();
				break;
			case "fly2.png":
				image = FlyFactory.getMyFlyTexture1();
				break;
		}
	}
}
