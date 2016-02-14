package Game;

import Start.SpriteBatch;

public class WoodBlock extends Block {

	public WoodBlock(String unlocalizedName, Material material, int x, int y) {
		super(unlocalizedName, material, x, y);
	}
	
	public WoodBlock(String unlocalizedName, Material material, int x, int y, float r, float g, float b) {
		super(unlocalizedName, material, x, y, r, g, b);
	}

}
