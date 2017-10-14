package shabingasplayground.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import shabingasplayground.settings.Settings;
import shabingasplayground.world.chunk.Chunk;
import shabingasplayground.world.sprite.SpriteLayer;

public class RenderHandler {
	private BufferedImage view;
	private SpriteLayer spriteLayer;
	public RenderHandler(SpriteLayer spriteLayer){
		this.spriteLayer = spriteLayer;
		view = new BufferedImage(Settings.worldHeight*32, Settings.worldWidth*32, BufferedImage.TYPE_INT_RGB);
		renderMap();
	}
	public void renderMap(Graphics g){
		g.drawImage(view, Chunk.offset.getIntX(), Chunk.offset.getIntY(), null);
	}
	private void renderMap(){
		//view = new BufferedImage(50*32, 50*32, BufferedImage.TYPE_INT_RGB);
		Graphics imageWriter = view.createGraphics();
		for(int r = 0; r < Settings.worldHeight; r++){
			for(int c = 0; c < Settings.worldWidth; c++){
				imageWriter.drawImage(spriteLayer.getEntityAt(r, c).getImage(), c * 32, r * 32, null);
			}
		}
	}
}
