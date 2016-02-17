package Game;

import java.awt.List;
import java.util.ArrayList;

import Start.Main;
import Start.SpriteBatch;
import Start.Texture;
import Start.Vector2;

public class Entity {
	int health;
	int damage;
	int def;
	double x;
	double y;
	int width;
	int height;
	Texture texture;
	public float R = 255;
	public float G = 255;
	public float B = 255;
	
	Vector2 velocity = new Vector2(10, 20);
	
	public boolean onground;
	public boolean onwall;
	
	public Entity(int health, int damage, int def, int x, int y, int width, int height, Texture texture, Vector2 velocity) {
		this.health = health;
		this.damage = damage;
		this.def = def;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.texture = texture;
		this.velocity = velocity;
	}
	
	public Entity(int health, int damage, int def, int x, int y, int width, int height, Texture texture, Vector2 velocity, float R, float G, float B) {
		this.health = health;
		this.damage = damage;
		this.def = def;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.texture = texture;
		this.R = R;
		this.G = G;
		this.B = B;
		this.velocity = velocity;
	}
	
	public void render(SpriteBatch batch) {
		batch.drawTexture(texture, width, height, (int)x, (int)y, R, G, B);
	}
	
	public void move(Direction dir, int speed) {
		if(dir == Direction.DOWN){
		//	velocity.y = speed;
		}
		if(dir == Direction.LEFT){
			velocity.x = speed;
		}
		if(dir == Direction.RIGHT){
			velocity.x = speed;
		}
		
		if(dir == Direction.UP && onground){
			velocity.y = speed;
		}
	}
	public enum Direction {
		UP,
		DOWN,
		LEFT,
		RIGHT
	}
	
	public void update(ArrayList<Block> blocks, double d) {
		Vector2 temp = new Vector2((float)x, (float)y);
		temp.x += velocity.x*d;
		
		if(temp.x < -0) temp.x+=1*d;
		else if(temp.x > 0)temp.x-=1*d;
		else temp.x = 0;
		onwall = false;
		if(!onwall){
			onground = false;
		for(int i = 0; i < blocks.size(); i++){
			if(temp.x+32 >= blocks.get(i).x*32 && temp.x <= blocks.get(i).x*32+32 &&
					temp.y+64 >= blocks.get(i).y*32 && temp.y <= blocks.get(i).y*32+32 ){
				onground = true;
				velocity.y = 0;
				break;
			}
		}
		}
		
		for(int i = 0; i < blocks.size(); i++){
			if(temp.x+32 >= blocks.get(i).x*32 && temp.x <= blocks.get(i).x*32+32 &&
					temp.y+64 >= blocks.get(i).y*32 && temp.y <= blocks.get(i).y*32+32 ){
				onwall = true;
				velocity.x = 0;
				break;
			}
		}
		
		if(!onground){
			temp.y += velocity.y;
			velocity.y = (float) (160*d);
			
		}
		
		if(temp.x  < 0)temp.x = 0;
		if(temp.x  > 1000-32)temp.x = 1000-32;
		if(temp.y  < 0)temp.y = 0;
		if(temp.y  > 1000 -32)temp.y = 1000 -32;
		if(!onwall) x = temp.x;
		if(!onground) y = temp.y;
	}
}
