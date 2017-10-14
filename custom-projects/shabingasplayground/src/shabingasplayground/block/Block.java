package shabingasplayground.block;

import shabingasplayground.item.ItemBlock;
import shabingasplayground.world.GridEntity;

public abstract class Block extends GridEntity<Block> {
	protected BlockType blockType;
	protected byte hardness;
	protected ItemBlock itemBlock;
	
	public Block(byte hardness){
		this.hardness = hardness;
	}
	public BlockType getBlockType(){
		return blockType;
	}
	public byte hardness(){
		return hardness;
	}
	public ItemBlock getItemBlock(){
		return itemBlock;
	}
}
