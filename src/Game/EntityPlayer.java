package Game;

import Start.SpriteBatch;
import Start.Texture;

public class EntityPlayer extends Entity {

	public EntityPlayer(int health, int damage, int def, int x, int y, int width, int height, Texture texture) {
		super(health, damage, def, x, y, width, height, texture);
	}
	
	@Override
	public void render(SpriteBatch batch) {
		super.render(batch);
	}
}
