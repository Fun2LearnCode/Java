package shabingasplayground.world;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import shabingasplayground.block.BlockAir;
import shabingasplayground.block.BlockDirt;
import shabingasplayground.block.BlockGrass;
import shabingasplayground.gui.GameFrame;
import shabingasplayground.settings.Settings;
import shabingasplayground.world.block.BlockLayer;
import shabingasplayground.world.sprite.SpriteLayer;

public class World {
	private BlockLayer blockLayer;
	private SpriteLayer spriteLayer;
	public World(String fileLocation){
		blockLayer = new BlockLayer();
		try {
			BufferedImage img = ImageIO.read(new File(fileLocation));
			for(int r = 0; r < Settings.worldHeight; r++){
				for(int c = 0; c < Settings.worldWidth; c++){
					if(img.getRGB(c,r) ==-10960640){ //green
						blockLayer.setEntityAt(r,c, new BlockGrass());
					}else if(img.getRGB(c,r) == -16777216){ //black
						blockLayer.setEntityAt(r,c, new BlockAir());
					}else if(img.getRGB(c,r) == -65536){ //red
						blockLayer.setEntityAt(r,c, new BlockDirt());
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		spriteLayer = new SpriteLayer(blockLayer);
		
		 JFrame ex = new GameFrame(spriteLayer);
         ex.setVisible(true);
	}
}
