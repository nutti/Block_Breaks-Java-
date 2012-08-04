import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


// 通常状態のボール

public class NormalBall extends Ball
{

	private Rectangle	m_BoundBox;	// 当たり判定

	private double		m_VelocityX;		// X方向速度
	private double		m_VelocityY;		// Y方向の速度

	public NormalBall()
	{
		m_BoundBox = new Rectangle( 200, 70, 5, 5 );
		m_VelocityX = 1.0;
		m_VelocityY = 1.0;
	}

	// 描画
	public void draw( Graphics graphics )
	{
		graphics.setColor( Color.WHITE );
		graphics.fillArc(	Application.canvasX( m_BoundBox.x ),
							Application.canvasY( m_BoundBox.y ),
							m_BoundBox.width,
							m_BoundBox.height,
							0, 360 );
	}

	// 更新
	public void update()
	{
		m_BoundBox.x += m_VelocityX;
		m_BoundBox.y += m_VelocityY;

		if( m_BoundBox.y < Application.canvasY( 15 ) ){
			m_VelocityY = - m_VelocityY;
		}
		if( m_BoundBox.x < Application.canvasX( 15 ) ){
			m_VelocityX = - m_VelocityX;
		}
		if( m_BoundBox.x > Application.canvasX( 480 ) ){
			m_VelocityX = - m_VelocityX;
		}
	}

	// ディスパッチ処理
	public void collided( CollisionObject obj )
	{
		obj.processCollision( this );
	}

	// プレイヤーとの衝突処理
	protected void processCollision( Player player )
	{
		// Y方向の速度を反転させる。
		m_VelocityY = - m_VelocityY;
	}

	// ボールとの衝突処理
	protected void processCollision( Ball ball )
	{
		// 自身との衝突なので、無視。
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
