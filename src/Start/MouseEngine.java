package Start;
import org.lwjgl.input.Mouse;

public class MouseEngine {

	public static boolean isMouseButton(int id) {
		return Mouse.isButtonDown(id);
	}
	
	public static int getX() {
		return Mouse.getX();
	}
	
	public static int getY() {
		return Main.HEIGHT-Mouse.getY();
	}
	public static int getWorldX(){
		return (int) (Main.getCamera().position.x+getX()*(
				Main.getCamera().size.x/Main.WIDTH));
	}
	public static int getWorldY(){
		return (int) (Main.getCamera().position.y+(
				getY()*(Main.getCamera().size.y/Main.HEIGHT) ));
	}
	
}
