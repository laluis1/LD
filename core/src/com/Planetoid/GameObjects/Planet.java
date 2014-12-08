package com.Planetoid.GameObjects;

import com.Planetoid.Engine.Entity;
import com.Planetoid.Main.Planetoid;
import com.Planetoid.Screens.GameScreen;
import com.badlogic.gdx.graphics.Texture;

public class Planet extends Entity{
	Texture planet;
	public Planet(int x, int y, Planetoid gam, GameScreen gs) {
		super(x, y, gam, gs);
		planet = new Texture("PlanetOutside.png");
	}
	
	public void update(float deltaTime){}
	
	public void draw(){
		game.batch.begin();
		game.batch.draw(planet, x, y, 500, 500);
		game.batch.end();
	}
}
