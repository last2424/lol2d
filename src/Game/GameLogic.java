package Game;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import Game.Entity.Direction;
import Start.Camera;
import Start.Game;
import Start.KeyboardEngine;
import Start.Main;
import Start.MouseEngine;
import Start.SpriteBatch;
import Start.Texture;
import Start.Vector2;

public class GameLogic implements Game {
	int selectblock = 1;
	
	SpriteBatch batch;
	ArrayList<Block> blocks = new ArrayList<Block>();
	
	Vector2 camera = new Vector2(10, 20);
	
	Texture playerTexture;
	EntityPlayer player;
	
	Vector2 velocity = new Vector2(3, 3);
	@Override
	public void create() {
		batch = new SpriteBatch();
		Main.setCamera(new Camera(camera,new Vector2(Main.WIDTH,Main.HEIGHT)));
		playerTexture = new Texture("player.png");
		player = new EntityPlayer(20, 1, 0, 0, 0, 32, 64, playerTexture);
	}

	@Override
	public void render() {
		update();
		batch.setBackgroundColor(117, 187, 253);
		batch.Clear();
		player.render(batch);
		for(int i = 0; i < blocks.size(); i++){
			blocks.get(i).render(batch);
		}
	}
	private void Addedblock(Block block){
		if(!blocks.contains(block)){
			blocks.add(block);
		}
	}
	private void RemovedBlock(Vector2 pos){
		Block block = new WoodBlock("wood", Material.WOOD, MouseEngine.getWorldX(), MouseEngine.getWorldY());
		
		int index = blocks.indexOf(block);
		if(index >= 0){
			blocks.remove(index);
		}
	}
	private void update() {
		boolean left = false;
		boolean right = false;
		boolean up = false;
		boolean down = false;
		
		camera.x = player.x;
		camera.y = player.y;
		camera.x -= Start.WIDTH/2-32;
		camera.y -= Start.HEIGHT/2-32;
		if(camera.x < 0 ) camera.x = 0;
		else if(camera.x>1000-Start.WIDTH) camera.x = 1000-Start.WIDTH;
		if(camera.y < 0 ) camera.y = 0;
		else if(camera.y>1000-Start.HEIGHT ) camera.y = 1000-Start.HEIGHT;
		
		for(int i = 0; i < blocks.size(); i++){
			if(player.x+32 >= blocks.get(i).x && player.x <= blocks.get(i).x+32 &&
					player.y+64 >= blocks.get(i).y && player.y <= blocks.get(i).y+32 ){
				player.onground = true;
			}else{
				player.onground = false;
			}
		}
		
		if(player.onground){
			velocity.y = 0;
		}else{
			velocity.y = 3;
		}
		
		
		if(MouseEngine.isMouseButton(0)){
			if(selectblock == 1)
			Addedblock(new WoodBlock("wood", Material.WOOD, MouseEngine.getWorldX(), MouseEngine.getWorldY()));
			if(selectblock == 2)
			Addedblock(new StoneBlock("stone", Material.STONE, MouseEngine.getWorldX(), MouseEngine.getWorldY()));
			if(selectblock == 3)
			Addedblock(new GlassBlock("glass", Material.GLASS, MouseEngine.getWorldX(), MouseEngine.getWorldY(), 0, 255, 0));
		}
		else if(MouseEngine.isMouseButton(1)){
			RemovedBlock(new Vector2(MouseEngine.getWorldX(), MouseEngine.getWorldY()));
		}
		
		if(KeyboardEngine.getKeyDown(Keyboard.KEY_1)){
			selectblock = 1;
		}
		if(KeyboardEngine.getKeyDown(Keyboard.KEY_2)){
			selectblock = 2;
		}
		if(KeyboardEngine.getKeyDown(Keyboard.KEY_3)){
			selectblock = 3;
		}
		if(KeyboardEngine.getKeyDown(Keyboard.KEY_A)){
			left = true;
		}
		if(KeyboardEngine.getKeyDown(Keyboard.KEY_D)){
			right = true;
		}
		if(KeyboardEngine.getKeyDown(Keyboard.KEY_S)){
			down = true;
		}
		if(KeyboardEngine.getKeyDown(Keyboard.KEY_W)){
			up = true;
		}
		
		if(left){
			player.move(Direction.LEFT, (int) velocity.x);
		}
		if(right){
			player.move(Direction.RIGHT, (int) velocity.x);
		}
		if(up){
			player.move(Direction.UP, (int) velocity.y);
		}
		if(down){
			player.move(Direction.DOWN, (int) velocity.y);
		}
	}

}