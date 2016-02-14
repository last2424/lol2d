package Start;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class Texture {
	 int texture;
	 private static final int BYTES_PER_PIXEL = 4;
	 
	    public Texture(final String path){
	        int texture = 0;
	        try {
	        InputStream IS = Main.class.getResourceAsStream("../resources/"+path);
	        ByteArrayOutputStream BAOS = new ByteArrayOutputStream();
	        int read1 = IS.read(); while (read1 != -1) { BAOS.write(read1); read1 = IS.read(); }
	        byte[] textureBA = BAOS.toByteArray();
	        BAOS.close();
	        BufferedImage textureBI = ImageIO.read(new ByteArrayInputStream(textureBA));
	        texture = loadTexture(textureBI);
	        } catch (IOException e) {e.printStackTrace();}    
	        this.texture = texture;
	    }
	 
	    private static int loadTexture(BufferedImage image){
	        int[] pixels = new int[image.getWidth() * image.getHeight()];
	        image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());
	        ByteBuffer buffer = BufferUtils.createByteBuffer(image.getWidth() * image.getHeight() * BYTES_PER_PIXEL); //4 for RGBA, 3 for RGB
	         for(int y = 0; y < image.getHeight(); y++){
	            for(int x = 0; x < image.getWidth(); x++){
	                int pixel = pixels[y * image.getWidth() + x];
	                buffer.put((byte) ((pixel >> 16) & 0xFF));    // Red component
	                buffer.put((byte) ((pixel >> 8) & 0xFF));     // Green component
	                buffer.put((byte) (pixel & 0xFF));            // Blue component
	                buffer.put((byte) ((pixel >> 24) & 0xFF));    // Alpha component. Only for RGBA
	            }
	        }
	        buffer.flip(); //FOR THE LOVE OF GOD DO NOT FORGET THIS
	        // You now have a ByteBuffer filled with the color data of each pixel.
	        // Now just create a texture ID and bind it. Then you can newTexture it using 
	        // whatever OpenGL method you want, for example:
	        int textureID = GL11.glGenTextures(); //Generate texture ID
	        GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureID); //Bind texture ID
	        //Setup wrap mode
	        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
	        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
	        //Setup texture scaling filtering
	        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
	        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
	        //Send texel data to OpenGL
	        GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA8, image.getWidth(), image.getHeight(), 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, buffer);
	        //Return the texture ID so we can bind it later again
	        return textureID;
	    }
	    
	    public int getTexture() {
	    	return this.texture;
	    }
	     
}
