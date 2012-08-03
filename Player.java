import java.awt.Graphics;


// プレイヤー基底クラス

public abstract class Player
{

	public abstract void draw( Graphics graphics );
	public abstract void update( InputManager manager );
}
