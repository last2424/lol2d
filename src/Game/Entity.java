package Game;

import Start.SpriteBatch;
import Start.Texture;

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
	
	public boolean onground;
	public boolean onwall;
	
	public Entity(int health, int damage, int def, int x, int y, int width, int height, Texture texture) {
		this.health = health;
		this.damage = damage;
		this.def = def;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.texture = texture;
	}
	
	public Entity(int health, int damage, int def, int x, int y, int width, int height, Texture texture, float R, float G, float B) {
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
	}
	
	public void render(SpriteBatch batch) {
		batch.drawTexture(texture, width, height, x, y, R, G, B);
	}
	
	public void move(Direction dir, int speed) {
		if(dir == Direction.UP){
			this.y -= speed;
		}
		if(dir == Direction.DOWN){
			this.y += speed;
		}
		if(dir == Direction.LEFT){
			this.x -= speed;
		}
		if(dir == Direction.RIGHT){
			this.x += speed;
		}
	}
	
	public enum Direction {
		UP,
		DOWN,
		LEFT,
		RIGHT
	}
}
