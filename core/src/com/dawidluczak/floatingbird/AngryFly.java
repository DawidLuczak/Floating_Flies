package com.dawidluczak.floatingbird;


public class AngryFly extends Fly{
	
	private float velocityX;
	
	AngryFly(float x, float y, float velocityY, float velocityX) {
		super(x, y);
		this.velocityY = velocityY;
		this.velocityX = velocityX;
		this.image = FlyFactory.getAngryFlyTexture1();
	}
	
	@Override
	public void flying(FloatingFlies floatingFlies) {
		fly();
		updateObjectAreaPosition();
		draw(floatingFlies.batch);
	}
	
	private void fly(){
		y += velocityY;
		x -= velocityX;
		
		if (y <= 0 || y >= FloatingFlies.getScreenHeight()){
			velocityY = -velocityY;
			changeTexture();
		}
	}
	
	private void changeTexture(){
		if (velocityY < 0)
			image = FlyFactory.getAngryFlyTexture1();
		else
			image = FlyFactory.getAngryFlyTexture2();
	}
	
	public boolean isOutOfScreen(){
		return (x <= 0);
	}
	
	public void reloadPassedFlyWithRandoms(){
		x = (float) (FloatingFlies.getScreenWidth() + (Math.random() * 100));
		y = (float) (Math.random() * FloatingFlies.getScreenHeight());
		velocityY = (float) (Math.random() * 2);
		velocityX = (float) (0.5 + Math.random() * 2);
		image = FlyFactory.getAngryFlyTexture1();
	}
	
	public static AngryFly randomFly(){
		float x = (float) (FloatingFlies.getScreenWidth() + (Math.random() * 100));
		float y = (float) (Math.random() * FloatingFlies.getScreenHeight());
		float velocityY = (float) (Math.random() * 2);
		float velocityX = (float) (0.5 + Math.random() * 2);
		return new AngryFly(x, y, velocityY, velocityX);
	}

}

