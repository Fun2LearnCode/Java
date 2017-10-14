package shabingasplayground.world.block;

import shabingasplayground.block.Block;
import shabingasplayground.settings.Settings;
import shabingasplayground.world.Layer;

public class BlockLayer extends Layer<Block>{
	public BlockLayer(BlockLayer world){
		
	}
	public BlockLayer(){
		matrix = new Block[Settings.worldHeight][Settings.worldWidth];
	}
	public void run(){
		
	}
}
