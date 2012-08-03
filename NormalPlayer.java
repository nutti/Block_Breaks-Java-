import java.awt.Color;
import java.awt.Graphics;


// 通常時のプレーヤークラス

public class NormalPlayer extends Player
{
	private int m_PosX;		// X座標

	private final static int		POSITION_Y	= 400;		// Y座標（固定）
	private final static int		WIDTH		= 30;		// 横幅
	private final static int		HEIGHT		= 10;		// 縦幅

	private final static int		VELOCITY	= 3;		// 速度

	public NormalPlayer()
	{
		m_PosX = 5;
	}

	public void draw( Graphics graphics )
	{
		graphics.setColor( Color.GREEN );
		graphics.drawRect( Application.canvasX( m_PosX ), Application.canvasY( POSITION_Y ), WIDTH, HEIGHT );
	}

	public void update( InputManager manager )
	{
		if( manager.isKeepPushed( InputManager.KEY_CODE_RIGHT ) ){
			m_PosX += VELOCITY;
		}
		else if( manager.isKeepPushed( InputManager.KEY_CODE_LEFT ) ){
			m_PosX -= VELOCITY;
		}
	}
}
