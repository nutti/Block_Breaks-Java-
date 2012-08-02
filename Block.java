import java.awt.Color;
import java.awt.Graphics;


public class Block
{
	private long[][]		m_Blocks;			// ブロック情報

	private final static int	BLOCK_ARRAY_ROW		= 10;		// ブロックの縦列
	private final static int	BLOCK_ARRAY_COL		= 10;		// ブロックの横列

	// ブロック情報を作成する
	// type : ブロックタイプ、dec : ブロックの装飾方法、data : 装飾のためのデータ
	public final static long createBlockInfo( BlockType type, BlockDecoration dec, int data )
	{
		long info = 0;

		switch( type ){
			case BLOCK_TYPE_NORMAL:
				info |= 1 << 24;
				break;
			default:
				break;
		}

		switch( dec ){
			case BLOCK_DECORATION_NORMAL:
				info |= 1 << 16;
				break;
			case BLOCK_DECORATION_TEXTURE:
				info |= 2 << 16;
				break;
			default:
				break;
		}

		info |= ( data & 0xFF );

		return info;
	}

	// ブロックのタイプ
	enum BlockType
	{
		BLOCK_TYPE_NORMAL,		// 通常ブロック
	}

	// ブロックの装飾
	enum BlockDecoration
	{
		BLOCK_DECORATION_NORMAL,		// 色の付加
		BLOCK_DECORATION_TEXTURE,		// テクスチャ画像
	}

	public Block()
	{
		m_Blocks = new long [ BLOCK_ARRAY_COL ][ BLOCK_ARRAY_ROW ];
	}

	public void setBlockInfo( int row, int col, long info )
	{
		m_Blocks[ row ][ col ] = info;
	}

	public void draw( Graphics graphics )
	{

		for( int i = 0; i < BLOCK_ARRAY_COL; ++i ){
			for( int j = 0; j < BLOCK_ARRAY_ROW; ++j ){
				//long info = m_Blocks[ i ][ j ];
				graphics.setColor( Color.yellow );
				graphics.fillRect( i * 30 + 60, j * 20 + 100, 29, 19 );

			}
		}

	}
}
