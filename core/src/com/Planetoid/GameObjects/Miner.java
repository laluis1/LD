package com.Planetoid.GameObjects;

import com.Planetoid.Engine.Entity;
import com.Planetoid.Main.Planetoid;
import com.Planetoid.Screens.GameScreen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Miner extends Entity{
public float position;
Sprite miner;
double i = 100, cooldownSpeed = .1;
	public Miner(int x, int y, Planetoid gam, GameScreen gs, float pos) {
		super(x, y, gam, gs);
		position = pos;
		miner = new Sprite(new Texture("Miner.png"));
	}
	
	public void update(float deltaTime){
		i-=cooldownSpeed;
		if(i <= 0){
			gamescreen.p.fuel+=1;
			i=100;
		}
	}
	
	public void draw(){
		game.batch.begin();
		game.batch.draw(miner, x, y, 20, -250, 40, 40, 1f, 1f, position, false);
		if(gamescreen.instructions){}
		game.batch.end();
	}

}
