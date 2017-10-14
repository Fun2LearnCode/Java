package shabingasplayground.world.sprite;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import shabingasplayground.block.Block;
import shabingasplayground.world.chunk.Chunk;
import shabingasplayground.world.event.BlockListener;

public class SpriteLayerChunkThread implements BlockListener{
	private BufferedImage view;
	private SpriteLayer spriteLayer;
	public SpriteLayerChunkThread(SpriteLayer spriteLayer){
		this.spriteLayer = spriteLayer;
		view = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
	}
	public void renderMap(Graphics g){
		renderMap();
		g.drawImage(view, 0, 0, null);
	}
	private void renderMap(){
		Graphics imageWriter = view.createGraphics();
		for(int r = Chunk.chunkStart.getIntY(); r < Chunk.chunkEnd.getIntY(); r++){
			for(int c = Chunk.chunkStart.getIntX(); c < Chunk.chunkEnd.getIntX(); c++){
				imageWriter.drawImage(spriteLayer.getEntityAt(r, c).getImage(), r * 32, c * 32, null);
			}
		}
	}
	@Override
	public void onBlockChange(Block oldBlock, Block newBlock) {
		spriteLayer.setEntityAt(oldBlock.getPosition(), new Sprite(newBlock.getBlockType()));
		renderMap();
	}
}
