package Start;

import org.lwjgl.opengl.GL11;

public class Camera {
	public Vector2 position;
	public Vector2 size;
	public Camera(Vector2 pos, Vector2 size){
		this.position = pos;
		this.size = size;
	}
	public void cameradraw(){
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(position.x, size.x+position.x, size.y+position.y, position.y, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
}
