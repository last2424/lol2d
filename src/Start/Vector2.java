package Start;

public class Vector2 {
	
	//статические переменные
	static Vector2 down = new Vector2(0,-1);
	static Vector2 left = new Vector2(-1,0);
	static Vector2 one = new Vector2(1,1);
	static Vector2 right = new Vector2(1,0);
	static Vector2 up = new Vector2(0,1);
	static Vector2 zero = new Vector2(0,0);
	//переменные
	public float x,y;
	
	//конструктор
	public Vector2(float x,float y){
		this.x = x;
		this.y = y;
	}
	
	//функции
	public float magnitude(){
		return (float)Math.sqrt(x*x+y*y);
	}
	public void Normalize(){

		float lenght = magnitude();
		if(lenght != 0){
			x/=lenght;
			y/=lenght;
		}
	}
	public void Set(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
    public String toString() {
		return "x:"+x+"\ny:"+y;
		
	}
	public Vector2 normalized(){
		Vector2 vec = new Vector2(x,y);
		vec.Normalize();
		return vec;
	}
}
