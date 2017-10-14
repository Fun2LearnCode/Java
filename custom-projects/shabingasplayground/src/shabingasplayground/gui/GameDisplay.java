package shabingasplayground.gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import shabingasplayground.settings.Settings;
import shabingasplayground.world.sprite.SpriteLayer;

public class GameDisplay extends JPanel implements Runnable{
	private static final long serialVersionUID = 1L;
	private RenderHandler renderHandler;
	public GameDisplay(SpriteLayer spriteLayer){
		renderHandler = new RenderHandler(spriteLayer);
		setPreferredSize(Settings.screenDimension);
		setDoubleBuffered(true);
		Thread t = new Thread(this);
		t.start();
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		renderHandler.renderMap(g);
	} 
	@Override 
	public void run(){
		while(true){
			try {
				Thread.sleep(20);
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
