package shabingasplayground.world.sprite;

import shabingasplayground.settings.Settings;
import shabingasplayground.world.Layer;
import shabingasplayground.world.block.BlockLayer;

public class SpriteLayer extends Layer<Sprite>{
	public SpriteLayer(BlockLayer world){
		matrix = new Sprite[Settings.worldHeight][Settings.worldWidth];
		for(int r = 0; r < Settings.worldHeight; r++){
			for(int c = 0; c < Settings.worldWidth; c++){
				setEntityAt(r, c, new Sprite(world.getEntityAt(r,c).getBlockType()));
			}
		}
	}
	@Override
	public void run(){
		
	}
}
