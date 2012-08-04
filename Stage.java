import java.awt.Color;
import java.awt.Graphics;


// ステージ画面

public class Stage extends Scene
{
	private BlockGroup			m_Block;			// ブロック
	private Player			m_Player;			// プレイヤー
	private Ball			m_Ball;				// ボール

	public final static int		GAME_AREA_FRAME		= 15;		// フレームの幅
	public final static int		GAME_AREA_WIDTH		= 480;		// ゲーム領域の横幅
	public final static int		GAME_AREA_HEIGHT	= 450;		// ゲーム領域の縦幅

	// コンストラクタ
	public Stage()
	{
		super();
		m_Block = new BlockGroup();
		m_Player = new NormalPlayer();
		m_Ball = new NormalBall();
	}

	// 更新
	public final void update( InputManager manager )
	{
		// 衝突判定
		if( m_Player.isCollided( m_Ball ) ){
			m_Player.collided( m_Ball );
			m_Ball.collided( m_Player );
		}

		m_Player.update( manager );
		m_Ball.update();
	}

	// 描画
	public void draw( Graphics graphics )
	{
		m_Block.draw( graphics );
		m_Player.draw( graphics );
		m_Ball.draw( graphics );

		// 枠の描画
		graphics.setColor( Color.GRAY );
		graphics.fillRect( Application.canvasX( 0 ), Application.canvasY( 0 ), Application.WINDOW_WIDTH, GAME_AREA_FRAME );
		graphics.fillRect( Application.canvasX( 0 ), Application.canvasY( 0 ), GAME_AREA_FRAME, Application.WINDOW_HEIGHT );
		graphics.fillRect( Application.canvasX( 0 ), Application.canvasY( GAME_AREA_HEIGHT + GAME_AREA_FRAME ), Application.WINDOW_WIDTH, GAME_AREA_FRAME );
		graphics.fillRect( Application.canvasX( GAME_AREA_WIDTH ), Application.canvasY( 0 ), GAME_AREA_FRAME, Application.WINDOW_HEIGHT );


	}

	// 初期化
	public void Init()
	{

	}
}
