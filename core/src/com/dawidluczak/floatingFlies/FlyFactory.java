package com.dawidluczak.floatingFlies;

import com.badlogic.gdx.graphics.Texture;

public class FlyFactory {
	
	private static final Texture[][] textures = new Texture[][]{
			new Texture[]{
					new Texture("angry-fly-1.png"),
					new Texture("angry-fly-2.png")},
	 		new Texture[]{
	 				new Texture("fly-1.png"),
					new Texture("fly-2.png")
			}
	};
	
	public static Texture getAngryFlyTexture1(){
		return textures[0][0];
	}
	
	public static Texture getAngryFlyTexture2(){
		return textures[0][1];
	}
	
	public static Texture getMyFlyTexture1(){
		return textures[1][0];
	}
	
	public static Texture getMyFlyTexture2(){
		return textures[1][1];
	}
}
