package Start;

import org.lwjgl.opengl.GL11;

public class SpriteBatch {
	
	public void Begin() {
	}
	
	public void End() {
	}
	
	public void Clear() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
	}
	public void setBackgroundColor(float R, float G, float B){
		
		GL11.glClearColor(R/255, G/255, B/255, 1.0f);
	}
	public void setColor(float R, float G, float B) {
		GL11.glColor3f(R/255,G/255,B/255);
	}
	
	public void drawTexture(Texture texture, int width, int height, int x, int y, float r, float g, float b) {
		Quad(texture.getTexture(), width, height, x, y, r, g, b);
	}
	
	void Quad(int texture, int width, int height, int x, int y, float r, float g, float b) {
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, texture);
		setColor(r, g, b);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex2f(x, y);
		GL11.glTexCoord2f(1, 0);
		GL11.glVertex2f(x+width, y);
		GL11.glTexCoord2f(1, 1);
		GL11.glVertex2f(x+width, y+height);
		GL11.glTexCoord2f(0, 1);
		GL11.glVertex2f(x, y+height);
		GL11.glEnd();
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
	}
}
