package shabingasplayground.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import shabingasplayground.vector.Vector2;
import shabingasplayground.world.chunk.Chunk;
import shabingasplayground.world.sprite.SpriteLayer;

public class GameFrame extends JFrame implements KeyListener{
	private static final long serialVersionUID = 1L;
	private Vector2 testMovement;
	public GameFrame(SpriteLayer spriteLayer){
		testMovement = new Vector2(25,25);
		addKeyListener(this);
	    add(new GameDisplay(spriteLayer));
	    setFocusable(true);
	    pack();
	}

	@Override
	public void keyPressed(KeyEvent key) {
		System.out.println("pressing keys");
		if(key.getKeyCode() == KeyEvent.VK_W){ // up
			testMovement.move(0,-4);
		}else if(key.getKeyCode() == KeyEvent.VK_A){ // left
			testMovement.move(-4,0);
		}else if(key.getKeyCode() == KeyEvent.VK_S){ // down
			testMovement.move(0,4);
		}else if(key.getKeyCode() == KeyEvent.VK_D){ // right
			testMovement.move(4,0);
		}
		System.out.println(testMovement);
		Chunk.recenterChunk(testMovement);
		System.out.println("Chunk Start : "+ Chunk.chunkStart + " Chunk End : " + Chunk.chunkEnd);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
