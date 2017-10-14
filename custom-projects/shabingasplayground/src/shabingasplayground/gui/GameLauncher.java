package shabingasplayground.gui;

import java.awt.EventQueue;


import shabingasplayground.world.World;

public class GameLauncher {
	public static void main(String[] args) {
		 EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new World("Map.png");
	            }
	        });
	}
}
