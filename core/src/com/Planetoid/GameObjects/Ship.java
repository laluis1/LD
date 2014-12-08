package com.Planetoid.GameObjects;

import com.Planetoid.Engine.Entity;
import com.Planetoid.Main.Planetoid;
import com.Planetoid.Screens.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Ship extends Entity{
Sprite ship;
public Texture title;
public boolean hitShip = false, gameStarted = false;
int sleepTime = 1000;
boolean pause = false;
BitmapFont font;
	public Ship(int x, int y, Planetoid gam, GameScreen gs) {
		super(x, y, gam, gs);
		ship = new Sprite(new Texture("ship.png"));
		title = new Texture("Title.png");
		font = new BitmapFont();
		font.setColor(Color.WHITE);
	}
	
	public void update(float deltaTime){
		if(gamescreen.p.position < 15 && gamescreen.p.position > -15){
			 hitShip = true;
		}else{
			hitShip = false;
		}
		
		if(hitShip){
			if(Gdx.input.isKeyJustPressed(Keys.W) || Gdx.input.isKeyPressed(Keys.UP)){
				gamescreen.p.insideShip = true;
			}
		}
		if(!pause){
		if(gamescreen.p.insideShip){
			if(Gdx.input.isKeyJustPressed(Keys.S) || Gdx.input.isKeyPressed(Keys.DOWN)){
				if(gameStarted){
					gamescreen.p.insideShip = false;
					gamescreen.p.position = 0;
				}
				gameStarted = true;
			}
		}
		}
	}
	
	public void win(){
		if(!pause){
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pause = true;
		}
		if(y < 700){
			y+=1;
		}
	}
	
	public void draw(){
		game.batch.begin();
		game.batch.draw(ship, x, y, 80, 120);
		if(gameStarted && !pause){
			if(hitShip && !gamescreen.p.insideShip){
				font.draw(game.batch, "Press W to enter!", x-10, y-10);
			}else if(gamescreen.p.insideShip){
				font.draw(game.batch, "Press S to exit!", x-10, y-10);
			}
		}
		if(pause){
			font.draw(game.batch, "After being stranded, your ship refuels and you can escape back to earth", 10, 670);
		}
		if(gamescreen.p.fuel >= 100){
			if(gamescreen.p.position < 0){
				gamescreen.p.position++;
			}else if(gamescreen.p.position > 0){
				gamescreen.p.position--;
			}
			if(hitShip){
				gamescreen.p.insideShip = true;
				win();
			}
		}
		game.batch.end();
	}

}
