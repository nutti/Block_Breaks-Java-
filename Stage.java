import java.awt.Graphics;


// ステージ画面

public class Stage extends Scene
{
	private Block		m_Block;

	// コンストラクタ
	public Stage()
	{
		super();
		m_Block = new Block();
	}

	// 更新
	public final void update()
	{

	}

	// 描画
	public void draw( Graphics graphics )
	{
		m_Block.draw( graphics );
	}

	// 初期化
	public void Init()
	{

	}
}
