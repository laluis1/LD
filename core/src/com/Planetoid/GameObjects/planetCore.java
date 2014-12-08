package com.Planetoid.GameObjects;

import com.Planetoid.Engine.Gem;
import com.Planetoid.Main.Planetoid;
import com.Planetoid.Screens.GameScreen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

public class planetCore extends Gem{
Texture GemImage;
	public planetCore(int x, int y, Planetoid gam, GameScreen gs) {
		super(x, y, gam, gs);
		GemImage = new Texture("organicCenter.png");
	}
	
	public void update(float deltaTime){
		
	}
	
	public void draw(){
		Color origin;
		
		game.batch.begin();
		origin = game.batch.getColor();
		game.batch.setColor(Color.GREEN);
		game.batch.draw(GemImage, x, y, 240, 240);
		game.batch.setColor(origin);
		game.batch.end();
		
	}
}
