package com.Planetoid.GameObjects;

import com.Planetoid.Engine.Entity;
import com.Planetoid.Main.Planetoid;
import com.Planetoid.Screens.GameScreen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Enemy extends Entity{
Sprite enemy;
int position;
float speed;
boolean hitPlayer = false;
	public Enemy(int x, int y, Planetoid gam, GameScreen gs, int position) {
		super(x, y, gam, gs);
		enemy = new Sprite(new Texture("Enemy.png"));
		this.position = position;
	}
	
	public void update(float deltaTime){
		speed = (deltaTime * 60);
		
		if(!gamescreen.p.insideShip){
			if(position >= 320){
				position = -30;
			}else if(position <= -320){
				position = 30;
			}
			if(position < gamescreen.p.position){
				position+=speed;
			}else{
				position-=speed;
			}
		}
		
		if(gamescreen.p.insideShip){
			if(position < 150){
				position+=speed;
			}if(position > 210){
				position-=speed;
			}
		}
		
		if(!gamescreen.p.insideShip){
			if(position > gamescreen.p.position){
				if(position < gamescreen.p.position + 40){
					gamescreen.p.energy-=.1;
				}
			}
		}
			
		
	}
	
	public void draw(){
		game.batch.begin();
		game.batch.draw(enemy, x, y, 20, -250, 40, 60, 1f, 1f, position, false);
		game.batch.end();
	}

}
