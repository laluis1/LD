package com.Planetoid.Engine;

import com.Planetoid.Main.Planetoid;
import com.Planetoid.Screens.GameScreen;

public class Entity {
	public int x, y;
	public Planetoid game;
	public GameScreen gamescreen;
	public Entity(int x, int y, Planetoid gam, GameScreen gs){
		this.x = x;
		this.y = y;
		game = gam;
		gamescreen = gs;
	}
	public void update(float deltaTime){
		
	}
	public void draw(){
		
	}
}
