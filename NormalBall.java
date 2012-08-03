import java.awt.Color;
import java.awt.Graphics;


// 通常状態のボール

public class NormalBall extends Ball
{
	int			m_PosX;		// X座標
	int			m_PosY;		// Y座標

	public NormalBall()
	{
		m_PosX = 200;
		m_PosY = 70;
	}

	public void draw( Graphics graphics )
	{
		graphics.setColor( Color.WHITE );
		graphics.fillArc( Application.canvasX( m_PosX ), Application.canvasY( m_PosY ), 8, 8, 0, 360 );
	}

	public void update()
	{

	}
}
