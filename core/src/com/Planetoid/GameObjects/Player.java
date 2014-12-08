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

public class Player extends Entity{
	public float position = 0, speed = 0;
	public float fuel = 0, energy = 100;
	float costForMiner = 5;
	boolean dead = false;
	Sprite sprite;
	BitmapFont font;
	public boolean insideShip = true;
	public Player(int x, int y, Planetoid gam, GameScreen gs) {
		super(x, y, gam, gs); 
		sprite = new Sprite(new Texture("astronaut.png"));
		font = new BitmapFont();
		font.setColor(Color.WHITE);
	}

	public void update(float deltaTime){
		if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) && Gdx.input.isKeyPressed(Keys.CONTROL_LEFT) && Gdx.input.isKeyPressed(Keys.C)){
			energy = 100;
			fuel = 100;
			dead = false;
		}
		if(gamescreen.p.position >= 330){
			gamescreen.p.position = -30;
		}else if(gamescreen.p.position <= -330){
			gamescreen.p.position = 30;
		}
		
		speed = deltaTime*50;
		if(!insideShip){
			if(!dead){
			if(Gdx.input.isKeyPressed(Keys.LEFT) || Gdx.input.isKeyPressed(Keys.A)){
				position += speed;
			}
			if(Gdx.input.isKeyPressed(Keys.RIGHT) || Gdx.input.isKeyPressed(Keys.D)){
				position -= speed;
			}
			if(Gdx.input.isKeyJustPressed(Keys.SPACE)){
				if(fuel >= costForMiner){
				gamescreen.miners.add(new Miner(330, 600, game, gamescreen, position));
				fuel-=costForMiner;
				}
			}
			}
			if(energy > 0){
				energy-=.1;
			}else{
				dead = true;
			}
		}else if(energy < 100 && insideShip){
			energy+=.1;
		}
		if(dead){
			sprite = new Sprite(new Texture("astronautFrozen.png"));
		}
	}
	
	public void draw(){
		game.batch.begin();
		if(!insideShip){
			game.batch.draw(sprite, x, y, 20, -250, 40, 60, 1f, 1f, position, false);
		}
		if(!dead && !gamescreen.ship.pause){
			if(gamescreen.ship.gameStarted){
				font.draw(game.batch, "Fuel: " + (int)fuel, 20, 670);
				font.draw(game.batch, "Electricity: " + (int)energy + "%", 20, 650);
			}
		}else if(dead){
			font.draw(game.batch, "Your suit failed and you froze in the vaccum of space never to be found", 20, 670);
		}
		game.batch.end();
	}
}
