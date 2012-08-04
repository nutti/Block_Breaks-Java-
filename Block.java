import java.awt.Graphics;


// ブロック基底クラス

public abstract class Block extends CollisionObject
{
	protected boolean		m_Reflectable;		// 衝突可能か？

	protected static final int		WIDTH = 29;		// 横幅
	protected static final int		HEIGHT = 19;	// 縦幅

	protected static final int		OFFSET_X	= 50;		// 描画時のオフセット（X成分）
	protected static final int		OFFSET_Y	= 50;		// 描画時のオフセット（Y成分）

	public abstract void draw( Graphics graphics );
	public abstract void update();

	// 衝突可能か？
	public boolean isReflectable()
	{
		return m_Reflectable;
	}
}
