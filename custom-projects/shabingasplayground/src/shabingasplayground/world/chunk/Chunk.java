package shabingasplayground.world.chunk;

import shabingasplayground.settings.Settings;
import shabingasplayground.vector.Vector2;
import shabingasplayground.world.event.WorldEventSubscriber;

public class Chunk {
	public static Vector2 chunkStart = new Vector2(0f,00f);
	public static Vector2 chunkEnd = new Vector2(50f, 50f);
	public static Vector2 offset = new Vector2(0f, 0f);
	public static void recenterChunk(Vector2 centerPoint){
		if(chunkStart.distanceTo(centerPoint) + chunkEnd.distanceTo(centerPoint) > 40){
			float startX = -1;
			float startY = -1;
			float endX = -1;
			float endY = -1;
			if(centerPoint.getX() - 25 < 0){
				startX = 0;
				endX = 50;
			}else if(centerPoint.getX() + 25 > Settings.worldWidth*32){
				startX = Settings.worldWidth*32 - 50;
				endX = Settings.worldWidth*32;
			}else{
				startX = centerPoint.getX() - 25;
				endX = centerPoint.getX() + 25;
			}
			if(centerPoint.getIntY() - 25 < 0){
				startY = 0;
				endY = 50;
			}else if(centerPoint.getY() + 25 > Settings.worldHeight*32){
				startY = Settings.worldHeight*32 - 50;
				endY = Settings.worldHeight*32;
			}else{
				startY = centerPoint.getY() - 25;
				endY = centerPoint.getY() + 25;
			}
			Chunk.chunkStart = new Vector2(startX, startY);
			Chunk.chunkEnd = new Vector2(endX,endY);
			Chunk.offset = new Vector2(-1*startX, -1*startY);
		}
		WorldEventSubscriber.changeChunk();
	}
}
