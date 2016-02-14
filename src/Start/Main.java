package Start;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

import Game.GameLogic;

public class Main {
	//Display Constants
	public static int WIDTH;
	public static int HEIGHT;
	
	public SpriteBatch batch;
	static Camera cameran;
	Texture texture;
	public static void setCamera(Camera camera){
		cameran = camera;
	}
	public static Camera getCamera(){
		return cameran;
	}
	public Main(GameLogic gl, int WIDTH, int HEIGHT, int FPS_CAP) {
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setTitle("Game");
			Display.create();
		} catch (LWJGLException e) {e.printStackTrace(); System.exit(0);}
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);               
		 
   
 
        	GL11.glEnable(GL11.GL_BLEND);
        	GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
 
        	GL11.glViewport(0,0,WIDTH,HEIGHT);
    		GL11.glMatrixMode(GL11.GL_PROJECTION);
    		GL11.glLoadIdentity();
    		GL11.glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
    		GL11.glMatrixMode(GL11.GL_MODELVIEW);
    		
    		gl.create();
		while(!Display.isCloseRequested()){
			cameran.cameradraw();
			Display.sync(FPS_CAP);
			Display.update();
			gl.render();
			KeyboardEngine.update();
		}
		
		Display.destroy();
	}
}
