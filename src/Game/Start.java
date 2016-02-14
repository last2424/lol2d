package Game;

import Start.Main;

public class Start {
	static GameLogic gl = new GameLogic();
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	public static void main(String[] args) {
		new Main(gl, WIDTH, HEIGHT, 120);
	}

}
