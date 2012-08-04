import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


// 通常のブロック

public class NormalBlock extends Block
{
	private int			m_Score;		// 得点
	private boolean		m_Destroyed;	// 破壊されたか？

	// コンストラクタ
	public NormalBlock( int row, int column )
	{
		super();
		m_BoundBox = new Rectangle(	row * ( WIDTH + 1 ) + OFFSET_X,
									column * ( HEIGHT + 1 ) + OFFSET_Y,
									WIDTH, HEIGHT );
		m_Reflectable = true;
		m_Score = 100;
		m_Destroyed = false;
	}

	public void update()
	{
		if( m_Destroyed ){
			return;
		}
	}

	public void draw( Graphics graphics )
	{
		if( m_Destroyed ){
			return;
		}

		graphics.setColor( Color.yellow );
		graphics.drawRect(	Application.canvasX( m_BoundBox.x ),
							Application.canvasY( m_BoundBox.y ),
							m_BoundBox.width,
							m_BoundBox.height );
	}

	// ディスパッチ処理
	public void collided( CollisionObject obj )
	{
		if( !m_Destroyed ){
			obj.processCollision( this );
		}
	}

	// プレイヤーとの衝突処理
	protected void processCollision( Player player )
	{
		// 処理はなし
	}

	// ボールとの衝突処理
	protected void processCollision( Ball ball )
	{
		m_Destroyed = true;
	}

	// ブロックとの衝突処理
	protected void processCollision( Block block )
	{
		// 自身との衝突であるため、処理は無し
	}
}
