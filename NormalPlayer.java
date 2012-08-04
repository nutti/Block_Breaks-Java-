import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


// 通常時のプレーヤークラス

public class NormalPlayer extends Player
{
	private Rectangle m_BoundBox;		// 衝突判定

	private final static int		POSITION_Y	= 400;		// Y座標（固定）
	private final static int		WIDTH		= 30;		// 横幅
	private final static int		HEIGHT		= 10;		// 縦幅

	private final static int		VELOCITY	= 3;		// 速度

	public NormalPlayer()
	{
		m_BoundBox = new Rectangle( 200, POSITION_Y, WIDTH, HEIGHT );
	}

	public void draw( Graphics graphics )
	{
		graphics.setColor( Color.GREEN );
		graphics.drawRect(	Application.canvasX( m_BoundBox.x ),
							Application.canvasY( m_BoundBox.y ),
							m_BoundBox.width,
							m_BoundBox.height );
	}

	public void update( InputManager manager )
	{
		if( manager.isKeepPushed( InputManager.KEY_CODE_RIGHT ) ){
			m_BoundBox.x += VELOCITY;
		}
		else if( manager.isKeepPushed( InputManager.KEY_CODE_LEFT ) ){
			m_BoundBox.x -= VELOCITY;
		}
	}

	public void collided( CollisionObject obj )
	{
		obj.processCollision( this );
	}

	protected void processCollision( Player player )
	{
	}

	protected void processCollision( Ball ball )
	{
	}

	// 衝突したか？
	public boolean isCollided( CollisionObject obj )
	{
		if( obj.getBoundBox().intersects( m_BoundBox ) ){
			return true;
		}

		return false;
	}

	// 衝突判定を取得する
	protected Rectangle getBoundBox()
	{
		return m_BoundBox;
	}
}
