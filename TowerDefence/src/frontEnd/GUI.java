package frontEnd;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
	
	public static int width = 1600;
	public static int height = 900;
	JFrame frame;
	
    public GUI(int x, int y) {
		
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
    
	/*public static void main(String[] args){
		GUI new_game = new GUI(24, 13);
		
	}	
	*/
}
