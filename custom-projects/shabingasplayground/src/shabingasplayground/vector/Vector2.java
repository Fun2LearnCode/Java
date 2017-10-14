package shabingasplayground.vector;

public class Vector2 {
	private float x;
	private float y;
	public Vector2(float x, float y){
		this.x = x;
		this.y = y;
	}
	public void move(float x, float y){
		this.x +=x;
		this.y +=y;
	}
	public void move(Vector2 cord){
		this.x += cord.getX();
		this.y += cord.getY();
	}
	public void setTo(float x, float y){
		this.x = x;
		this.y = y;
	}
	public void setTo(Vector2 cord){
		this.x = cord.getX();
		this.y = cord.getY();
	}
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public int getIntX(){
		return (int)x;
	}
	public int getIntY(){
		return (int)y;
	}
	public float distanceTo(Vector2 v){
		return (float) Math.sqrt(Math.pow(x - v.getX(), 2) + Math.pow(y - v.getY(), 2));
	}
	@Override
	public String toString(){
		return "x : " + x + " y : " + y;
	}
}
