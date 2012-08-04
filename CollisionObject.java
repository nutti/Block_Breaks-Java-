import java.awt.Rectangle;


// 衝突基底クラス

public abstract class CollisionObject
{
	public abstract void collided( CollisionObject obj );

	protected abstract void processCollision( Player player );
	protected abstract void processCollision( Ball ball );
	//public abstract void colided( Block block );

	public abstract boolean isCollided( CollisionObject obj );

	protected abstract Rectangle getBoundBox();
}
