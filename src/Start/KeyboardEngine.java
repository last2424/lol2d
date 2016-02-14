package Start;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

public class KeyboardEngine {
	public static final int NUM_KEYCODES = 256;
	private static ArrayList<Integer> currentKeys = new ArrayList<Integer>();
	private static ArrayList<Integer> downKeys = new ArrayList<Integer>();
	private static ArrayList<Integer> upKeys = new ArrayList<Integer>();
	public static void update(){
		
		upKeys.clear();
		for(int i = 0;i<NUM_KEYCODES;i++)
			if(getKeyUp(i) && currentKeys.contains(i))
				upKeys.add(i);
		
		downKeys.clear();
		for(int i = 0;i<NUM_KEYCODES;i++)
			if(getKeyDown(i) && !currentKeys.contains(i))
				downKeys.add(i);
		currentKeys.clear();
		for(int i = 0;i<NUM_KEYCODES;i++)
			if(getKeyDown(i))
				currentKeys.add(i);
	}
	public static boolean getKeyDown(int key) {
		return Keyboard.isKeyDown(key);
	}
	public static boolean getKey(int keyCode) {
		// TODO Auto-generated method stub
		return downKeys.contains(keyCode);
	}
	public static boolean getKeyUp(int keyCode) {
		// TODO Auto-generated method stub
		return upKeys.contains(keyCode);
	}
}
