package com.Planetoid.Screens;

import java.util.ArrayList;

import com.Planetoid.GameObjects.Enemy;
import com.Planetoid.GameObjects.Miner;
import com.Planetoid.GameObjects.Planet;
import com.Planetoid.GameObjects.Player;
import com.Planetoid.GameObjects.Ship;
import com.Planetoid.GameObjects.planetCore;
import com.Planetoid.Main.Planetoid;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class GameScreen implements Screen{
	Planet planet;
	Planetoid game;
	Texture background;
	public Player p;
	public planetCore core;
	public Ship ship;
	public ArrayList<Miner> miners;
	public BitmapFont font;
	public boolean instructions = false;
	
	Enemy enemy;
	
	public GameScreen(Planetoid gam){
		game = gam;
		background  = new Texture("Space.png");
		planet = new Planet(100, 100, gam, this);
		p = new Player(330, 600, gam, this);
		core = new planetCore(230, 230, gam, this);
		ship = new Ship(310, 600, gam, this);
		miners = new ArrayList<Miner>();
		font = new BitmapFont();
		miners.add(new Miner(330, 600, gam, this, (int)Math.abs(Math.random() * 360)));
		
		enemy = new Enemy(330, 600, gam, this, 0);
		
	}
	
	public void render(float deltaTime){
		font.setScale(1);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		game.batch.begin();
		game.batch.draw(background, 0, 0, 700, 700);
		game.batch.end();
		
		
		planet.draw();
		ship.draw();
		ship.update(deltaTime);
		p.draw();
		p.update(deltaTime);
		core.draw();
		
		game.batch.begin();
		if(!ship.gameStarted){
			game.batch.draw(ship.title, 400, 400);
		}
		game.batch.end();

		enemy.update(deltaTime);
		enemy.draw();
		
		for(int i = 0; i < miners.size(); i++){
			miners.get(i).draw();
			miners.get(i).update(deltaTime);
		}
		
		if(Gdx.input.isKeyJustPressed(Keys.I) && instructions == false){
			instructions = true;
		}else if(Gdx.input.isKeyJustPressed(Keys.I) && instructions){
			instructions = false;
		}
		
		
		Gdx.gl.glFlush();
	}
	public void resize(int x, int y){}
	public void pause(){}
	public void resume(){}
	public void show(){}
	public void hide(){}
	public void dispose(){}
}
