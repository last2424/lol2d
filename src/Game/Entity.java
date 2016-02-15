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
	int x;
	int y;
	int width;
	int height;
	Texture texture;
	public float R = 255;
	public float G = 255;
	public float B = 255;
	
	Vector2 velocity;
	
	public float gravity = 3;
	
	public boolean onground;
	public boolean onwall;
	
	public boolean leftB;
	public boolean rightB;
	public boolean upB;
	public boolean downB;
	
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
		batch.drawTexture(texture, width, height, x, y, R, G, B);
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
	
	public void update(double d) {
		if(!onground){
	//		velocity.y = gravity;
		}
		x += velocity.x*d;
		y += velocity.y*d;
	}
	
	public void collisionDetection(ArrayList<Block> blocks, double d) {
		onground = false;
		for(int i = 0; i < blocks.size(); i++){
			if(x+32 >= blocks.get(i).x*32 && x <= blocks.get(i).x*32+32 &&
					y+64 >= blocks.get(i).y*32 && y <= blocks.get(i).y*32+32 ){
				onground = true;
				break;
			}
		}
		
		if(onground){
			gravity = 0;
			velocity.y = 0;
		}else{
			gravity = (float) (10*d);
		}
	}
}
