package shabingasplayground.world.event;

import java.util.ArrayList;

import shabingasplayground.block.Block;

public class WorldEventSubscriber {
	private static ArrayList<BlockListener> blockListeners = new ArrayList<BlockListener>();
	private static ArrayList<ChunkListener> chunkListeners = new ArrayList<ChunkListener>();
	public static void subscribe(ChunkListener listener){
		chunkListeners.add(listener);
	}
	public static void subscribe(BlockListener listener){
		blockListeners.add(listener);
	}
	public static void changeBlock(Block oldBlock, Block newBlock){
		for(BlockListener listener : blockListeners){
			listener.onBlockChange(oldBlock, newBlock);
		}
	}
	public static void changeChunk(){
		for(ChunkListener listener : chunkListeners){
			listener.onChunkChange();
		}
	}
}
