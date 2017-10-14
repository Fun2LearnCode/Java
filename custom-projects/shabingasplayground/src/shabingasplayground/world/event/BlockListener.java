package shabingasplayground.world.event;

import shabingasplayground.block.Block;

public interface BlockListener {
	void onBlockChange(Block oldBlock, Block newBlock);
}
