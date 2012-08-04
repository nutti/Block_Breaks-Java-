
// ブロックを保持するクラス

import java.awt.Graphics;
import java.util.Iterator;
import java.util.Vector;



public class BlockGroup
{
	Vector < Block >		m_BlockList;		// ブロックリスト

	private final static int	BLOCK_ARRAY_ROW		= 10;		// ブロックの縦列
	private final static int	BLOCK_ARRAY_COL		= 10;		// ブロックの横列


	// コンストラクタ
	public BlockGroup()
	{
		m_BlockList = new Vector < Block > ();

		for( int i = 0; i < BLOCK_ARRAY_ROW; ++i ){
			for( int j = 0; j < BLOCK_ARRAY_COL; ++j ){
				m_BlockList.add( new NormalBlock( i, j ) );
			}
		}
	}

	// 全ブロックの描画
	public void draw( Graphics graphics )
	{
		Iterator < Block > it = m_BlockList.iterator();
		while( it.hasNext() ){
			it.next().draw( graphics );
		}
	}

	// 全ブロックのアップデート
	public void update( Ball ball )
	{
		Iterator < Block > it = m_BlockList.iterator();
		while( it.hasNext() ){
			Block block = it.next();
			if( block.isCollided( ball ) ){
				block.collided( ball );
				ball.collided( block );
			}
		}
	}
}
