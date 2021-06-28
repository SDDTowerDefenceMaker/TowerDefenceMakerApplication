package frontEnd;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
	
	JFrame frame;
	
    public GUI(int x, int y) {
		
    	setTitle("Tower Defence Maker");
    	setSize(new Dimension(1600, 900));
    	setLocationRelativeTo(null);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	//Container container = this.getContentPane();
    	//Scene homepage = new Scene();
    	//container.add(homepage.getPanel());
    	init(x, y);
    	
    }
    
    public void init(int x, int y) {
    	
    	setLayout(new GridLayout(1,1,0,0));
    	
    	Scene scene = new Scene(x, y);
    	add(scene);
    	
    	setVisible(true);
    	
    }
    
	/*public static void main(String[] agrs){
		GUI new_game = new GUI(24, 13);
		
	}	
	*/
}
