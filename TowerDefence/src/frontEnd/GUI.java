package frontEnd;
import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{
	
    public GUI() {
    	setTitle("Tower Defence Maker");
    	setSize(new Dimension(1600, 900));
    	setLocationRelativeTo(null);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	//Container container = this.getContentPane();
    	//Scene homepage = new Scene();
    	//container.add(homepage.getPanel());
    	init();
    	
    }
    
    public void init() {
    	setLayout(new GridLayout(1,1,0,0));
    	
    	Scene scene = new Scene();
    	add(scene);
    	
    	setVisible(true);
    	
    }
    
	public static void main(String[] agrs){
		GUI frame = new GUI();
		
	}	
}
