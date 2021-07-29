package frontEnd;

import javax.swing.*;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
	
	public static int width = 1600;
	public static int height = 900;
	JFrame frame;
	
    public GUI(int x, int y) {
    	int screen_height = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
    	if (screen_height == 720) {
			height = 540;
			width = 960;
		}
    	if (screen_height == 900) {
			height = 720;
			width = 1280;
		}
    	if (screen_height >= 1080) {
			height = 900;
			width = 1600;
		}
    	setTitle("Tower Defence Maker");
    	setSize(new Dimension(width, height));
    	setLocationRelativeTo(null);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	init(x, y);
    	
    }
    
    public void init(int x, int y) {
    	
    	setLayout(new GridLayout(1,1,0,0));
    	
    	Scene scene = new Scene(this, x, y);
    	add(scene);
    	
    	setVisible(true);
    	
    }
    

//	public static void main(String[] args){
//		new LwjglApplication(new GUI(24,13), "Castle Rush", 480*2, 320*2);
//		//GUI new_game = new GUI(24, 13);
//		
//	}	
	

}
