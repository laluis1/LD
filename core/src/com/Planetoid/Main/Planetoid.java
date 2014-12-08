package com.Planetoid.Main;

import com.Planetoid.Screens.GameScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Planetoid extends Game {
public SpriteBatch batch;
public OrthographicCamera camera;

	public void create(){
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 700, 700);
		
		setScreen(new GameScreen(this));
	}
	public void render(){
		super.render();
	}
}
