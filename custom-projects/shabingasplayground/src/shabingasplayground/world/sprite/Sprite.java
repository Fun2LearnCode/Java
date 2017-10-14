package shabingasplayground.world.sprite;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import shabingasplayground.block.BlockType;
import shabingasplayground.world.GridEntity;

public class Sprite extends GridEntity<Sprite>{
	public Image sprite;
	public Sprite(BlockType type){
		if(type == BlockType.GRASS){
			try {
				sprite =  ImageIO.read(new File("grass.png"));
			} catch (IOException e) {
				System.out.println("Grass Block Not Found");
			}
		}else if(type == BlockType.AIR){
			try {
				sprite =  ImageIO.read(new File("air.png"));
			} catch (IOException e) {
				System.out.println("Air Block Not Found");
			}
		}else if(type == BlockType.DIRT){
			try {
				sprite =  ImageIO.read(new File("dirt.png"));
			} catch (IOException e) {
				System.out.println("Dirt Block Not Found");
			}
		}
	}
	public BufferedImage getImage(){
		return (BufferedImage) sprite;
	}
}
