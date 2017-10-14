package shabingasplayground.world;

import shabingasplayground.block.BlockType;
import shabingasplayground.world.sprite.Sprite;

public class MapSprite {
	private Sprite[][] sprites;
	
	public MapSprite(){
		sprites = new Sprite[100][400];
		for(int r = 0; r < sprites.length; r++){
			for(int c = 0; c < sprites[r].length; c++){
				if(r > 64){
					sprites[r][c] = new Sprite(BlockType.GRASS);
				}
			}
		}
	}
}
