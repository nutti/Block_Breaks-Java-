import java.awt.Graphics;


// ボール基底クラス

public abstract class Ball extends CollisionObject
{
	public abstract void draw( Graphics graphics );
	public abstract void update();
}
