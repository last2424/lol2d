package Game;

import Start.SpriteBatch;
import Start.Texture;
import Start.Vector2;

public class EntityPlayer extends Entity {

	public EntityPlayer(int health, int damage, int def, int x, int y, int width, int height, Texture texture, Vector2 velocity) {
		super(health, damage, def, x, y, width, height, texture, velocity);
	}
	
	public EntityPlayer(int health, int damage, int def, int x, int y, int width, int height, Texture texture, Vector2 velocity, float R, float G, float B) {
		super(health, damage, def, x, y, width, height, texture, velocity, R, G, B);
	}
	
	@Override
	public void render(SpriteBatch batch) {
		super.render(batch);
	}
}
