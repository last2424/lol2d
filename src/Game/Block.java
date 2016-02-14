package Game;

import Start.SpriteBatch;
import Start.Texture;

public class Block {
	Texture textureBlock;
	String unlocalizedName;
	Material material;
	public int x;
	public int y;
	public float R = 255;
	public float G = 255;
	public float B = 255;
	
	
	public Block(String unlocalizedName, Material material, int x, int y) {
		this.textureBlock = new Texture(unlocalizedName + ".png");
		this.unlocalizedName = unlocalizedName;
		this.material = material;
		if(x<=0) x-=32;
		this.x = x/32;
		if(y<=0) y-=32;
		this.y = y/32;
	}
	
	public Block(String unlocalizedName, Material material, int x, int y, float R, float G, float B) {
		this.textureBlock = new Texture(unlocalizedName + ".png");
		this.unlocalizedName = unlocalizedName;
		this.material = material;
		if(x<=0) x-=32;
		this.x = x/32;
		if(y<=0) y-=32;
		this.y = y/32;
		this.R = R;
		this.G = G;
		this.B = B;
	}
	
	public Texture getTexture() {
		return textureBlock;
	}
	@Override
	  public boolean equals(Object obj)
	  {
	  //  if(obj == this)
	   // return true;

	     /* obj ссылается на null */

	    if(obj == null)
	    return false;

	      Block tmp = (Block)obj;
	      return tmp.x == x && tmp.y==y;
	  }
	public void render(SpriteBatch batch) {
		batch.drawTexture(this.getTexture(), 32, 32, x*32, y*32, R, G, B);
	}
}